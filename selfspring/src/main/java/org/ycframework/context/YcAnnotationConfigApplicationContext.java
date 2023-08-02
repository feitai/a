package org.ycframework.context;

import com.yc.UserBiz;
import com.yc.UserBizImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.stereotype.Component;
import org.ycframework.annotation.*;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static javax.xml.soap.SOAPConnectionFactory.newInstance;

/**
 * Description: YcAnnotationConfigApplicationContext
 * Author: heyv
 * Time: 2023 2023/7/27 16:00
 */
public class YcAnnotationConfigApplicationContext implements YcApplicationContext{
    private Logger logger = LoggerFactory.getLogger(YcAnnotationConfigApplicationContext.class);
    //存每个托管bean的定义信息
    private Map<String, YcBeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, YcBeanDefinition>();
    //存每个实例化的bean
    private   Map<String, Object> beanMap = new ConcurrentHashMap<String, Object>();
    //存系统属性  ，db.properties
    private  Properties pros = new Properties();

    public YcAnnotationConfigApplicationContext(Class...configClasses){
        try{
        //读取系统信息属性
        pros = System.getProperties();
        List<String> toScanPackagePath = new ArrayList<String>();
        for (Class cls: configClasses){
            if(cls.isAnnotationPresent(YcComponentScan.class)==false){
                continue;
            }
            String[] basePackages = null;
            if (cls.isAnnotationPresent(YcComponentScan.class)){
                //如果有，则说明，，此配置上有YcComponentScan，读取 backpackages
            YcComponentScan ycComponentScan =  (YcComponentScan)  cls.getAnnotation(YcComponentScan.class);
             basePackages = ycComponentScan.basePackage();
            if(basePackages==null || basePackages.length<=0){
                basePackages = new String[1];
             basePackages[0]  = cls.getPackage().getName();
            }
            logger.info("Base packages: " + basePackages[0]);
            }
            //扫描配置类，形成YcBeanDefinition
            recursiveLoadBeanDefinition (basePackages);
        }
        //创建Bean,(考虑多种情况，是否是懒加载 ，是否是单例)
        createBean();
        //循环所有托管的Bean(带@Autowire,@Resopse,@Value,将这些包带有dic的进行注入
            doDi();
    }catch (Exception e){
    e.printStackTrace();
        }
    }

    private void  doDi() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        //循环的是 beanMap 这是托管Bean
        for (Map.Entry<String,Object> entry : beanMap.entrySet()) {
            String beanId = entry.getKey();
            Object beanObj=entry.getValue();
            //情况一  属性上有@YcResource
            Field [] fields = beanObj.getClass().getDeclaredFields();
            for (Field field : fields) {
                if(field.isAnnotationPresent(YcResource.class)) {
                    YcResource ycResource = (YcResource)field.getAnnotation(YcResource.class);
                    String toDiBeanId = ycResource.name();
                    Object obj = getToDiBean(toDiBeanId);
                    field.setAccessible(true);
                    field.set(beanObj, obj);
                }
            }

        }
    }

    private Object getToDiBean(String toDiBeanId) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        if( beanMap.containsKey(toDiBeanId) ){
            return beanMap.get(toDiBeanId);
        }
        //判断 beanMap 没有bean 是否是因为lazy
        if(! beanDefinitionMap.containsKey(toDiBeanId) ){
            throw new RuntimeException("spring容器未加载该bean"+toDiBeanId);
        }
        YcBeanDefinition bd = beanDefinitionMap.get(toDiBeanId);
        if(bd.isLazy()){
            //因为是懒模式，所以未托管
            String classPath = bd.getClassInfo();
            Object beanObj = Class.forName(classPath).newInstance();
            beanMap.put(toDiBeanId, beanObj);
            return beanObj;
        }
        return null;
    }

    private void createBean () throws Exception {

        //读取beanDefinitionMap的信息，然然后根据信息创建Bean，将其存入map中
        for(Map.Entry<String,YcBeanDefinition> entry :beanDefinitionMap.entrySet()) {
            String beanId = entry.getKey();
            System.out.println(beanId);
            YcBeanDefinition ybd = entry.getValue();
            //非懒加载模式和非原型模式，将该Bean加入BeanMap
            if(!ybd.isLazy() && !ybd.getScope().equalsIgnoreCase("prototype")) {
                String classInfo = ybd.getClassInfo();
                System.out.println(classInfo);
                Object obj = Class.forName(classInfo).newInstance();
                beanMap.put(beanId, obj);
                System.out.println("Spring托管了" + beanId +"==>"+ classInfo);
                logger.trace("Spring托管了" + beanId +"==>"+ classInfo);
            }
        }
    }

    private void recursiveLoadBeanDefinition(String[] basePackages) {
        for (String basePackage : basePackages) {
         String  packagePath = basePackage.replaceAll("\\.","/");
         //扫描的是 //target/ classes
            Enumeration<URL> files = null;
            try {
                files = Thread.currentThread().getContextClassLoader().getResources( packagePath);

                while (files.hasMoreElements()) {
                    URL url = files.nextElement();
                    logger.trace("当前正在递归"+url.getFile());
                    findPackageClasses(url.getFile(),basePackage);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    private void findPackageClasses(String packagePath, String basePackage) {

        if(packagePath.startsWith("/")){
            packagePath = packagePath.substring(1);
        }
        File file = new File(packagePath);

        File [] classFiles =  file.listFiles(new FileFilter() {

            @Override
            public boolean accept(File pathname) {
                if(pathname.getName().endsWith(".class") || pathname.isDirectory()){
                    return true;
                }
                return false;
            }
        });
        if(classFiles == null || classFiles.length<=0){
            return;
        }
        for(File f : classFiles){
            if(f.isDirectory()){
                findPackageClasses(f.getAbsolutePath(), basePackage + "." + f.getName().replaceAll(".class", ""));
            }else {
                //是class文件，取出此文件，判断class是否含有@Component 或者间接含有@Component的类
                URLClassLoader uc = new URLClassLoader(new URL[]{});
                Class cls  = null;
                try {
                    cls = uc.loadClass(basePackage + "."+f.getName().replaceAll(".class", ""));
                    if(cls.isAnnotationPresent(YcComponent.class)
                            || cls.isAnnotationPresent(YcService.class)
                            || cls.isAnnotationPresent(YcRepository.class)
                            || cls.isAnnotationPresent(YcConfiguration.class)
                            || cls.isAnnotationPresent(YcController.class)){
                        logger.info("Loading了一个待加载的类"+cls.getName());
                        YcBeanDefinition bd = new YcBeanDefinition();
                        if (cls.isAnnotationPresent(YcLazy.class)){
                            bd.setLazy(true);
                        }
                        if (cls.isAnnotationPresent(YcScope.class)){
                            YcScope ycScope = (YcScope) cls.getAnnotation(YcScope.class);
                            String scope = ycScope.value();
                            bd.setScope(scope);
                        }
                        bd.setClassInfo( cls.getName().replaceAll(".class", ""));
                        //存入YcBeanDefinitionMap 中，取Beanid
                        String baseId = getBeanId(cls);
                        this.beanDefinitionMap.put(baseId, bd);

                }

            }catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
/**
 *

 获取一个待托管的 Bean的类的 beanId
 */
    private String getBeanId(Class cls) {
        YcComponent  ycComponent = (YcComponent)cls.getAnnotation(YcComponent.class);
        YcController ycController = (YcController)cls.getAnnotation(YcController.class);
        YcService ycService = (YcService) cls.getAnnotation(YcService.class);
        YcRepository ycRepository = (YcRepository)cls.getAnnotation(YcRepository.class);


        YcConfiguration ycConfiguration = (YcConfiguration)cls.getAnnotation(YcConfiguration.class);

        if(ycConfiguration !=null){
            return cls.getSimpleName();   //全路径名
        }
        String beanId = null;
        if(ycComponent != null){
            beanId = ycComponent.value();
        }
        if(ycController != null){
            beanId = ycController.value();
        }
        if(ycRepository != null){
            beanId = ycRepository.value();
        }
        if(ycService != null){
            beanId = ycService.value();
        }
        if(beanId == null || "".equals(beanId)){
            String typeName = cls.getSimpleName();
            beanId = typeName.substring(0,1).toLowerCase() + typeName.substring(1);
        }
        return beanId;
    }

//    @Override
//    public Object getBean(String beanId) {
//        //首先，先从beanMap中寻找该Bean，存在直接返回实例化的对象，否则执行下一步骤
//        if (beanMap.containsKey(beanId)) {
//            return beanMap.get(beanId);
//        }
//        //在beanDefinitionMap寻找，确认该Bean是否被容器加载
//        if (!beanDefinitionMap.containsKey(beanId)) {
//            throw new RuntimeException("Spring容器未加载该bean：" + beanId);
//        }
//
//        YcBeanDefinition bd = beanDefinitionMap.get(beanId);
//        if (bd.isLazy()) {
//            // 因为是懒加载模式，所以先创建并托管该Bean
//            try {
//                String classPath = bd.getClassInfo();
//                Object beanObj = Class.forName(classPath).newInstance();
//                beanMap.put(beanId, beanObj);
//                //TODO：需注意  一定要执行doDi()方法，否则虽然 beanMap 中含有该Bean 但是没有注入，所以返回的依然是一个null
//                doDi();
//                return beanMap.get(beanId);
//            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
//                throw new RuntimeException("创建并托管Bean时出现异常：" + e.getMessage());
//            }
//        } else {
//            /*
//            TODo
//                非懒加载模式，直接创建并托管该Bean
//                这种情况下除了懒模式，还包括以下几种：
//                                          1.延迟初始化
//                                          2. 条件化Bean（   @Conditional  ）
//                                          3.动态Bean加载 （ BeanDefinitionRegistry 接口）
//             */
//            try {
//                String classPath = bd.getClassInfo();
//                Object beanObj = Class.forName(classPath).newInstance();
//                beanMap.put(beanId, beanObj);
//                //TODO：需注意  一定要执行doDi()方法，否则虽然 beanMap 中含有该Bean 但是没有注入，所以返回的依然是一个null
//                doDi();
//                return beanMap.get(beanId);
//            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
//                throw new RuntimeException("创建并托管Bean时出现异常：" + e.getMessage());
//            }
//        }
//    }

    @Override
    public Object getBean(String beanId){
        YcBeanDefinition bd = this.beanDefinitionMap.get(beanId);
        if(bd == null) {
            throw new RuntimeException("容器中未加载该Bean");
        }
        String scope = bd.getScope();
        if("prototype".equalsIgnoreCase(scope)) {
            Object obj = null;
            try {
                obj = Class.forName(bd.getClassInfo()).newInstance();
                return obj;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
            if(this.beanMap.containsKey(beanId)){
                return this.beanMap.get(beanId);
            }
            if(bd.isLazy()){
                Object obj = null;
                try {
                    obj=Class.forName(bd.getClassInfo()).newInstance();
                    this.beanMap.put(beanId, obj);
                    doDi();
                    return obj;
                }catch (Exception e){
                    e.printStackTrace();
                }
                return obj;
            }

        return null;
    }

}

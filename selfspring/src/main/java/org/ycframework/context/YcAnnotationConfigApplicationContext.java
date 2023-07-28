package org.ycframework.context;

import com.yc.UserBiz;
import com.yc.UserBizImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.ycframework.annotation.*;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;

/**
 * Description: YcAnnotationConfigApplicationContext
 * Author: heyv
 * Time: 2023 2023/7/27 16:00
 */
public class YcAnnotationConfigApplicationContext implements YcApplicationContext{
    private Logger logger = LoggerFactory.getLogger(YcAnnotationConfigApplicationContext.class);
    //存每个托管bean的定义信息
    private Map<String, YcBeanDefinition> beanDefinitions = new HashMap<String, YcBeanDefinition>();
    //存每个实例化的bean
    private   Map<String, Object> beanMap = new HashMap<String, Object>();
    //存系统属性  ，db.properties
    private  Properties pros = new Properties();

    public YcAnnotationConfigApplicationContext(Class...configClasses){

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

        //循环所有托管的Bean(带@Autowire,@Resopse,@Value,将这些包带有dic的进行注入
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
                findPackageClasses(f.getAbsolutePath(), basePackage + "." + f.getName());
            }else {
                //是class文件，取出此文件，判断class是否含有@Component
                URLClassLoader uc = new URLClassLoader(new URL[]{});
                Class cls  = null;
                try {
                    cls = uc.loadClass(basePackage + "."+f.getName().replaceAll(".class", ""));
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                if(cls.isAnnotationPresent(YcComponent.class)
                || cls.isAnnotationPresent(YcService.class)
                || cls.isAnnotationPresent(YcRepository.class)
                || cls.isAnnotationPresent(YcConfiguration.class)
                || cls.isAnnotationPresent(YcController.class)){
                logger.info("Loading了一个待加载的类"+cls.getName());
            }
            }
        }
    }

    @Override
    public Object getBean(String beanId) {

        return  null;
    }
}

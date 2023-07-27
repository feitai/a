package org.ycframework.context;

import com.yc.UserBiz;
import com.yc.UserBizImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.ycframework.annotation.YcComponentScan;

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
                return;
            }
            if (cls.isAnnotationPresent(YcComponentScan.class)){
                //如果有，则说明，，此配置上有YcComponentScan，读取 backpackages
            YcComponentScan ycComponentScan =  (YcComponentScan)  cls.getAnnotation(YcComponentScan.class);
            String[] basePackages = ycComponentScan.basePackage();
            if(basePackages==null || basePackages.length<=0){
                basePackages = new String[1];
             basePackages[0]  = cls.getPackage().getName();
            }
            logger.info("Base packages: " + basePackages[0]);
            }
        }
        //扫描配置类

        //将这些包带有dic的进行注入
    }

    @Override
    public Object getBean(String beanId) {

        return  null;
    }
}

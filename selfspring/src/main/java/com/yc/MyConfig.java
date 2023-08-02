package com.yc;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.ycframework.annotation.YcComponentScan;
import org.ycframework.annotation.YcConfiguration;

/**
 * Description: MyConfig
 * Author: heyv
 * Time: 2023 2023/7/27 15:14
 */
@YcConfiguration
@YcComponentScan(basePackage ={ "com.yc"})
@EnableAspectJAutoProxy   //启用aspectj 支持
public class MyConfig {

}

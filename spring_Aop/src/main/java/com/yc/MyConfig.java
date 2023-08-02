package com.yc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Description: MyConfig
 * Author: heyv
 * Time: 2023 2023/7/29 16:44
 */
@Configuration
@ComponentScan(value = "com.yc")
@EnableAspectJAutoProxy
public class MyConfig {
}

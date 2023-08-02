package com.yc.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * Description: HelloWorldAspect
 * Author: heyv
 * Time: 2023 2023/7/29 16:18
 */
//@Component
//@Aspect
//@Order(2)
public class HelloWorldAspect {
    //切入点表达式,
    @Pointcut("execution(* com.yc..add*(..))")
    private  void abc(){}
    //声明增强-- 前置 -- 返回前 --抛出异常的--
    @Before("abc()")

    public void doAccessCheck() {
        System.out.println("后运行");
    }
}

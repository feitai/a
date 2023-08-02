package com.yc.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Description: HelloWorldAspect1
 * Author: heyv
 * Time: 2023 2023/7/29 19:05
 */
//@Component
//@Aspect

public class HelloWorldAspect1 implements Ordered {
    //切入点表达式,
    @Pointcut("execution(* com.yc..add*(..))")
    private  void abc(){}
    //声明增强-- 前置 -- 返回前 --抛出异常的--
    @Before("abc()")

    public void doAccessCheck() {
        System.out.println("先运行");
    }

    @Override
    public int getOrder() {
        return 1;
    }
}

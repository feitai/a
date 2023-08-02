package com.yc.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;

/**
 * Description: RateAspect
 * Author: heyv
 * Time: 2023 2023/7/29 20:06
 */
//@Component
//@Aspect
//@Order(100)
public class RateAspect {
    @Pointcut("execution(* com.yc..*(..))")
            public void abc(){};
    @Around(value = "abc()")
    public Object RateAspect(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("reatAspect进入。。。。。。");
       long startTime = System.currentTimeMillis();
        Object obj = pjp.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println("reatAspectx运行时长为-----"+(endTime-startTime));
        return obj;
    }
}

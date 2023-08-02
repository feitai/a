package com.yc.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Description: TestAspect
 * Author: heyv
 * Time: 2023 2023/7/29 19:36
 * 测试returning增强
 */  //可以取到返回值
//@Component
//@Aspect
//@Order(1)
public class TestAspect {
    @Pointcut("execution(* com.yc..*(..))")
    public void abc(){}
//    @AfterReturning(value = "abc()"  ,returning = "retVal")
//    public void returning(Object retVal){
//        System.out.println("returning"+retVal.toString());
//        System.out.println(retVal.toString());
//    }



//    @AfterThrowing(value = "abc()",throwing = "ex" )
//    public void AfterThrowing(RuntimeException ex){
//        System.out.println("被增强的方法有异常爆出"+ex);
//    }

//@After(value = "abc()" )
//public void After(){
//    System.out.println("After,只要方法执行完毕，一定会执行该增强，不管是否有异常！！！");
//}
    //
    @Around(value = "abc()" )
    public Object Around(ProceedingJoinPoint pjp){
        System.out.println("环绕增强在原方法前的代码！！！");
            //调用连接点的代码
        Object obj = null;
        try {
            obj = pjp.proceed();   //调用原方法
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        System.out.println("环绕增强在原方法后的代码！！！");
        return obj;
    }
}

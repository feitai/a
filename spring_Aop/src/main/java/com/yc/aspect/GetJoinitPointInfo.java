package com.yc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: GetJoinitPointInfo
 * Author: heyv
 * Time: 2023 2023/7/29 19:14
 */
//获取增加的连接点的信息
@Component
@Aspect
public class GetJoinitPointInfo {

   @Pointcut("execution(* com.yc..*(..))") // 该注解只支持方法
    private void abc(){}
    @Before("abc()")  //获取连接点的信息
    @Order(value = 1)
    public void showInfo(JoinPoint jp) throws InterruptedException {
       Thread.sleep(2000);
        System.out.println("连接点的信息如下"+jp.toString());
        System.out.println("目标类："+jp.getTarget()+"方法的签名: "+jp.getSignature());

        System.out.println("加了增强的方法的参数值：");

        Object[] objs = jp.getArgs();
        if(objs!=null && objs.length>0){
            for(Object o : objs){
                System.out.println(o.toString());
            }
        }
    }
//    @Pointcut("execution(* com.yc..*(..))") // 该注解只支持方法
//    private  void a(){}
//    private Map<String,Long> map = new HashMap<String,Long>();
//    @AfterReturning(value = "a()")
//    public  void record(JoinPoint jp){
//
//        Object[] objs = jp.getArgs();
//        String[] stringObjs = new String[objs.length];
//        for (int i = 0; i < objs.length; i++) {
//            stringObjs[i] = String.valueOf(objs[i]);
//        }
//        Long num=0L;
//        for (String obj : stringObjs){
//            if(!map.containsKey(obj)){
//                map.put(obj,0L);
//            }
//            if(map.containsKey(obj)){
//                num= map.get(obj);
//                num++;
//                map.put(obj,num);
//            }
//            System.out.println("当前统计数为"+obj+":"+map.get(obj));
//        }
//    }
//
//    @Pointcut("execution(* com.yc..*(..))") // 该注解只支持方法
//    private  void b(){}

//    @AfterThrowing(value = "b()",throwing = "ex")
//    public void wrong( RuntimeException ex){
//        System.out.println("输入名字异常，重新输入");
//    }

    @Pointcut("execution(* com.yc..*(..))")
    // 该注解只支持方法
    public void b(){}
    @Around(value = "b()")
    @Order(value = 100)
    public  Object around(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        System.out.println("环绕切面。。。。。。");

        Object obj = pjp.proceed();

        long endTime = System.currentTimeMillis();
        System.out.println("运行时间是:"+(endTime-startTime));

        return obj;

    }

}

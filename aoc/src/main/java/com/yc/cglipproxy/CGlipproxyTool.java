package com.yc.cglipproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Description: CGlipproxyTool
 * Author: heyv
 * Time: 2023 2023/8/1 20:56
 */
public class CGlipproxyTool  implements MethodInterceptor {
 private    Object traget ;
 public CGlipproxyTool(Object traget){
     this.traget = traget;
 }


 public Object createProxt(){
     Enhancer enhancer = new Enhancer();
     enhancer.setSuperclass(this.traget.getClass());
     enhancer.setCallback(this);
     Object proxy = enhancer.create();
     return proxy;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
       if(method.getName().contains("add")){
           sayHello();
       }
       Object returnValue = method.invoke(traget,args);
        return returnValue;
    }
    public  void sayHello(){
        System.out.println("Hello World!!!");
    }
}

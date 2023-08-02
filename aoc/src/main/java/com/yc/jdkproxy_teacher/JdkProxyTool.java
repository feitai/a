package com.yc.jdkproxy_teacher;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Description: JdkProxyTool
 * Author: heyv
 * Time: 2023 2023/8/1 19:18
 */
public class JdkProxyTool implements InvocationHandler {

    private Object traget;

    public JdkProxyTool(Object obj) {
        this.traget = obj;
    }

    public Object createProxy(){
        Object proxy = Proxy.newProxyInstance(JdkProxyTool.class.getClassLoader(), this.traget.getClass().getInterfaces(),this);

        return proxy;


    }
    //在主程序中调用生成的Proxy的方法时，会自动调用这个回调方法，在invok（）调用增强方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.toString().contains("add")){
            System.out.println("Hello World!");
        }



      Object returnValue =  method.invoke(traget,args);

        if(method.toString().contains("find")){
            System.out.println("Bye!");
        }

        return returnValue;
    }
}

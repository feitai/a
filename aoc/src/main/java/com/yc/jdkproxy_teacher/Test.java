package com.yc.jdkproxy_teacher;

import com.yc.jdkproxy_self.Helloi;


/**
 * Description: Test
 * Author: heyv
 * Time: 2023 2023/8/1 18:48
 */
public class Test {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        JdkProxyTool jdkProxyTool = new JdkProxyTool(new OrderBizImpl());
        Object proxy =  jdkProxyTool.createProxy();

        OrderBiz hi = (OrderBiz) proxy;

        hi.add(3,9);

        hi.find();

    }
}

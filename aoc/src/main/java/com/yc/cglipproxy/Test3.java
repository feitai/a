package com.yc.cglipproxy;

import com.yc.jdkproxy_self.HelloImpl;

/**
 * Description: Test3
 * Author: heyv
 * Time: 2023 2023/8/1 21:17
 */
public class Test3 {
    public static void main(String[] args) {
        CGlipproxyTool cGlipproxyTool = new CGlipproxyTool(new OrderBizImpl());
        OrderBizImpl orderBizImpl = (OrderBizImpl) cGlipproxyTool.createProxt();
        System.out.println("生成了代理对象"+orderBizImpl);

        orderBizImpl.add(2,9);

        orderBizImpl.find();

    }
}

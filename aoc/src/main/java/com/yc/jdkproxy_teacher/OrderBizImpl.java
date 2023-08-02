package com.yc.jdkproxy_teacher;

/**
 * Description: OrderBizImpl
 * Author: heyv
 * Time: 2023 2023/8/1 18:43
 */
public class OrderBizImpl implements OrderBiz {
    @Override
    public void add(int pid, int num) {
        System.out.println("添加订单："+pid+"数量为："+num+"");
    }

    @Override
    public void find() {
        System.out.println("Finding>>>>>>");
    }
}

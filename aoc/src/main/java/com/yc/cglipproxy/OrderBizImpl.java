package com.yc.cglipproxy;

import com.yc.jdkproxy_teacher.OrderBiz;

/**
 * Description: OrderBizImpl
 * Author: heyv
 * Time: 2023 2023/8/1 18:43
 */
public class OrderBizImpl  {

    public void add(int pid, int num) {
        System.out.println("添加订单："+pid+"数量为："+num+"  ");
    }


    public void find() {
        System.out.println("Finding>>>>>>");
    }
}

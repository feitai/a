package com.yc;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Description: UserImpl
 * Author: heyv
 * Time: 2023 2023/7/29 16:46
 */
@Component
public class UserImpl implements User{
    @Override
    public String add(String name ,String name1,String name2) throws InterruptedException {

        int r  = new Random().nextInt(2);
        if (false){
            throw  new RuntimeException();
        }
        Thread.sleep(2000);
        System.out.println("Adding"+name);
        return null;

    }

    @Override
    public String showAll() {
        System.out.println("Show All");
        return "Show All";

    }

    @Override
    public void add1() {
        System.out.println("Adding01");

    }

    @Override
    public void add2() {
        System.out.println("Adding02");
    }
}

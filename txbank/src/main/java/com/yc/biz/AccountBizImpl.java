package com.yc.biz;

import org.springframework.stereotype.Component;

/**
 * Description: AccountBizImpl
 * Author: heyv
 * Time: 2023 2023/8/2 14:17
 */
@Component
public class AccountBizImpl implements AccountBiz{
    @Override
    public String addAccount(String name) {
        System.out.println("Adding________________________");
        return name;
    }
}

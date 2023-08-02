package com.yc;

import org.springframework.context.ApplicationContext;
import org.ycframework.annotation.YcRepository;

/**
 * Description: UserDao
 * Author: heyv
 * Time: 2023 2023/7/27 15:53`
 */
@YcRepository
public class UserDaoImpl implements UserDao {
    @Override
    public void add (String uname) {
        System.out.println("dao添加了"+uname);
    }

    public void showAll(){
        System.out.println("Show all users");
    }


}

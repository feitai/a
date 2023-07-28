package com.yc;

import org.ycframework.annotation.YcLazy;
import org.ycframework.annotation.YcResource;
import org.ycframework.annotation.YcService;

/**
 * Description: UserBizImpl
 * Author: heyv
 * Time: 2023 2023/7/27 15:56
 */
@YcService
@YcLazy
public class UserBizImpl implements UserBiz{

    @YcResource(name="userDaoImpl")
    private UserDao userDao;
    @Override
    public void add(String uname) {
        userDao.add(uname);
    }
}

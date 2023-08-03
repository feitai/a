package com.yc.dao;

import com.yc.bean.Account;
import com.yc.configs.Config;
import com.yc.configs.DataSourceConfig;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Description: AccountDaoJdbcTemplateTest
 * Author: heyv
 * Time: 2023 2023/8/3 10:54
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class, DataSourceConfig.class,})
@Log4j2
public class AccountDaoJdbcTemplateTest {
    @Autowired
    private  AccountDao accountDao;


    @Test
    public void update(){
        accountDao.update(2,10);
    }

    @Test
    public void findCount(){
        int total = this.accountDao.findCount();
        Assert.assertEquals(7, total);
    }
    @Test
    public void findAll() {
        List<Account> list = this.accountDao.findAll();
        log.info(list);
    }

    @Test
    public void findById() {
        int accountId = 2; // Assuming accountId is an integer
        Account account = this.accountDao.findById(accountId);
        log.info(account);
    }

    @Test
    public void insert() {
        double money = 100; // Assuming money is a double
        int accountId = accountDao.insert(money);
        log.info("新开户为：" + accountId);
        Assert.assertNotNull(accountId);
    }

    @Test
    public void delete() {
        int accountId = 1; // Assuming accountId is an integer
        accountDao.delete(accountId);
    }

}

package com.yc;

import com.yc.biz.AccountBiz;
import com.yc.configs.Config;
import junit.framework.TestCase;

import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Description: Test1
 * Author: heyv
 * Time: 2023 2023/8/2 14:14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
@Log4j2
public class Test1 extends TestCase {

   @Autowired
    private AccountBiz accountBiz;
   @Test
    public void test1() throws Exception {
       Assert.assertEquals("test1", accountBiz.addAccount("test1"));

       Assert.assertEquals(1, 1);




   }



}
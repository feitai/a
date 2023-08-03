package com.yc;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Description: TestSuit
 * Author: heyv
 * Time: 2023 2023/8/2 15:35
 */
//Suit测试套件，按顺序执行多个测试
@RunWith(Suite.class)
@Suite.SuiteClasses({Test1.class, test2DateSourseConfig.class})
public class TestSuit {

}

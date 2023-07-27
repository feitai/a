package org.ycframework;

import com.yc.MyConfig;
import com.yc.UserBiz;
import org.ycframework.context.YcAnnotationConfigApplicationContext;
import org.ycframework.context.YcApplicationContext;

/**
 * Description: TestMain3
 * Author: heyv
 * Time: 2023 2023/7/27 16:12
 */
public class TestMain3 {
    public static void main(String[] args) {
        YcApplicationContext ac = new YcAnnotationConfigApplicationContext(MyConfig.class);
//        UserBiz ub = (UserBiz)ac.getBean("userBizImpl");
//        ub.add("李四");
    }
}

package com.yc;

/**
 * Description: ${NAME}
 * Author: heyv
 * Time: 2023 2023/8/2 14:04
 */
import com.yc.bean.Account;
import com.yc.biz.AccountBiz;
import com.yc.configs.Config;
import com.yc.configs.DataSourceConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

public class Main {

    public static void main(String[] args) {
        // 创建ApplicationContext
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class, DataSourceConfig.class);

        // 获取需要测试的Bean
        AccountBiz accountBiz = context.getBean(AccountBiz.class);

        // 获取PlatformTransactionManager
        PlatformTransactionManager transactionManager = context.getBean(PlatformTransactionManager.class);

        // 使用TransactionTemplate来管理事务
        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);

        // 执行测试方法
        transactionTemplate.execute(new TransactionCallback<Void>() {
            @Override
            public Void doInTransaction(TransactionStatus status) {
                // 在事务中调用测试方法
                Account a = accountBiz.withdrow(2, 20);
                System.out.println(a);
                return null;
            }
        });
    }
}

package springtest4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springtest4.Config;
import springtest4.user.BankAccount;
import springtest4.user.BankAccountDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * Description: App
 * Author: heyv
 * Time: 2023 2023/7/26 18:43
 */
public class App {
    public static void main(String[] args) throws SQLException {

        //使用注解配置创建ApplicationContext
        ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
       //获取MyDataSource
//        DataSource ds  = (DataSource)ac.getBean("myDataSource");
//        //从数据源获取连接
//        Connection con  = ds.getConnection();
//        System.out.println(  con);

//        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_cbg","root","a");
//        System.out.println(conn);

        BankAccountDao bad = (BankAccountDao) ac.getBean("bankAccountDao");
        List<BankAccount> list = bad.findAll();
        for (BankAccount b : list) {
            System.out.println(b);
        }


    }
}

package main.java.springtest4.datasource;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Logger;


/**
 * Description: MyDataSource
 * Author: heyv
 * Time: 2023 2023/7/26 11:08
 */
/*
       TODO：Spring框架的核心注解，用于表示一个通用的Spring组件
        让Spring可以自动扫描，并将该类作为一个Bean注册到应用的上下文中    */
@Component
public class MyDataSource implements DataSource {
    private  ConcurrentLinkedQueue<MyConnection> pool;
    //配置后注入   结合属性文件完成注入操作
    //3.从属性文件中获取
    //使用@Value注解完成属性配置注入，从属性文件中获取以下属性值
    //TOdo：用于属性的注入，通过 ${} 的形式，从属性文件中获取值，并将其注入到对应的变量中去
    @Value("${mysql.coreSize}")
    private int coreSize;
    @Value("${mysql.username}")
    private String username;
    @Value("${mysql.password}")
    private String password;
    @Value("${mysql.url}")
    private String url;

    public MyDataSource(){
        System.out.println("MyDataSource的构造方法");
    }
    /*
    TODO：该注解用于在构造方法执行后执行此方法
     */
    @PostConstruct
    public void init() throws SQLException{
        System.out.println("MyDataSource的init（）方法");
        pool = new ConcurrentLinkedQueue<>();
        for(int i=0; i<coreSize;i++){
            MyConnection mc =new MyConnection();
            //设置联接池的数据库联接的初始状态为可用
            mc.status=false;
            //使用DriverManager获取数据库连接
            mc.con = DriverManager.getConnection(url,username,password);
            pool.add(mc);
        }
    }
    class MyConnection{
        Connection con;
        boolean status;
    }



    @Override
    public Connection getConnection() throws SQLException {
        do {
            MyConnection mc = this.pool.poll();
            if(mc == null) {
                return  null;
            }
            if(!mc.status){
                return mc.con;
            }
        }while (true);
    }

    public void  returnConnection(Connection conn){
        MyConnection mc = new MyConnection (  );
        mc.status=false;
        mc.con =conn;
        this.pool.add(mc);
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}

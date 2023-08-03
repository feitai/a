package com.yc.configs;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Description: DataSourceConfig
 * Author: heyv
 * Time: 2023 2023/8/2 15:05
 */
@Configuration
@PropertySource("classpath:db.properties")
@Log4j2
public class DataSourceConfig {

    // 利用di将db.properties的内容注入
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.Driver}")
    private String driver;
    @Value("#{ T(Runtime).getRuntime().availableProcessors()*2}")
    private int cpuCount;

   @Bean
    public DataSource dataSource() {
       DriverManagerDataSource dataSource = new DriverManagerDataSource();
       dataSource.setDriverClassName(driver);
       dataSource.setUrl(url);
       dataSource.setUsername(username);
       dataSource.setPassword(password);
       return dataSource;
   }

   @Bean
    public DataSource dbcpDataSource() {

   BasicDataSource dbcpDataSource = new BasicDataSource();
       dbcpDataSource.setDriverClassName(driver);
       dbcpDataSource.setUrl(url);
       dbcpDataSource.setUsername(username);
       dbcpDataSource.setPassword(password);
       return dbcpDataSource;
   }
   @Bean(initMethod ="init",destroyMethod = "close")
    public DruidDataSource druiddataSource(){
       DruidDataSource dds = new DruidDataSource();
       dds.setDriverClassName(driver);
       dds.setUrl(url);
       dds.setUsername(username);
       dds.setPassword(password);

       log.info("  配置druid的连接池 大小 "+ cpuCount);
       dds.setInitialSize(cpuCount);
       dds.setMaxActive(cpuCount*2);
       return dds;
   }





}

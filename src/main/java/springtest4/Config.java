package springtest4;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * Description: Config
 * Author: heyv
 * Time: 2023 2023/7/26 11:24
 */
//TODO：该注解表示该类是一个配置类，相当于传统xml文件配置中的<bean>标签
    //TODO：在Spring中我们可以通过java配置类来替代xml文件
@Configuration
//该注解用于指定需要扫描的基础包路径，Spring会自动扫描该包和子包下的所有组件，并且把他们注册成为Spring的bean
@ComponentScan
//TODo：该注解用于指定属性我见你的位置，Spring会根据指定的属性文件来注入属性值
@PropertySource(value = "classpath:db.properties")
public class Config {

}

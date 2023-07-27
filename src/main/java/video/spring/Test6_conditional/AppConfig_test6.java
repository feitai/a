package video.spring.Test6_conditional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Description: AppConfig_test6
 * Author: heyv
 * Time: 2023 2023/7/26 16:58
 */
@Configuration
@ComponentScan(basePackages = "video.spring.Test6_conditional")
public class AppConfig_test6 {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig_test6.class);
      String []names = ac.getBeanDefinitionNames();
      for (String name : names) {
          System.out.println(name);
      }
    }
}

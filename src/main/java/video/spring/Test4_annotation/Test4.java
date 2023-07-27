package video.spring.Test4_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import video.spring.Test3_factoryBean.AppConfigTest3;

/**
 * Description: Test4
 * Author: heyv
 * Time: 2023 2023/7/26 15:18
 */
public class Test4 {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig_Test4.class);
      PeroductBiz pb =  (PeroductBizImpl)ac.getBean("peroductBizImpl");
      pb.takein();
    }
}

package video.spring.Test5_import;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Description: Test5
 * Author: heyv
 * Time: 2023 2023/7/26 15:59
 */
public class Test5 {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig_Test5.class);
        Banana ba = (Banana)ac.getBean(Banana.class);
        System.out.println(ba);
        String [] names = ac.getBeanDefinitionNames();
        for (String name : names){
            System.out.println(name);
        }
        //修改beanid


    }
}

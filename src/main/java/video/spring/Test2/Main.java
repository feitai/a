package video.spring.Test2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Description: Main
 * Author: heyv
 * Time: 2023 2023/7/25 23:53
 */
public class Main {
    public static void main(String[] args) {
        //基于注解的配置文件，，
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Apple apple =(Apple) context.getBean("a");
        System.out.println(apple.toString());

    }
}

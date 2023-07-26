package springtest3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springtest3.system.Container;
import springtest3.user.Student;

/**
 * Description: TestMain
 * Author: heyv
 * Time: 2023 2023/7/26 8:58
 */
public class TestMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Container con= (Container) context.getBean("container");
        con.add(  new Student("扎三",80,1.7));
        con.add(  new Student("li三",90,1.6));
        con.add(  new Student("liui三",100,1.5));

        con.add(new Student("异常",1000,0.1));

        System.out.println(con.getMax());
        System.out.println(con.getMin());
        System.out.println(con.getAvg());
        System.out.println(con.size());
    }
}

package video.spring.Test1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description: Test1
 * Author: heyv
 * Time: 2023 2023/7/25 20:22
 */
public class Test1 {
    public static void main(String[] args) {
       // 1.
//        //早期直接new对象
//        Student s= new Student();
//        s.setId(1);
//        s.setName("李四");
//        System.out.println(s.toString());
        //程序创建对象，控制不反转，，Test1依赖Students，离开student就无法正常编j译
        //2.
        //引入spring的ioc机制，控制反转，由容器创建对象
        //类路径下的xml文件，并且xml文件的参数可以多个
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //上面的这句代码：启动容器，读取class录进下的 beans.xml 文件，并且获取beans配置的class，实例化对象，存入容器中

        //文件xml ，指定路径
//        ApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
        //使用  context.getBean()获取对象
       Student ss=(Student)context.getBean("s") ;
        System.out.println(ss.toString());

        //容器的好处：  容器管理Bean ，1.对象是单例的

        //TODO: 让属性有值  --》DI -->依赖注入 --> Dependency inijection 依赖注入

    }
}

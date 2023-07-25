import springtest1.biz.UserBiz;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springtest1.Config;
import springtest1.dao.UserDao;

/**
 * Description: App2
 * Author: heyv
 * Time: 2023 2023/7/25 16:43
 */
public class App1 {
    public static void main(String[] args) {
        //首先创建容器
      //  ClassPathXmlApplicationContext
        ApplicationContext container = new AnnotationConfigApplicationContext(Config.class);

     UserDao ud =(UserDao) container.getBean("userDaoImpl");
     ud.add("zs");

        UserBiz ub = (UserBiz) container.getBean("userBizImpl");
        ub.add("1");
    }
}

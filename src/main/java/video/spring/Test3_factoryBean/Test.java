package video.spring.Test3_factoryBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Description: Test
 * Author: heyv
 * Time: 2023 2023/7/26 14:18
 */
public class Test {
    public static void main(String[] args) throws Exception {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfigTest3.class);
        Pear pear=(Pear)  ac.getBean("ffb");

        System.out.println(pear.hashCode());

        FruitFactoryBean obj=(FruitFactoryBean)  ac.getBean("&ffb");

        System.out.println(obj);

        Pear obj3=(Pear)  ac.getBean("ffb");

        System.out.println(pear.hashCode());

        //3.获取spring容器中所有的托管bean

        String [] beanNames = ac.getBeanDefinitionNames();
        for(String bean:beanNames){
            System.out.println(bean);
        }
    }
}

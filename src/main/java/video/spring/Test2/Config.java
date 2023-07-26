package video.spring.Test2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description: Config
 * Author: heyv
 * Time: 2023 2023/7/25 23:48
 */

@Configuration             //表示是一个配置类
public class Config {

    //
    @Bean         //    <bean id="a" class="video.spring.Test2.Apple">
    public Apple a(){
        Apple apple= new Apple();
        apple.setId(1);
        return apple;
    }
}

package video.spring.Test4_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Description: AppConfig_Test4
 * Author: heyv
 * Time: 2023 2023/7/26 15:13
 */
@Configuration
@ComponentScan(basePackages = "video.spring.Test4_annotation")
public class AppConfig_Test4 {

    //@Bean  原来是利用@Bean来创建Bean，交给Spring托管
}

package video.spring.Test3_factoryBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Description: AppConfigTest3
 * Author: heyv
 * Time: 2023 2023/7/26 14:12
 */
@Configuration
public class AppConfigTest3 {
    @Bean
    public FruitFactoryBean ffb(){
        return new FruitFactoryBean();
    }
}

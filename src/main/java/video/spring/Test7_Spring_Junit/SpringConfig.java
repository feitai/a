package video.spring.Test7_Spring_Junit;

/**
 * Description: SpringConfig
 * Author: heyv
 * Time: 2023 2023/7/27 10:50
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SpringConfig {

    @Bean
    public MyService myService() {
        return new MyService();
    }
}

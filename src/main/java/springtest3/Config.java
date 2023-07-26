package springtest3;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Description: Config
 * Author: heyv
 * Time: 2023 2023/7/26 9:45
 */
@Configuration
@ComponentScan (basePackages = {"springtest3.system","springtest3.user"} )
public class Config {

}

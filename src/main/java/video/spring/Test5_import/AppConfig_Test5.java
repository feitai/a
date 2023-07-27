package video.spring.Test5_import;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Description: AppConfig_Test5
 * Author: heyv
 * Time: 2023 2023/7/26 15:55
 */
@Configuration
@Import({Banana.class})   //beanid:       ----对象
public class AppConfig_Test5 {
}

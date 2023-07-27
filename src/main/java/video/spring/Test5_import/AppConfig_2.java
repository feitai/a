package video.spring.Test5_import;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Description: AppConfig_2
 * Author: heyv
 * Time: 2023 2023/7/26 16:07
 */
@Configuration
@Import({Banana.class,FruitImportSelector.class})
public class AppConfig_2 {
}

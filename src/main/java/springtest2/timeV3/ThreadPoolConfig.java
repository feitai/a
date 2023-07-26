package springtest2.timeV3;

/**
 * Description: Ww
 * Author: heyv
 * Time: 2023 2023/7/25 19:24
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class ThreadPoolConfig {
    // 创建一个可重用固定线程数的线程池
    @Bean
    public ExecutorService threadPool() {
        return Executors.newFixedThreadPool(3 );
    }
}

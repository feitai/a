package springtest2.timeV3;

/**
 * Description: Timev3
 * Author: heyv
 * Time: 2023 2023/7/25 19:26
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.util.concurrent.ExecutorService;

@SpringBootApplication
public class Timev3 {

    @Autowired
    private static ExecutorService pool;

    public static void main(String[] args) throws InterruptedException {

        ApplicationContext context = new AnnotationConfigApplicationContext("ThreadPoolConfig");

while (true){
    for (int i = 0; i < 5; i++) {
        // 为每个线程提交一个任务
        pool.submit(new PrintTask());
    }

    // 关闭线程池
    pool.shutdown();

}

    }
}

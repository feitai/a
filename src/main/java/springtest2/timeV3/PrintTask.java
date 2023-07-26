package springtest2.timeV3;

/**
 * Description: Ww
 * Author: heyv
 * Time: 2023 2023/7/25 19:25
 */
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class PrintTask implements Runnable {

    @Override
    public void run() {
        while (true) {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(Thread.currentThread().getName()  +"输出了当前时间为："+   dateFormat.format(date));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

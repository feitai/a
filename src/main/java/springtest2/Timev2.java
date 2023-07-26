package springtest2;

/**
 * Description: Timev2
 * Author: heyv
 * Time: 2023 2023/7/25 18:59
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Timev2  {

    public static void main(String[] args) throws InterruptedException {
        // 创建一个可重用固定线程数的线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            // 为每个线程提交一个任务
            pool.submit(new PrintTask());
        }
        // 关闭线程池
        pool.shutdown();
    }

}

class PrintTask implements Runnable {

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
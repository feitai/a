package springtest2;

import org.springframework.beans.factory.annotation.Qualifier;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description: Timev1
 * Author: heyv
 * Time: 2023 2023/7/25 18:46
 */
public class Timev1 {
    public static void main(String[] args) throws InterruptedException {


    for (int i = 0;i<5;i++) {
        TimeTask task = new TimeTask();
        Thread t = new Thread(task);
        t.start();
        Thread.sleep(1000);
        t.stop();
    }


    }
}

class TimeTask implements Runnable {
    @Override
    public void run() {
        try {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(Thread.currentThread().getName()  +"输出了当前时间为："+   dateFormat.format(date));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
        Thread.interrupted();
        }

    }
}
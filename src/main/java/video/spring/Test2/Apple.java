package video.spring.Test2;

import org.springframework.context.annotation.Configuration;

/**
 * Description: Student
 * Author: heyv
 * Time: 2023 2023/7/25 23:43
 */

@Configuration
public class Apple {
    private int id;

    public Apple() {
        System.out.println("Apple构造方法被调用啦");
    }

    @Override
    public String toString() {
        return "Apple{" +
                "id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

package video.spring.Test3_factoryBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

/**
 * Description: Pear
 * Author: heyv
 * Time: 2023 2023/7/26 14:07
 */


public class Pear {
    private int id;
    public Pear(){
        System.out.println("Pear构造类的创建");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pear{" +
                "id=" + id +
                '}';
    }
}

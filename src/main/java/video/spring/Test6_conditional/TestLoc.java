package video.spring.Test6_conditional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Description: TestLoc
 * Author: heyv
 * Time: 2023 2023/7/27 10:37
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= AppConfig_test6.class)
public class TestLoc {
Apple app = new Apple(1,"77");
    @Test
    public void test1(){
        System.out.println(app);
    }

}

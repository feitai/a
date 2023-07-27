package video.spring.Test7_Spring_Junit;

/**
 * Description: MyServiceTest
 * Author: heyv
 * Time: 2023 2023/7/27 10:51
 */
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class MyServiceTest {

    @Autowired
    private MyService myService;

    @Test
    public void testDoSomething() {
        String result = myService.doSomething();
        Assert.assertEquals("Hello, World!", result);
    }
}

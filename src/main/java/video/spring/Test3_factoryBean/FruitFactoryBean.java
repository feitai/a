package video.spring.Test3_factoryBean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.cglib.proxy.Factory;

/**
 * Description: FruitFactoryBean
 * Author: heyv
 * Time: 2023 2023/7/26 14:09
 */
public class FruitFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
       return new Pear();
    }

    @Override
    public Class<?> getObjectType() {
        return Pear.class;
    }

}

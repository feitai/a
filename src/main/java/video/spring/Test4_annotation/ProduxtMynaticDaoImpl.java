package video.spring.Test4_annotation;

import org.springframework.stereotype.Repository;

/**
 * Description: ProduxtMynaticDaoImpl
 * Author: heyv
 * Time: 2023 2023/7/26 14:59
 */
@Repository  //TODO:表明这个类被spring托管，是一个dao层的类，Spring会将异常自动转化为RuntimeException
public class ProduxtMynaticDaoImpl implements ProduxtDao{
    @Override
    public void add() {
        System.out.println("ProduxtMynaticDaoImpl的add方法");
    }

    @Override
    public void find() {
        System.out.println("ProduxtMynaticDaoImpl的find方法");
    }

    @Override
    public void update() {
        System.out.println("ProduxtMynaticDaoImpl的update方法");
    }
}

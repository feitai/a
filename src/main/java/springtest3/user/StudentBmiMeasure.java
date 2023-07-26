package springtest3.user;

import org.springframework.stereotype.Component;
import springtest3.system.Measure;

/**
 * Description: StudentBmiMeasure
 * Author: heyv
 * Time: 2023 2023/7/26 9:36
 */
@Component("bmiMeasure")
public class StudentBmiMeasure implements Measure {
    @Override
    public double doMeasure(Object obj) {
        if(obj == null){
            throw new RuntimeException("待测数据异常");
        }
        if(!(obj instanceof Student)){
            throw new RuntimeException("待测数据异常");
        }
        Student s= (Student)obj;
        return s.getWeight()/(s.getHeight()*s.getHeight());
    }
}

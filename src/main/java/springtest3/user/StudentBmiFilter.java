package springtest3.user;

import org.springframework.stereotype.Component;
import springtest3.system.ContainerFilter;

/**
 * Description: StudentBmiFilter
 * Author: heyv
 * Time: 2023 2023/7/26 9:39
 */
@Component("bmiFilter")
public class StudentBmiFilter implements ContainerFilter {
    @Override
    public boolean doFilter(Object obj) {
        if(obj == null) {
            return false;
        }
        if(!(obj instanceof Student)){
            return false;
        }
        Student s = (Student) obj;
        if(s.getName() == null || s.getName().equals("")){

            return false;
        }if(s.getHeight()<1 || s.getHeight()>2.7){

            return false;
        }if (s.getWeight()<20 || s.getWeight()>1000){

            return false;
        }
        return true;
    }
}

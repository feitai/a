package springtest3.system;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: Container
 * Author: heyv
 * Time: 2023 2023/7/26 8:39
 */
@Component
public class Container<T>  {

    private List<T> objs = new ArrayList<T>();
@Resource(name = "bmiMeasure")
    private Measure measure;
@Resource(name = "bmiFilter")
    private ContainerFilter Filter;
    private T max;
    private  T min;
    private  double avg;
    private  double sum;

    public void add(T t) {
        //测试t是否合格
        if (Filter!=null) {
            if(Filter.doFilter(t) == false){
                System.out.println("false");
                return;
            }
            //把t添加到objs
            objs.add(t);
            //调用 measure接口，求max min avg
            if(objs.size() == 1){
                max = t;
                min = t;
            }else {
                double val = this.measure.doMeasure(t);
                double maxval = this.measure.doMeasure(max);
                double minval = this.measure.doMeasure(min);
                if(val > maxval){
                    max = t;
                }
            }
            sum+= measure.doMeasure(t);
            avg = sum/objs.size();
        }


    }

    public T getMax() {
        return max;
    }

    public T getMin() {
        return min;
    }

    public double getAvg() {
        return avg;
    }
    public int size(){
        return objs.size();
    }
    public void closeAll(){
        objs=new ArrayList<>();
        measure=null;
        Filter=null;
        max =null;
        min =null;
        avg =0;
    }
}

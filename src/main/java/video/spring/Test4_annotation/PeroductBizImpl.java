package video.spring.Test4_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description: PeroductBizImpl
 * Author: heyv
 * Time: 2023 2023/7/26 15:07
 */
@Service
public class PeroductBizImpl implements PeroductBiz{
    @Autowired  //由spring自动的从容器内取出一个ProduxtDao的一个实现类的对象
    private ProduxtDao produxtDao;  //业务层依赖dao层


    @Override
    public void takein() {
        produxtDao.find();
        int i = 1;
        if(i==1){
            produxtDao.update();
        }else {
            produxtDao.add();
        }

    }
}

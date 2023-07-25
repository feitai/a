package springtest1.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import springtest1.dao.UserDao;

/**
 * Description: UserBizImpl
 * Author: heyv
 * Time: 2023 2023/7/25 16:52
 */

@Service
public class UserBizImpl implements UserBiz{

    @Autowired
    @Qualifier("userDaoImpl")
    private UserDao userDao;

    public UserBizImpl(){
        System.out.println("UserBizImpl的构造");
    }
    @Override
    public void add(String user){
        userDao.add(user);
    }
}

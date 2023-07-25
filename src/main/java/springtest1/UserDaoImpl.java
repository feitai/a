package springtest1;

import org.springframework.stereotype.Repository;
import springtest1.dao.UserDao;

/**
 * Description: UserDaolmpl
 * Author: heyv
 * Time: 2023 2023/7/25 16:38
 */
@Repository
public class UserDaoImpl implements UserDao {
public UserDaoImpl(){
    System.out.println("UserDaoImpl的构造");
}
    @Override
    public void add(String user) {
        System.out.println("添加了："+user);
    }
}

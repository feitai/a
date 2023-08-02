package main.java.springtest4.user;

import main.java.springtest4.jdbcTemplate.JdbcTemplate;
import main.java.springtest4.jdbcTemplate.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.jar.JarException;

/**
 * Description: BankAccountDao
 * Author: heyv
 * Time: 2023 2023/7/26 21:10
 */
@Repository
public class BankAccountDao extends JdbcTemplate {
    @Autowired
    public BankAccountDao(DataSource dataSource) {
        super(dataSource);
    }
    public List<springtest4.user.BankAccount> findAll(){
       return  super.executeQuery("select * from bank", new RowMapper<springtest4.user.BankAccount>() {
            @Override
            public springtest4.user.BankAccount mapper(ResultSet rs, int i) throws SQLException {
                springtest4.user.BankAccount ba = new springtest4.user.BankAccount();
                ba.setId(rs.getInt(1));
                ba.setBalance(rs.getInt(2));
                return ba;
            }
        });
    }
}

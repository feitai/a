package springtest4.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springtest4.jdbcTemplate.JdbcTemplate;
import springtest4.jdbcTemplate.RowMapper;

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
    public List<BankAccount> findAll(){
       return  super.executeQuery("select * from bank", new RowMapper<BankAccount>() {
            @Override
            public BankAccount mapper(ResultSet rs, int i) throws SQLException {
                BankAccount ba = new BankAccount();
                ba.setId(rs.getInt(1));
                ba.setBalance(rs.getInt(2));
                return ba;
            }
        });
    }
}

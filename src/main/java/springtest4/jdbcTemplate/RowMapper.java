package springtest4.jdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Description: RowMapper
 * Author: heyv
 * Time: 2023 2023/7/26 20:21
 */
public interface RowMapper<T> {


    public T mapper(ResultSet rs, int i) throws SQLException;
}

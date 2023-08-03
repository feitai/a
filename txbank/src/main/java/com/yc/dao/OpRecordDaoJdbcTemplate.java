package com.yc.dao;

import com.yc.bean.Account;
import com.yc.bean.OpRecord;
import com.yc.bean.OpType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * Description: OpRecordDaoJdbcTemplate
 * Author: heyv
 * Time: 2023 2023/8/3 10:09
 */
@Repository
public class OpRecordDaoJdbcTemplate implements OpRecordDao{
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public  void init(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public void insertOpRecord(OpRecord opRecord) {

        String sql = "INSERT INTO  oprecord(accountid,opmoney,optime,optype,transferid) VALUES (?,?,now(),?,?)";

        this.jdbcTemplate.update(sql, opRecord.getAccountid(), opRecord.getOpmoney(),
                opRecord.getOpType().getKey(), opRecord.getTransferid());

    }

    @Override
    public List<OpRecord> findOpRecord(int accountid) {

        List<OpRecord> result = jdbcTemplate.query(
                "select * from oprecord where accountid= ? order by optime desc",
                (resultSet,rowNum)->{
                    OpRecord a = new OpRecord();
                    a.setId(resultSet.getInt(1));
                    a.setAccountid( resultSet.getInt(2));
                    a.setOpmoney( resultSet.getDouble(3));
                    a.setOptime( resultSet.getString(4));
                    String optype = ( resultSet.getString(5));
                    if(optype.equalsIgnoreCase("withdrow")){
                        a.setOpType(OpType.WITHDRAM);
                    }else if(optype.equalsIgnoreCase("deposite")){
                        a.setOpType(OpType.DESPOSITE);
                    }else{
                        a.setOpType(OpType.TRANSFER);
                    }
                    a.setTransferid( resultSet.getInt(6));
                    return a;
                },accountid);
        return result;
    }

    @Override
    public List<OpRecord> findOpRecord(int accountid, String opType) {
        List<OpRecord> result = jdbcTemplate.query(
                "select * from oprecord where accountid= ? and opType= ? order by optime desc",
                (resultSet, rowNum) -> {
                    OpRecord a = new OpRecord();
                    a.setId(resultSet.getInt(1));
                    a.setAccountid(resultSet.getInt(2));
                    a.setOpmoney(resultSet.getDouble(3));
                    a.setOptime(resultSet.getString(4));
                    String optype = (resultSet.getString(5));
                    if (optype.equalsIgnoreCase("withdrow")) {
                        a.setOpType(OpType.WITHDRAM);
                    } else if (optype.equalsIgnoreCase("deposite")) {
                        a.setOpType(OpType.DESPOSITE);
                    } else {
                        a.setOpType(OpType.TRANSFER);
                    }
                    a.setTransferid(resultSet.getInt(6));
                    return a;
                }, accountid, opType);
        return result;
    }

    @Override
    public List<OpRecord> findOpRecord(OpRecord opRecord) {
        return null;
    }
}

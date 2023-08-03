package com.yc.dao;

import com.yc.bean.OpRecord;
import com.yc.bean.OpType;
import com.yc.configs.Config;
import com.yc.configs.DataSourceConfig;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Description: OpRecordDaoJdbcTemplateTest
 * Author: heyv
 * Time: 2023 2023/8/3 11:19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class, DataSourceConfig.class,})
@Log4j2
public class OpRecordDaoJdbcTemplateTest {
    @Autowired
    private  OpRecordDao opRecordDao;

    @Test
    public void insertOpRecord() throws Exception {
        OpRecord opRecord = new OpRecord();
        opRecord.setAccountid(1);
        opRecord.setOpmoney(5);
        opRecord.setOpType(OpType.DESPOSITE);
        opRecord.setTransferid(1);
        this.opRecordDao.insertOpRecord(opRecord);
    }
    @Test
    public void findOpRecord() throws Exception {
        List<OpRecord> opRecordList =this.opRecordDao.findOpRecord(1);
        System.out.println(opRecordList);

    }
    @Test
    public void testfindOpRecord() throws Exception {
        List<OpRecord> opRecordList =this.opRecordDao.findOpRecord(1,"TRANSFER");
        System.out.println(opRecordList);

    }
}

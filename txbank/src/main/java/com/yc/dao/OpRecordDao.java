package com.yc.dao;

import com.yc.bean.OpRecord;

import java.util.List;

/**
 * Description: OpRecordDao
 * Author: heyv
 * Time: 2023 2023/8/3 9:30
 */
public interface OpRecordDao {


    /**
     * 设计日志的添加接口方法：T0D0:
     * 参数 opRecord 包含要添加的日志信息的 OpRecord 对象
     */
    public void insertOpRecord(OpRecord opRecord);

    /**
     * 查询一个用户所有的日志。根据时间排序
     * @param accountid 用户账号ID
     * @return 包含所有日志信息的 OpRecord 对象列表，按时间排序
     */
    public List<OpRecord> findOpRecord(int accountid);

    /**
     * 查询 accountid 账户 opType 类型的操作，根据时间排序
     * @param accountid 用户账号ID
     * @param opType 操作类型
     * @return 包含满足条件的日志信息的 OpRecord 对象列表，按时间排序
     */
    public List<OpRecord> findOpRecord(int accountid, String opType);

    /**
     * 特殊查询。
     * 其他特定查询条件可以通过 opRecord 对象进行查询
     * @param opRecord 包含特定查询条件的 OpRecord 对象
     * @return 包含满足条件的日志信息的 OpRecord 对象列表
     */
    public List<OpRecord> findOpRecord(OpRecord opRecord);




}

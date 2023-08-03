package com.yc.dao;

import com.yc.bean.Account;

import java.util.List;

/**
 * Description: AccountDao
 * Author: heyv
 * Time: 2023 2023/8/3 9:30
 */
public interface AccountDao {

    /**
     * 新增账号，返回新账号的编号
     */
    public int insert(double money) ;


    /**
     * 根据账号将金额更新
     * 将账号的balance字段增加money值
     * @param accountid 账号编号
     * @param money 正数表示存，负数表示取
     */
    public void update(int accountid, double money) ;


    /**
     * 删除账号
     * @param accountid 账号编号
     */
    public void delete(int accountid) ;

    /**
     * 查询账户总数
     * @return 账户总数
     */
    public int findCount() ;

    /**
     * 查询所有的账户
     * @return 包含所有账户信息的列表
     */
    public List<Account> findAll() ;

    /**
     * 根据账号编号查询账号
     * @param accountid 账号编号
     * @return 包含账号信息的Account对象
     */
    public Account findById(int accountid) ;


}

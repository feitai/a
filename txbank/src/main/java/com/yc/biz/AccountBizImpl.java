package com.yc.biz;

import com.yc.bean.Account;
import com.yc.bean.OpRecord;
import com.yc.bean.OpType;
import com.yc.dao.AccountDao;
import com.yc.dao.OpRecordDao;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description: AccountBizImpl
 * Author: heyv
 * Time: 2023 2023/8/2 14:17
 */
@Service
@Log4j2
@Transactional
public class AccountBizImpl implements AccountBiz{
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private OpRecordDao opRecordDao;
    @Override
    public Account openAccount(double money) {
        int accountid = accountDao.insert(money);

        OpRecord opRecord = new OpRecord();
        opRecord.setAccountid(accountid);
        opRecord.setOpmoney(money);
        opRecord.setOpType(OpType.DESPOSITE);
        this.opRecordDao.insertOpRecord(opRecord);

        Account a = new Account();
        a.setAccountid(accountid);
        a.setMoney(money);
        return a;
    }

    @Override
    public Account desposit(int accountid, double money) {
        return this.desposit(accountid, money,null);
    }
    public Account desposit(int accountid, double money,Integer transferId) {
        Account a = null;
        try{
            a = this.accountDao.findById(accountid);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            throw  new RuntimeException("查无   "+ accountid+"    此账户");
        }
        a.setMoney(a.getMoney()+money);

        this.accountDao.update(accountid,a.getMoney());
        OpRecord opRecord = new OpRecord();
        opRecord.setAccountid(accountid);
        opRecord.setOpmoney(money);
        opRecord.setTransferid(transferId);
        if(transferId!=null){
            opRecord.setOpType(OpType.TRANSFER);
        }else {
            opRecord.setOpType(OpType.DESPOSITE);
        }
        this.opRecordDao.insertOpRecord(opRecord);
        return a;
    }

    @Override
    public Account withdrow(int accountid, double money) {
        return this.withdrow(accountid, money,null);
    }
    public Account withdrow(int accountid, double money,Integer transferId) {
        Account a = null;
        try{
            a = this.accountDao.findById(accountid);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            throw  new RuntimeException("查无   "+ accountid+"    此账户");
        }
        a.setMoney(a.getMoney()-money);


        OpRecord opRecord = new OpRecord();
        opRecord.setAccountid(accountid);
        opRecord.setOpmoney(money);
        opRecord.setTransferid(transferId);
        if(transferId!=null){
            opRecord.setOpType(OpType.TRANSFER);
        }else {
            opRecord.setOpType(OpType.WITHDRAM);
        }
        this.opRecordDao.insertOpRecord(opRecord);

        this.accountDao.update(accountid,a.getMoney());
        return a;
    }
    @Override
    public Account tranfer(int accountid, double money, int toAccountid) {
        this.desposit(toAccountid,money,accountid);

        Account a = this.withdrow(accountid,money,toAccountid);

        return a;
    }

    @Override
    public Account findAccount(int accountid) {
        return this.accountDao.findById(accountid);
    }
}

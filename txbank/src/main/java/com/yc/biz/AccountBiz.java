package com.yc.biz;

import com.yc.bean.Account;
import org.springframework.stereotype.Component;

/**
 * Description: AccountBiz
 * Author: heyv
 * Time: 2023 2023/8/2 14:15
 */

public interface AccountBiz {
   //开户
   public Account openAccount(double money);

   //存钱
   public Account  desposit(int accountid,double money);

   //取钱
   public Account  withdrow(int accountid,double money);

   //转账
   public Account  tranfer(int accountid,double money,int toAccountid);
   //查询帐户

   public Account findAccount(int accountid);

}

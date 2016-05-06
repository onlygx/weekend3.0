package com.elangzhi.ssm.services;

import com.elangzhi.ssm.dao.AccountDao;
import com.elangzhi.ssm.model.Account;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * Created by GaoXiang on 2016/2/29 0029.
 */

@Service
public class AccountService  extends BaseService<Account>{

    @Resource
    private AccountDao accountDao;

    /**
     * 获取用户登陆信息
     * @param account
     * @return
     */
    public Account findByUserName(Account account){
        return accountDao.findByUserName(account);
    }


}

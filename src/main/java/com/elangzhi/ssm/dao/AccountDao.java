package com.elangzhi.ssm.dao;

import com.elangzhi.ssm.model.Account;
import org.springframework.stereotype.Repository;

/**
 * Created by GaoXiang on 2016/5/3 0003.
 */
@Repository
public class AccountDao extends LzDao<Account> {

    public Account findByUserName(Account account){
        return getSqlSessionTemplate().selectOne("AccountMapper.findByUserName", account);
    }
}

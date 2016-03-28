package com.elangzhi.ssm.services;

import com.elangzhi.ssm.dao.LzDao;
import com.elangzhi.ssm.model.Account;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * Created by GaoXiang on 2016/2/29 0029.
 */

@Service
public class AccountService extends BaseService<Account> {

    @Resource
    private LzDao lzDao;


}

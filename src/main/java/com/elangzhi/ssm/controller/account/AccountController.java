package com.elangzhi.ssm.controller.account;

import com.elangzhi.ssm.controller.AdminBaseController;
import com.elangzhi.ssm.controller.json.Tip;
import com.elangzhi.ssm.model.Account;
import com.elangzhi.ssm.services.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 账户 Controller
 * @author GaoXiang
 * @version 1.0
 */
@Controller
@RequestMapping("/account")
public class AccountController extends AdminBaseController<Account> {


    /**
     * 重写 update 方法
     * @param account
     * @return
     * @throws Exception
     */
    @Override
    public Tip update(Account account) throws Exception {
        Account old = accountService.selectById(account.getId());
        old.setPassword(account.getPassword());
        return super.update(old);
    }

    //----------------------- property ----------------------
    @Resource
    private AccountService accountService;
}

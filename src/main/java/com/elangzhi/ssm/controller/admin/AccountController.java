package com.elangzhi.ssm.controller.admin;

import com.elangzhi.ssm.controller.BaseController;
import com.elangzhi.ssm.model.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 账号操作
 * Created by GaoXiang on 2016/5/4 0004.
 */
@Controller
@RequestMapping("/account")
public class AccountController extends BaseController<Account> {
}

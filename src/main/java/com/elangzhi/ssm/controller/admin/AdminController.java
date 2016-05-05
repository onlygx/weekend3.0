package com.elangzhi.ssm.controller.admin;

import com.elangzhi.ssm.controller.AdminBaseController;
import com.elangzhi.ssm.controller.json.Tip;
import com.elangzhi.ssm.model.Admin;
import com.elangzhi.ssm.services.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;

/**
 * 管理员信息
 * Created by GaoXiang on 2016/2/29 0029.
 */

@Controller
@RequestMapping("/admin")
public class AdminController extends AdminBaseController<Admin> {

    @RequestMapping("/errorTest")
    public void errorTest() {
        throw new NullPointerException();
    }

    @Override
    public Tip save(Admin admin) {
        logger.info("打印 Override");
        return super.save(admin);
    }

    //--------------------------- property --------------------------
    @Resource
    AccountService accountService;

}

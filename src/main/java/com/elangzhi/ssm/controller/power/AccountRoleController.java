package com.elangzhi.ssm.controller.power;

import com.elangzhi.ssm.controller.AdminBaseController;
import com.elangzhi.ssm.model.AccountRole;
import com.elangzhi.ssm.services.AccountRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;

/**
* 管理员角色 Controller
* @author GaoXiang
* @version 1.0
*/
@Controller
@RequestMapping("/accountRole")
public class AccountRoleController extends AdminBaseController<AccountRole> {







    //---------------------------- property -------------------------------

    @Resource
    private AccountRoleService accountRoleService;

}

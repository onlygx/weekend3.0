package com.elangzhi.ssm.controller.power;

import com.elangzhi.ssm.controller.AdminBaseController;
import com.elangzhi.ssm.model.RolePower;
import com.elangzhi.ssm.services.RolePowerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
* 角色权限 Controller
* @author GaoXiang
* @version 1.0
*/
@Controller
@RequestMapping("/rolePower")
public class RolePowerController extends AdminBaseController<RolePower> {







    //---------------------------- property -------------------------------

    @Resource
    private RolePowerService rolePowerService;

}

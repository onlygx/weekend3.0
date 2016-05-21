package com.elangzhi.ssm.controller.power;

import com.elangzhi.ssm.controller.AdminBaseController;
import com.elangzhi.ssm.model.Role;
import com.elangzhi.ssm.services.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;

/**
 * 角色 Controller
 * @author GaoXiang
 * @version 1.0
 */
@Controller
@RequestMapping("/role")
public class RoleController extends AdminBaseController<Role>{



    //----------------------------- property ----------------------------------
    @Resource
    private RoleService roleService;
}

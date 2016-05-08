package com.elangzhi.ssm.controller.power;

import com.elangzhi.ssm.controller.AdminBaseController;
import com.elangzhi.ssm.model.Role;
import com.elangzhi.ssm.services.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;

/**
 * 角色管理
 * Created by GaoXiang on 2016/5/8 0008.
 */

@Controller
@RequestMapping("/role")
public class RoleController extends AdminBaseController<Role>{



    //----------------------------- property ----------------------------------
    @Resource
    private RoleService roleService;
}

package com.elangzhi.ssm.controller.admin;

import com.elangzhi.ssm.controller.BaseController;
import com.elangzhi.ssm.model.Admin;
import com.elangzhi.ssm.tools.PageData;
import com.elangzhi.ssm.services.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 管理员信息
 * Created by GaoXiang on 2016/2/29 0029.
 */

@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController<Admin> {

    @RequestMapping("/errorTest")
    public void errorTest(){
        throw new NullPointerException();
    }

    //--------------------------- property --------------------------
    @Resource
    AccountService accountService;

}

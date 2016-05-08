package com.elangzhi.ssm.controller.admin;

import com.elangzhi.ssm.controller.AdminBaseController;
import com.elangzhi.ssm.controller.json.Tip;
import com.elangzhi.ssm.model.Account;
import com.elangzhi.ssm.model.Admin;
import com.elangzhi.ssm.model.Power;
import com.elangzhi.ssm.services.AccountService;
import com.elangzhi.ssm.services.AdminService;
import com.elangzhi.ssm.tools.PageData;
import com.elangzhi.ssm.tools.UUIDFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * 管理员信息
 * Created by GaoXiang on 2016/2/29 0029.
 */

@Controller
@RequestMapping("/admin")
public class AdminController extends AdminBaseController<Admin> {

    @RequestMapping(value="/headimg")
    public ModelAndView headimg(Admin admin,ModelMap model) throws Exception {
        admin = adminService.selectOne(admin);
        model.put("data",admin);
        return new ModelAndView("admin/admin/headimg",model);
    }

    /**
     * 数据库批量删除
     * @param ids
     * @return
     */
    @RequestMapping(value="/deleteByIds")
    @ResponseBody
    public Tip deleteByIds(@RequestParam("ids[]") List<Long> ids){
        try {
            for(Long id : ids){
                Admin temp = new Admin();
                temp.setId(id);
                adminService.delete(temp);
            }
            return new Tip();
        } catch (Exception e) {
            e.printStackTrace();
            return new Tip(1);
        }
    }

    /**
     * 保存
     * @param admin
     * @return
     * 1，管理员信息错误
     * 2，账号信息错误
     * 3，账号已存在
     */
    @Override
    public Tip save(Admin admin) throws Exception {

        Account account = new Account();
        account.setId(admin.getId()+1);
        account.setUserName(admin.getUserName());
        account.setPassword(admin.getPassword());
        account.setInfoId(admin.getId());
        account.setStatus(1);
        account.setType(1);

        admin.setSetTime(new Date());
        admin.setName(admin.getUserName());
        Account resoult = accountService.findByUserName(account);
        if(resoult != null){
            return new Tip(3,resoult.getId());
        }else{
            accountService.save(account);
            return super.save(admin);
        }
    }

    //--------------------------- property --------------------------
    @Resource
    AccountService accountService;

    @Resource
    AdminService adminService;
}

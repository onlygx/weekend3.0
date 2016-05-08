package com.elangzhi.ssm.controller;

import com.elangzhi.ssm.controller.json.Tip;
import com.elangzhi.ssm.model.Account;
import com.elangzhi.ssm.model.Admin;
import com.elangzhi.ssm.model.Power;
import com.elangzhi.ssm.services.AccountService;
import com.elangzhi.ssm.services.AdminService;
import com.elangzhi.ssm.services.PowerService;
import com.elangzhi.ssm.tools.Const;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 登陆
 * Created by GaoXiang on 2016/5/3 0003.
 */

@Controller
@RequestMapping("/login")
public class LoginController {

    /**
     * 跳转到登陆页面
     * @return
     */
    @RequestMapping(value="/loginPage",method = RequestMethod.GET)
    public ModelAndView loginPage(){
        // 验证码操作
        return new ModelAndView("admin/login");
    }

    /**
     * 登陆验证
     * @param account
     * @return success = true 登陆成功，
     * code = 1 用户不存在
     * code = 2 密码错误
     * code = 3 服务器拒绝登陆
     */
    @ResponseBody
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public Tip login(Account account, HttpSession session) throws Exception {
        Account resoult = accountService.findByUserName(account);

        //判断有没有账号
        if(resoult == null){
            return new Tip(1);

        // 判断密码
        }else if(checkPwd(resoult.getPassword(),account.getPassword())){

            //判断状态1 表示正常
            if(resoult.getStatus() < 0){
                return new Tip(3);
            }

            session.setAttribute(Const.ACCOUNT,resoult);

            // 检查分类并获取详细信息
            checkType(session,resoult);

            //检查权限并缓存
            checkPower(session,resoult);

            return new Tip();
        }else{
            return new Tip(2);
        }

    }

    /**
     * 检查并获取权限
     * @param session
     * @param resoult
     */
    private void checkPower(HttpSession session, Account resoult) {
        List<Power> powerList = powerService.findByAccount(resoult);
        session.setAttribute(Const.POWER_LIST,powerList);
    }

    /**
     * 验证密码
     * @param pwd
     * @param param
     * @return
     */
    public boolean checkPwd(String pwd,String param){
        return pwd.equals(param);
    }

    /**
     * 检查分类并分类缓存详细信息
     */
    public void checkType(HttpSession session,Account resoult) throws Exception {
        // 判断类型 1 表示管理员
        if(resoult.getType() == 1){
            Admin temp = new Admin();
            temp.setId(resoult.getInfoId());
            Admin admin = adminService.selectOne(temp);
            session.setAttribute(Const.ADMIN,admin);
        }
    }

    /**
     * 注销登陆
     * @return sussess 成功 ，code = 1 失败
     */
    @ResponseBody
    @RequestMapping(value="/logout",method = RequestMethod.POST)
    public Tip logout(HttpSession session){

        try {
            session.removeAttribute(Const.ACCOUNT);
            session.removeAttribute(Const.ADMIN);
            return new Tip();
        } catch (Exception e) {
            e.printStackTrace();
            return new Tip(1);
        }

    }




    //--------------------------------- property --------------------------------
    @Resource
    private AccountService accountService;

    @Resource
    private AdminService adminService;

    @Resource
    private PowerService powerService;
}

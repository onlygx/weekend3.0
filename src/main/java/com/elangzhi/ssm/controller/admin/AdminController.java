package com.elangzhi.ssm.controller.admin;

import com.elangzhi.ssm.controller.AdminBaseController;
import com.elangzhi.ssm.controller.json.Tip;
import com.elangzhi.ssm.model.Account;
import com.elangzhi.ssm.model.Admin;
import com.elangzhi.ssm.services.AccountService;
import com.elangzhi.ssm.services.AdminService;
import com.elangzhi.ssm.tools.ImageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
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

    @RequestMapping(value="/changeHead")
    @ResponseBody
    public Tip changeHead(HttpServletRequest request,HttpSession session,
            @RequestParam(required = false) Integer x1, // 起点x
            @RequestParam(required = false) Integer y1, // 起点y
            @RequestParam(required = false) Integer w,  // 宽度
            @RequestParam(required = false) Integer h,  // 高度
            @RequestParam(required = false) Long id,    // adminId
            @RequestParam(required = false) String src  // 图片地址
    ) {
        String path = request.getServletContext().getRealPath(src);
        if ("".equals(src)) {
            return new Tip(1); //请选择图片
        } else if (x1 == null || w == null || y1 == null || h == null) {
            return new Tip(2); //请选择剪裁区域
        } else {
            File file = new File(path);
            //上传地址
            String url = "/images/headImage/"
                    + System.currentTimeMillis()
                    + "_head"
                    + file.getName().substring(file.getName().lastIndexOf("."));

            String realPath = request.getServletContext().getRealPath(url);
            //剪裁
            try {
                ImageHelper.cutImage(file, realPath, x1, y1, w, h);
            } catch (IOException e) {
                e.printStackTrace();
                return new Tip(3); //剪裁失败
            }

            try {
                //获取账号信息 更改头像
                Admin param = new Admin();
                param.setId(id);
                Admin admin = adminService.selectOne(param);
                admin.setHead(url);
                adminService.update(admin);
                return new Tip(url);
            } catch (Exception e) {
                e.printStackTrace();
                return new Tip(4); // 保存失败
            }
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

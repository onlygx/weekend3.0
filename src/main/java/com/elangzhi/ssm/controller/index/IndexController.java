package com.elangzhi.ssm.controller.index;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

/**
 * 首页控制
 * Created by GaoXiang on 2015/10/22 0022.
 */

@Controller
public class IndexController{

    /**
     * 跳转到首页
     * @return 首页页面
     */
    @RequestMapping(value="/")
    public ModelAndView index(){
        return new ModelAndView("admin/index");
    }


    /**
     * 跳转到欢迎页面
     * @return 欢迎页面
     */
    @RequestMapping(value="/home")
    public ModelAndView home(){
        return new ModelAndView("admin/body/home");
    }

}

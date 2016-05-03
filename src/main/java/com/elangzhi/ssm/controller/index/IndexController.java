package com.elangzhi.ssm.controller.index;

import com.elangzhi.ssm.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by GaoXiang on 2015/10/22 0022.
 */

@Controller
//@RequestMapping("/")
public class IndexController extends BaseController{

    /**
     * 跳转到首页
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value="/",method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request,ModelMap model){
        return new ModelAndView("admin/index");
    }


    /**
     * 跳转到欢迎页面
     * @return
     */
    @RequestMapping(value="/home",method = RequestMethod.GET)
    public ModelAndView home(){
        return new ModelAndView("admin/body/home");
    }

}

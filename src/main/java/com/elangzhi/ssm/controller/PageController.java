package com.elangzhi.ssm.controller;

import com.elangzhi.ssm.tools.UUIDFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * 页跳转服务
 * Created by GaoXiang on 2016/5/3 0003.
 */

@Controller
@RequestMapping("/page")
public class PageController {

    /**
     * 单纯获取某页面
     * @param path
     * @return
     */
    @RequestMapping(value="/forward")
    public ModelAndView forward(@RequestParam("path") String path, ModelMap model){

        //生成一个id 如果跳转添加页面会用到
        model.put("longId", UUIDFactory.getLongId());

        return new ModelAndView(path,model);
    }

    /**
     * 转到某页面
     * @param path
     * @return
     */
    @RequestMapping(value="/redirect")
    public String redirect(@RequestParam("path") String path){
        
        return "redirect:"+path;
    }



}

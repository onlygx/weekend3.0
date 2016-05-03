package com.elangzhi.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 静态页跳转
 * Created by GaoXiang on 2016/5/3 0003.
 */

@Controller
@RequestMapping("/page")
public class PageController {

    /**
     * 跳转到某页面
     * @param path
     * @return
     */
    @RequestMapping(value="/forward")
    public ModelAndView forward(@RequestParam("path") String path){

        return new ModelAndView(path);
    }

    /**
     * 跳转到某页面
     * @param path
     * @return
     */
    @RequestMapping(value="/redirect")
    public String redirect(@RequestParam("path") String path){
        
        return "redirect:"+path;
    }



}

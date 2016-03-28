package com.elangzhi.ssm.controller.index;

import com.elangzhi.ssm.controller.json.Tip;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by GaoXiang on 2015/10/22 0022.
 */

@Controller
//@RequestMapping("/")
public class IndexController {

    @RequestMapping("/")
    public ModelAndView showCall(@PathVariable String name,HttpServletRequest request,ModelMap model){
        model.addAttribute("date", new Date());
        model.addAttribute("name", name);
        model.addAttribute("adminJson", "json content");
        return new ModelAndView("index",model);
    }


    @RequestMapping("/saveTest")
    @ResponseBody
    public Tip saveTest(@RequestParam String name){

        System.out.println(name);
        return new Tip();
    }

}

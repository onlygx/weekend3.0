package com.elangzhi.ssm.controller.admin;

import com.elangzhi.ssm.controller.BaseController;
import com.elangzhi.ssm.tools.PageData;
import com.elangzhi.ssm.model.Power;
import com.elangzhi.ssm.services.PowerService;
import com.elangzhi.ssm.tools.UUIDFactory;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by GaoXiang on 2016/2/29 0029.
 */

@Controller
@RequestMapping("/power")
public class PowerController extends BaseController {



    @RequestMapping(value="/login_insert")
    public ModelAndView test(Power power, ModelMap model)throws Exception{
        power.setId(UUIDFactory.getLongId());
        model.put("status",powerService.save(power));
        model.put("id",power.getId());
        return new ModelAndView("index",model);
    }

    @RequestMapping(value="/login_delete")
    public ModelAndView test2(Power power,ModelMap model)throws Exception{
        model.put("status",powerService.delete(power));
        model.put("id",power.getId());
        return new ModelAndView("index",model);
    }

    @RequestMapping(value="/login_select")
    public ModelAndView test4(Power power,ModelMap model)throws Exception{
        Power power1 = powerService.selectOne(power);
        model.put("status",power1.getName());
        model.put("id",power.getId());
        return new ModelAndView("index",model);
    }

    @RequestMapping(value="/login_list/{page}/{size}")
    public ModelAndView test3(HttpServletRequest request,@PathVariable Integer page,@PathVariable Integer size)throws Exception{
        PageData pd = new PageData(request);
        PageInfo pageInfo =  powerService.list(pd,Power.class,page,size);
        pd.put("pageInfo",pageInfo);
        return new ModelAndView("index",pd);
    }





    @Resource
    PowerService powerService;
}

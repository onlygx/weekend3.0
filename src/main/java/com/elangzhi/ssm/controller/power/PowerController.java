package com.elangzhi.ssm.controller.power;

import com.elangzhi.ssm.controller.AdminBaseController;
import com.elangzhi.ssm.controller.json.Tip;
import com.elangzhi.ssm.model.Power;
import com.elangzhi.ssm.services.PowerService;
import com.elangzhi.ssm.tools.PageData;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 权限管理
 * Created by GaoXiang on 2016/2/29 0029.
 */

@Controller
@RequestMapping("/power")
public class PowerController extends AdminBaseController<Power> {


    @RequestMapping("/listAll")
    public ModelAndView listAll(ModelMap model) throws Exception {
        List<Power> powerList = powerService.listAll();
        model.put("powerList",powerList);
        return new ModelAndView("admin/power/chooseParent",model);
    }

    @RequestMapping("/countByParentId")
    @ResponseBody
    public Integer countByParentId(HttpServletRequest request) throws Exception {
        PageData pd = new PageData(request);
        PageInfo<Power> pageInfo = powerService.list(pd);
        return pageInfo.getList().size();
    }



    //---------------------------------- property ------------------------------------------
    @Resource
    PowerService powerService;
}

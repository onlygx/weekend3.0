package com.elangzhi.ssm.controller.admin;

import com.elangzhi.ssm.controller.BaseController;
import com.elangzhi.ssm.controller.json.Tip;
import com.elangzhi.ssm.tools.PageData;
import com.elangzhi.ssm.model.Power;
import com.elangzhi.ssm.services.PowerService;
import com.elangzhi.ssm.tools.UUIDFactory;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.print.attribute.IntegerSyntax;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by GaoXiang on 2016/2/29 0029.
 */

@Controller
@RequestMapping("/power")
public class PowerController extends BaseController<Power> {







    //---------------------------------- property ------------------------------------------
    @Resource
    PowerService powerService;
}

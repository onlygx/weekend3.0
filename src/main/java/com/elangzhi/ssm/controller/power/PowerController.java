package com.elangzhi.ssm.controller.power;

import com.elangzhi.ssm.controller.AdminBaseController;
import com.elangzhi.ssm.controller.util.ParamMap;
import com.elangzhi.ssm.model.Power;
import com.elangzhi.ssm.services.PowerService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 权限 Controller
 * @author GaoXiang
 * @version 1.0
 */
@Controller
@RequestMapping("/power")
public class PowerController extends AdminBaseController<Power> {

    /**
     * 获取全部权限，主要用于权限父类选择
     * @return 全部权限列表，第一层list的parentId 为 0
     * @throws Exception 返回全部权限列表错误
     */
    @RequestMapping("/listAll")
    public ModelAndView listAll() throws Exception {
        return new ModelAndView("admin/power/chooseParent","powerList",powerService.listAll());
    }

    /**
     * 统计这一个父类下的权限有多少个，用于判断该权限排序
     * @param request 请求参数
     * @return 统计结果
     * @throws Exception 权限个数统计错误
     */
    @RequestMapping("/countByParentId")
    @ResponseBody
    public Integer countByParentId(HttpServletRequest request) throws Exception {
        ParamMap paramMap = new ParamMap(request);
        PageInfo<Power> pageInfo = powerService.list(paramMap);
        return pageInfo.getList().size();
    }



    //---------------------------------- property ------------------------------------------
    @Resource
    PowerService powerService;
}

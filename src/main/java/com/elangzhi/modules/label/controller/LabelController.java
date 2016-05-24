package com.elangzhi.modules.label.controller;

import com.elangzhi.ssm.controller.AdminBaseController;
import com.elangzhi.ssm.model.Label;
import com.elangzhi.modules.label.services.LabelService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;

/**
* 标签 Controller
* @author GaoXiang
* @version 1.0
*/
@Controller
@RequestMapping("/label")
public class LabelController extends AdminBaseController<Label> {







    //---------------------------- property -------------------------------

    @Resource
    private LabelService labelService;

}

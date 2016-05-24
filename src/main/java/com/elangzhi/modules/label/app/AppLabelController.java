package com.elangzhi.modules.label.app;

import com.elangzhi.modules.label.services.LabelService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;

/**
* 标签 客户端接口 Controller
* @author GaoXiang
* @version 1.0
*/
@Controller
@RequestMapping("/app/label")
public class AppLabelController {







    //---------------------------- property -------------------------------

    @Resource
    private LabelService labelService;

}

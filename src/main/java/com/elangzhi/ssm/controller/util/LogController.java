package com.elangzhi.ssm.controller.util;

import com.elangzhi.ssm.controller.AdminBaseController;
import com.elangzhi.ssm.model.Log;
import com.elangzhi.ssm.services.LogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;

/**
* 日志 Controller
* @author GaoXiang
* @version 1.0
*/
@Controller
@RequestMapping("/log")
public class LogController extends AdminBaseController<Log> {







    //---------------------------- property -------------------------------

    @Resource
    private LogService logService;

}

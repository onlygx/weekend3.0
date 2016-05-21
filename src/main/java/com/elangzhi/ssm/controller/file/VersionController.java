package com.elangzhi.ssm.controller.file;

import com.elangzhi.ssm.controller.AdminBaseController;
import com.elangzhi.ssm.model.Version;
import com.elangzhi.ssm.services.VersionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;

/**
* 客户端版本 Controller
* @author GaoXiang
* @version 1.0
*/
@Controller
@RequestMapping("/version")
public class VersionController extends AdminBaseController<Version> {







    //---------------------------- property -------------------------------

    @Resource
    private VersionService versionService;

}

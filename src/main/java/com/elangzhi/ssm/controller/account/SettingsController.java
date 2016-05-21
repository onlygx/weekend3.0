package com.elangzhi.ssm.controller.account;

import com.elangzhi.ssm.controller.AdminBaseController;
import com.elangzhi.ssm.model.Settings;
import com.elangzhi.ssm.services.SettingsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;

/**
* 客户设置 Controller
* @author GaoXiang
* @version 1.0
*/
@Controller
@RequestMapping("/settings")
public class SettingsController extends AdminBaseController<Settings> {







    //---------------------------- property -------------------------------

    @Resource
    private SettingsService settingsService;

}

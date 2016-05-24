package com.elangzhi.modules.${lower}.controller;

import com.elangzhi.ssm.controller.AdminBaseController;
import ${modelPackage};
import ${servicePackage};
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;

/**
* ${modelName} Controller
* @author GaoXiang
* @version 1.0
*/
@Controller
@RequestMapping("/${lower}")
public class ${upper}Controller extends AdminBaseController<${upper}> {







    //---------------------------- property -------------------------------

    @Resource
    private ${upper}Service ${lower}Service;

}

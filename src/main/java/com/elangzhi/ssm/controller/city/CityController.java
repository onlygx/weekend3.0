package com.elangzhi.ssm.controller.city;

import com.elangzhi.ssm.controller.AdminBaseController;
import com.elangzhi.ssm.model.City;
import com.elangzhi.ssm.services.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;

/**
 * 城市 Controller
 * @author GaoXiang
 * @version 1.0
 */
@Controller
@RequestMapping("/city")
public class CityController extends AdminBaseController<City> {







    //---------------------------- property ---------------------

    @Resource
    private CityService cityService;

}

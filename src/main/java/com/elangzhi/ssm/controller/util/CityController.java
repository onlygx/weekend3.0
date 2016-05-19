package com.elangzhi.ssm.controller.util;

import com.elangzhi.ssm.controller.AdminBaseController;
import com.elangzhi.ssm.model.City;
import com.elangzhi.ssm.services.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;

/**
 * 城市管理
 * Created by GaoXiang on 2016/5/16 0016.
 * version 1.0
 */
@Controller
@RequestMapping("/city")
public class CityController extends AdminBaseController<City> {







    //---------------------------- property ---------------------

    @Resource
    private CityService cityService;

}

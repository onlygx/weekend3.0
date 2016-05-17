package com.elangzhi.ssm.services;

import com.elangzhi.ssm.dao.CityDao;
import com.elangzhi.ssm.model.City;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * Created by GaoXiang on 2016/5/16 0016.
 */
@Service
public class CityService extends BaseService<City> {

    @Resource
    private CityDao cityDao;


}

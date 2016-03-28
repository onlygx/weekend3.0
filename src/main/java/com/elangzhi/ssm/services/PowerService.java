package com.elangzhi.ssm.services;

import com.elangzhi.ssm.dao.LzDao;
import com.elangzhi.ssm.model.Power;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by GaoXiang on 2016/3/2 0002.
 */
@Service
public class PowerService extends BaseService<Power> {

    @Resource
    private LzDao<Power> lzDao;

}

package com.elangzhi.ssm.services;

import com.elangzhi.ssm.dao.AdminDao;
import com.elangzhi.ssm.model.Admin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by GaoXiang on 2016/5/3 0003.
 */
@Service
public class AdminService extends BaseService<Admin>{

    @Resource
    private AdminDao adminDao;


}

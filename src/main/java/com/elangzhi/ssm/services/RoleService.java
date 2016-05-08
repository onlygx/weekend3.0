package com.elangzhi.ssm.services;

import com.elangzhi.ssm.dao.RoleDao;
import com.elangzhi.ssm.model.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by GaoXiang on 2016/5/3 0003.
 */
@Service
public class RoleService extends BaseService<Role>{

    @Resource
    private RoleDao roleDao;


}

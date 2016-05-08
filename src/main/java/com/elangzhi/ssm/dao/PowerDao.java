package com.elangzhi.ssm.dao;

import com.elangzhi.ssm.model.Account;
import com.elangzhi.ssm.model.Power;
import com.elangzhi.ssm.model.Role;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author GaoXiang
 * 权限
 * @time 2016/5/3 0003
 **/
@Repository
public class PowerDao extends LzDao<Power> {


    /**
     * 获取用户权限
     * @param account
     * @return
     */
    public PageInfo<Power> findByAccount(Account account) {
        try {
            return list("PowerMapper.findByAccount",account);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取角色权限
     * @param role
     * @return
     */
    public PageInfo<Power> findByRole(Role role) {
        try {
            return list("PowerMapper.findByRole",role);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

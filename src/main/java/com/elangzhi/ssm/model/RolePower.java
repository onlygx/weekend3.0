package com.elangzhi.ssm.model;

import com.elangzhi.ssm.model.base.BaseModel;

public class RolePower extends BaseModel {

    private Long id;

    /**
     * 角色Id
     */
    private Long roleId;

    /**
     * 权限Id
     */
    private Long powerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPowerId() {
        return powerId;
    }

    public void setPowerId(Long powerId) {
        this.powerId = powerId;
    }
}
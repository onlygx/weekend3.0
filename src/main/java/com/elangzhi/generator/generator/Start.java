package com.elangzhi.generator.generator;

import com.elangzhi.ssm.model.AccountRole;
import com.elangzhi.ssm.model.RolePower;

/**
 * 生成代码
 * Created by GaoXiang on 2016/5/19 0019.
 */
public class Start {

    public static void main(String[] args) {

        new ModuleConfig("角色权限",RolePower.class).startGenerator();
        new ModuleConfig("用户角色",AccountRole.class).startGenerator();

    }
}

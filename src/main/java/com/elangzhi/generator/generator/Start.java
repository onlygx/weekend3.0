package com.elangzhi.generator.generator;

import com.elangzhi.ssm.model.RolePower;
import com.elangzhi.ssm.model.Version;

/**
 * Created by GaoXiang on 2016/5/19 0019.
 */
public class Start {
    public static void main(String[] args) {

        new ModuleConfig("角色权限管理",RolePower.class).startGenerator();

    }
}

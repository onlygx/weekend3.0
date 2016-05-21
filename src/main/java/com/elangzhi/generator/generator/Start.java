package com.elangzhi.generator.generator;

import com.elangzhi.ssm.model.*;

/**
 * 生成代码
 * Created by GaoXiang on 2016/5/19 0019.
 */
public class Start {

    public static void main(String[] args) {

        new ModuleConfig("客户端版本",Version.class).startGenerator();
        new ModuleConfig("客户设置",Settings.class).startGenerator();
        new ModuleConfig("角色权限",RolePower.class).startGenerator();
        new ModuleConfig("角色",Role.class).startGenerator();
        new ModuleConfig("权限",Power.class).startGenerator();
        new ModuleConfig("日志",Log.class).startGenerator();
        new ModuleConfig("城市",City.class).startGenerator();
        new ModuleConfig("管理员",Admin.class).startGenerator();
        new ModuleConfig("管理员角色",AccountRole.class).startGenerator();
        new ModuleConfig("账户",Account.class).startGenerator();

    }
}

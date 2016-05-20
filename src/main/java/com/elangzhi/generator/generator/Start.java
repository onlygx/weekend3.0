package com.elangzhi.generator.generator;

import com.elangzhi.ssm.model.AccountRole;
import com.elangzhi.ssm.model.Label;
import com.elangzhi.ssm.model.RolePower;
import com.elangzhi.ssm.model.Version;

/**
 * 生成代码
 * Created by GaoXiang on 2016/5/19 0019.
 */
public class Start {

    public static void main(String[] args) {

        new ModuleConfig("标签管理",Label.class).startGenerator();

    }
}

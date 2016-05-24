package com.elangzhi.generator.generator;

import com.elangzhi.ssm.model.*;

/**
 * 生成代码
 * Created by GaoXiang
 */
public class Start {

    public static void main(String[] args) {

        new ModuleConfig("商品评价",Version.class).startGenerator();

    }
}

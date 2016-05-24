package com.elangzhi.generator.util;

/**
 * 实体属性遍历工具
 * Created by GaoXiang
 */
public class ModelField {

    private String name;                        //首字母小写
    private String nameParam;             //首字母小写 两边加上 #{}
    private String under;                      //下划线分隔，小写
    private String intro;                        //简介


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameParam() {
        return nameParam;
    }

    public void setNameParam(String nameParam) {
        this.nameParam = nameParam;
    }

    public String getUnder() {
        return under;
    }

    public void setUnder(String under) {
        this.under = under;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}

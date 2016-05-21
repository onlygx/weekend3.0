package com.elangzhi.ssm.model;

import com.elangzhi.ssm.model.base.BaseModel;

import java.util.List;

public class Power extends BaseModel {

    private Long id;

    private String name;

    private String intro;

    private Long parentId;

    private Integer type;

    private String url;

    private Integer sort;

    private String icon;

    //自定义
    private Long belong;//是否包含在某个集合里 我的权限 或者某个角色
    private List<Power> powers; // 下级权限


    public Long getBelong() {
        return belong;
    }

    public void setBelong(Long belong) {
        this.belong = belong;
    }

    public List<Power> getPowers() {
        return powers;
    }

    public void setPowers(List<Power> powers) {
        this.powers = powers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }
}
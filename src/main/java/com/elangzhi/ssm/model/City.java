package com.elangzhi.ssm.model;

import com.elangzhi.ssm.model.base.BaseModel;

public class City extends BaseModel {

    private Long id;

    private Long parentId;

    private String name;

    private String py;

    private String code;

    private Integer type;

    private Integer special;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPy() {
        return py;
    }

    public void setPy(String py) {
        this.py = py == null ? null : py.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSpecial() {
        return special;
    }

    public void setSpecial(Integer special) {
        this.special = special;
    }
}
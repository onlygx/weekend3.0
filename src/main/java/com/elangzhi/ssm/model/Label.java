package com.elangzhi.ssm.model;

public class Label {
    private Long id;

    private String name;

    private Integer type;

    private String intro;

    private Integer status;

    public Label(Long id, String name, Integer type, String intro, Integer status) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.intro = intro;
        this.status = status;
    }

    public Label() {
        super();
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
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
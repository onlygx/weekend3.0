package com.elangzhi.ssm.tools;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by GaoXiang on 2016/1/14 0014.
 */
@Component
public class ProjectConfig {

    @Value("#{projectConfigurer['page.size']}")
    private Integer pageSize;

    @Value("#{projectConfigurer['file.tempImagePath']}")
    private String tempImagePath;


    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getTempImagePath() {
        return tempImagePath;
    }

    public void setTempImagePath(String tempImagePath) {
        this.tempImagePath = tempImagePath;
    }
}

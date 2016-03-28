package com.elangzhi.ssm.tools;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by GaoXiang on 2016/1/14 0014.
 */
@Component
public class ProjectConfig {

    @Value("${page.size}")
    private String pageSize;

    @Value("${page.index}")
    private String pageIndex;

    @Value("${page.current}")
    private String pageCurrent;

    @Value("${page.total}")
    private String pageTotal;


    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(String pageIndex) {
        this.pageIndex = pageIndex;
    }

    public String getPageCurrent() {
        return pageCurrent;
    }

    public void setPageCurrent(String pageCurrent) {
        this.pageCurrent = pageCurrent;
    }

    public String getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(String pageTotal) {
        this.pageTotal = pageTotal;
    }
}

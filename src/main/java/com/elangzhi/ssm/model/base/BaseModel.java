package com.elangzhi.ssm.model.base;

import java.io.Serializable;
import java.util.List;

/**
 * Created by GaoXiang on 2016/5/16 0016.
 */
public class BaseModel implements Serializable {

    /**
     * 批量删除的id
     */
    private List<String> ids;

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }
}

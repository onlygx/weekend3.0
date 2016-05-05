package com.elangzhi.ssm.services;

import com.elangzhi.ssm.dao.LzDao;
import com.elangzhi.ssm.dao.PowerDao;
import com.elangzhi.ssm.model.Power;
import com.elangzhi.ssm.tools.PageData;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GaoXiang on 2016/3/2 0002.
 */
@Service
public class PowerService extends BaseService<Power> {

    @Resource
    private PowerDao powerDao;


    /**
     * 获取
     * @param pd
     * @return
     */
    public PageInfo<Power> list(PageData pd) {
        return super.list(pd, Power.class);
    }

    /**
     * 分级获取权限
     * @return
     */
    public List<Power> listAll() {

        List<Power> p = list(new PageData(),Power.class).getList();
        List<Power> menu = searchListByParentId(p,0l);
        for(Power pp : menu){
            pp.setPowers(searchListByParentId(p,pp.getId()));
            for(Power ppp : pp.getPowers()){
                ppp.setPowers(searchListByParentId(p,ppp.getId()));
            }
        }
        return menu;
    }

    /**
     * 在list中寻找指定parentid的数据 并返回
     * @param list
     * @param parentId
     * @return
     */
    private List<Power> searchListByParentId(List<Power> list,Long parentId){
        List<Power> temp = new ArrayList<Power>();
        for(Power p : list){
            if(p.getParentId().equals(parentId)){
                temp.add(p);
            }
        }
        return temp;
    }
}

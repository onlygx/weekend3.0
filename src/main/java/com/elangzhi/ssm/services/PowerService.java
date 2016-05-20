package com.elangzhi.ssm.services;

import com.elangzhi.ssm.dao.PowerDao;
import com.elangzhi.ssm.model.Account;
import com.elangzhi.ssm.model.Power;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by GaoXiang on 2016/3/2 0002.
 */
@Service
public class PowerService extends BaseService<Power> {

    @Resource
    private PowerDao powerDao;


    /**
     * 获取列表
     * @param map
     * @return
     */
    public PageInfo<Power> list(Map map) throws Exception {
        return super.list(map,Power.class);
    }

    /**
     * 获取指定用户的权限列表
     * @param account
     * @return
     */
    public List<Power> findByAccount(Account account){

        List<Power> p = powerDao.findByAccount(account).getList();
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
     * 分级获取权限
     * @return
     */
    public List<Power> listAll() throws Exception {

        List<Power> p = list(new HashMap()).getList();
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

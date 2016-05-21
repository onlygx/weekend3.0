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
 * 权限 Service
 * @author GaoXiang
 * @version 1.0
 */
@Service
public class PowerService extends BaseService<Power> {

    @Resource
    private PowerDao powerDao;

    /**
     * 获取用户权限
     * @param accountId 根据用户获取用户所有角色的权限
     * @return 用户权限列表
     */
    public List<Power> findByAccountId(Long accountId){

        List<Power> p = powerDao.findByAccountId(accountId).getList();
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
     * 获取全部权限，主要用于权限父类选择
     * @return 全部权限列表，第一层list的parentId 为 0
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
     * @param list 全部权限
     * @param parentId 父级id
     * @return 所属父级的全部权限
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

    /**
     * 保存数据
     * @param power 实体对象
     * @return 实体id
     * @throws Exception 数据保存异常
     */
    public Integer insert(Power power) throws Exception {
        return powerDao.insert(power);
    }

    /**
     * 根据 id 修改
     * @param power 带id的实体对象
     * @return 受影响的行数
     * @throws Exception 数据修改异常
     */
    public Integer updateById(Power power) throws Exception {
        return powerDao.updateById(power);
    }

    /**
     * 根据 id 删除
     * @param id 数据id
     * @return 受影响的行数
     * @throws Exception 数据删除异常
     */
    public Integer deleteById(Long id) throws Exception {
        return powerDao.deleteById(id);
    }

    /**
     * 根据 id 查找
     * @param id 实体id
     * @return 实体
     * @throws Exception 查询异常
     */
    public Power selectById(Long id) throws Exception {
        return powerDao.selectById(id);
    }

    /**
     * 根据 id 批量删除
     * @param ids 要删除的id
     * @return 影响的行数
     * @throws Exception 数据删除异常
     */
    public Integer deleteByIds(List<Long> ids) throws Exception {
        return powerDao.deleteByIds(ids);
    }

    /**
     * 查询列表
     * @param map 参数
     * @return 列表
     * @throws Exception 数据返回异常
     */
    public PageInfo<Power> list(Map map) throws Exception {
        return powerDao.list(map);
    }

    /**
     * 查询列表 带分页
     * @param map 参数
     * @param page 页码
     * @param size 每页大小
     * @return 列表
     * @throws Exception 数据返回异常
     */
    public PageInfo<Power> list(Map map,int page,int size) throws Exception {
        return powerDao.list(map,page,size);
    }


}

package com.elangzhi.ssm.dao;

import com.elangzhi.ssm.model.Account;
import com.elangzhi.ssm.model.Power;
import com.elangzhi.ssm.model.Role;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 权限 Dao
 * @author GaoXiang
 * @version 1.0
 */
@Repository
public class PowerDao extends LzDao<Power> {


    /**
     * 获取用户权限
     * @param accountId 根据用户获取用户所有角色的权限
     * @return 用户权限列表
     */
    public PageInfo<Power> findByAccountId(Long accountId) {
        try {
            return list("PowerMapper.findByAccountId",accountId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取角色权限
     * @param roleId 角色id
     * @return 全部权限，属于本角色的 belong列为角色id
     */
    public PageInfo<Power> findByRoleId(Long roleId) {
        try {
            return list("PowerMapper.findByRoleId",roleId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    /**
     * 保存数据
     * @param power 实体对象
     * @return 实体id
     * @throws Exception 数据保存异常
     */
    public Integer insert(Power power) throws Exception {
        return insert("PowerMapper.insert",power);
    }

    /**
     * 根据 id 修改
     * @param power 带id的实体对象
     * @return 受影响的行数
     * @throws Exception 数据修改异常
     */
    public Integer updateById(Power power) throws Exception {
        return update("PowerMapper.updateById",power);
    }

    /**
     * 根据 id 删除
     * @param id 数据id
     * @return 受影响的行数
     * @throws Exception 数据删除异常
     */
    public Integer deleteById(Long id) throws Exception {
        return delete("PowerMapper.deleteById",id);
    }

    /**
     * 根据 id 查找
     * @param id 实体id
     * @return 实体
     * @throws Exception 查询异常
     */
    public Power selectById(Long id) throws Exception {
        return selectOne("PowerMapper.selectById",id);
    }

    /**
     * 根据 id 批量删除
     * @param ids 要删除的id
     * @return 影响的行数
     * @throws Exception 数据删除异常
     */
    public Integer deleteByIds(List<Long> ids) throws Exception {
        return delete("PowerMapper.deleteByIds",ids);
    }

    /**
     * 查询列表
     * @param map 参数
     * @return 列表
     * @throws Exception 数据返回异常
     */
    public PageInfo<Power> list(Map map) throws Exception {
        return list("PowerMapper.list",map);
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
        return list("PowerMapper.list",map,new RowBounds(page,size));
    }

}

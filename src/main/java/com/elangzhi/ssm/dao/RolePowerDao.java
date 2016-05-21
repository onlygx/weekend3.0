package com.elangzhi.ssm.dao;

import com.elangzhi.ssm.model.RolePower;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
* 角色权限 Dao
* @author GaoXiang
* @version 1.0
*/
@Repository
public class RolePowerDao extends LzDao<RolePower> {



    /**
    * 保存数据
    * @param rolePower 实体对象
    * @return 实体id
    * @throws Exception 数据保存异常
    */
    public Integer insert(RolePower rolePower) throws Exception {
        return insert("RolePowerMapper.insert",rolePower);
    }

    /**
    * 根据 id 修改
    * @param rolePower 带id的实体对象
    * @return 受影响的行数
    * @throws Exception 数据修改异常
    */
    public Integer updateById(RolePower rolePower) throws Exception {
        return update("RolePowerMapper.updateById",rolePower);
    }

    /**
    * 根据 id 删除
    * @param id 数据id
    * @return 受影响的行数
    * @throws Exception 数据删除异常
    */
    public Integer deleteById(Long id) throws Exception {
        return delete("RolePowerMapper.deleteById",id);
    }

    /**
    * 根据 id 查找
    * @param id 实体id
    * @return 实体
    * @throws Exception 查询异常
    */
    public RolePower selectById(Long id) throws Exception {
        return selectOne("RolePowerMapper.selectById",id);
    }

    /**
    * 根据 id 批量删除
    * @param ids 要删除的id
    * @return 影响的行数
    * @throws Exception 数据删除异常
    */
    public Integer deleteByIds(List<Long> ids) throws Exception {
        return delete("RolePowerMapper.deleteByIds",ids);
    }

    /**
    * 查询列表
    * @param map 参数
    * @return 列表
    * @throws Exception 数据返回异常
    */
    public PageInfo<RolePower> list(Map map) throws Exception {
        return list("RolePowerMapper.list",map);
    }

    /**
    * 查询列表 带分页
    * @param map 参数
    * @param page 页码
    * @param size 每页大小
    * @return 列表
    * @throws Exception 数据返回异常
    */
    public PageInfo<RolePower> list(Map map,int page,int size) throws Exception {
        return list("RolePowerMapper.list",map,new RowBounds(page,size));
    }

}

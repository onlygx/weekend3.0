package com.elangzhi.ssm.dao;

import com.elangzhi.ssm.model.Account;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.StringTypeHandler;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 账户 Dao
 * @author GaoXiang
 * @version 1.0
 */
@Repository
public class AccountDao extends LzDao<Account> {

    /**
     * 根据用户账号查询
     * @param userName 用户账号
     * @return 账号实体
     * @throws Exception 获取用户账号错误
     */
    public Account findByUserName(String userName) throws Exception {
        return selectOne("AccountMapper.findByUserName", userName);
    }

    /**
     * 保存数据
     * @param account 实体对象
     * @return 实体id
     * @throws Exception 数据保存异常
     */
    public Integer insert(Account account) throws Exception {
        return insert("AccountMapper.insert",account);
    }

    /**
     * 根据 id 修改
     * @param account 带id的实体对象
     * @return 受影响的行数
     * @throws Exception 数据修改异常
     */
    public Integer updateById(Account account) throws Exception {
        return update("AccountMapper.updateById",account);
    }

    /**
     * 根据 id 删除
     * @param id 数据id
     * @return 受影响的行数
     * @throws Exception 数据删除异常
     */
    public Integer deleteById(Long id) throws Exception {
        return delete("AccountMapper.deleteById",id);
    }

    /**
     * 根据 id 查找
     * @param id 实体id
     * @return 实体
     * @throws Exception 查询异常
     */
    public Account selectById(Long id) throws Exception {
        return selectOne("AccountMapper.selectById",id);
    }

    /**
     * 根据 id 批量删除
     * @param ids 要删除的id
     * @return 影响的行数
     * @throws Exception 数据删除异常
     */
    public Integer deleteByIds(List<Long> ids) throws Exception {
        return delete("AccountMapper.deleteByIds",ids);
    }

    /**
     * 查询列表
     * @param map 参数
     * @return 列表
     * @throws Exception 数据返回异常
     */
    public PageInfo<Account> list(Map map) throws Exception {
        return list("AccountMapper.list",map);
    }

    /**
     * 查询列表 带分页
     * @param map 参数
     * @param page 页码
     * @param size 每页大小
     * @return 列表
     * @throws Exception 数据返回异常
     */
    public PageInfo<Account> list(Map map,int page,int size) throws Exception {
        return list("AccountMapper.list",map,new RowBounds(page,size));
    }
}

package com.elangzhi.ssm.services;

import com.elangzhi.ssm.dao.AccountRoleDao;
import com.elangzhi.ssm.model.AccountRole;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
* 管理员角色 Service
* @author GaoXiang
* @version 1.0
*/
@Service
public class AccountRoleService extends BaseService<AccountRole> {

    @Resource
    private AccountRoleDao accountRoleDao;


    /**
    * 保存数据
    * @param accountRole 实体对象
    * @return 实体id
    * @throws Exception 数据保存异常
    */
    public Integer insert(AccountRole accountRole) throws Exception {
        return accountRoleDao.insert(accountRole);
    }

    /**
    * 根据 id 修改
    * @param accountRole 带id的实体对象
    * @return 受影响的行数
    * @throws Exception 数据修改异常
    */
    public Integer updateById(AccountRole accountRole) throws Exception {
        return accountRoleDao.updateById(accountRole);
    }

    /**
    * 根据 id 删除
    * @param id 数据id
    * @return 受影响的行数
    * @throws Exception 数据删除异常
    */
    public Integer deleteById(Long id) throws Exception {
        return accountRoleDao.deleteById(id);
    }

    /**
    * 根据 id 查找
    * @param id 实体id
    * @return 实体
    * @throws Exception 查询异常
    */
    public AccountRole selectById(Long id) throws Exception {
        return accountRoleDao.selectById(id);
    }

    /**
    * 根据 id 批量删除
    * @param ids 要删除的id
    * @return 影响的行数
    * @throws Exception 数据删除异常
    */
    public Integer deleteByIds(List<Long> ids) throws Exception {
        return accountRoleDao.deleteByIds(ids);
    }

    /**
    * 查询列表
    * @param map 参数
    * @return 列表
    * @throws Exception 数据返回异常
    */
    public PageInfo<AccountRole> list(Map map) throws Exception {
        return accountRoleDao.list(map);
    }

    /**
    * 查询列表 带分页
    * @param map 参数
    * @param page 页码
    * @param size 每页大小
    * @return 列表
    * @throws Exception 数据返回异常
    */
    public PageInfo<AccountRole> list(Map map,int page,int size) throws Exception {
        return accountRoleDao.list(map,page,size);
    }


}

package com.elangzhi.ssm.services;

import com.elangzhi.ssm.dao.LogDao;
import com.elangzhi.ssm.model.Log;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
* 日志 Service
* @author GaoXiang
* @version 1.0
*/
@Service
public class LogService extends BaseService<Log> {

    @Resource
    private LogDao logDao;


    /**
    * 保存数据
    * @param log 实体对象
    * @return 实体id
    * @throws Exception 数据保存异常
    */
    public Integer insert(Log log) throws Exception {
        return logDao.insert(log);
    }

    /**
    * 根据 id 修改
    * @param log 带id的实体对象
    * @return 受影响的行数
    * @throws Exception 数据修改异常
    */
    public Integer updateById(Log log) throws Exception {
        return logDao.updateById(log);
    }

    /**
    * 根据 id 删除
    * @param id 数据id
    * @return 受影响的行数
    * @throws Exception 数据删除异常
    */
    public Integer deleteById(Long id) throws Exception {
        return logDao.deleteById(id);
    }

    /**
    * 根据 id 查找
    * @param id 实体id
    * @return 实体
    * @throws Exception 查询异常
    */
    public Log selectById(Long id) throws Exception {
        return logDao.selectById(id);
    }

    /**
    * 根据 id 批量删除
    * @param ids 要删除的id
    * @return 影响的行数
    * @throws Exception 数据删除异常
    */
    public Integer deleteByIds(List<Long> ids) throws Exception {
        return logDao.deleteByIds(ids);
    }

    /**
    * 查询列表
    * @param map 参数
    * @return 列表
    * @throws Exception 数据返回异常
    */
    public PageInfo<Log> list(Map map) throws Exception {
        return logDao.list(map);
    }

    /**
    * 查询列表 带分页
    * @param map 参数
    * @param page 页码
    * @param size 每页大小
    * @return 列表
    * @throws Exception 数据返回异常
    */
    public PageInfo<Log> list(Map map,int page,int size) throws Exception {
        return logDao.list(map,page,size);
    }


}

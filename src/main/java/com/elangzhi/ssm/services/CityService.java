package com.elangzhi.ssm.services;

import com.elangzhi.ssm.dao.CityDao;
import com.elangzhi.ssm.model.City;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 城市 Service
 * @author GaoXiang
 * @version 1.0
 */
@Service
public class CityService extends BaseService<City> {

    @Resource
    private CityDao cityDao;


    /**
     * 保存数据
     * @param city 实体对象
     * @return 实体id
     * @throws Exception 数据保存异常
     */
    public Integer insert(City city) throws Exception {
        return cityDao.insert(city);
    }

    /**
     * 根据 id 修改
     * @param city 带id的实体对象
     * @return 受影响的行数
     * @throws Exception 数据修改异常
     */
    public Integer updateById(City city) throws Exception {
        return cityDao.updateById(city);
    }

    /**
     * 根据 id 删除
     * @param id 数据id
     * @return 受影响的行数
     * @throws Exception 数据删除异常
     */
    public Integer deleteById(Long id) throws Exception {
        return cityDao.deleteById(id);
    }

    /**
     * 根据 id 查找
     * @param id 实体id
     * @return 实体
     * @throws Exception 查询异常
     */
    public City selectById(Long id) throws Exception {
        return cityDao.selectById(id);
    }

    /**
     * 根据 id 批量删除
     * @param ids 要删除的id
     * @return 影响的行数
     * @throws Exception 数据删除异常
     */
    public Integer deleteByIds(List<Long> ids) throws Exception {
        return cityDao.deleteByIds(ids);
    }

    /**
     * 查询列表
     * @param map 参数
     * @return 列表
     * @throws Exception 数据返回异常
     */
    public PageInfo<City> list(Map map) throws Exception {
        return cityDao.list(map);
    }

    /**
     * 查询列表 带分页
     * @param map 参数
     * @param page 页码
     * @param size 每页大小
     * @return 列表
     * @throws Exception 数据返回异常
     */
    public PageInfo<City> list(Map map,int page,int size) throws Exception {
        return cityDao.list(map,page,size);
    }


}

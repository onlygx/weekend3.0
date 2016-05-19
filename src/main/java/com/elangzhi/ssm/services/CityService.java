package com.elangzhi.ssm.services;

import com.elangzhi.ssm.dao.CityDao;
import com.elangzhi.ssm.model.City;
import com.elangzhi.ssm.tools.PageData;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * Created by GaoXiang on 2016/5/16 0016.
 */
@Service
public class CityService extends BaseService<City> {

    @Resource
    private CityDao cityDao;

    /**
     * 查询列表 不分页
     * @param pd 参数
     * @return
     * @throws Exception
     */
    public PageInfo<City> list(PageData pd) throws Exception {

        return cityDao.list("CityMapper.list",pd);
    }

    /**
     * 查询列表 分页
     * @param pd 参数
     * @return
     * @throws Exception
     */
    public PageInfo<City> list(PageData pd,int page,int size) throws Exception {

        return cityDao.list("CityMapper.list",pd,new RowBounds(page,size));
    }


}

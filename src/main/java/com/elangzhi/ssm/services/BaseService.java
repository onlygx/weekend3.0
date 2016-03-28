package com.elangzhi.ssm.services;

import com.elangzhi.ssm.dao.LzDao;
import com.elangzhi.ssm.tools.PageData;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by GaoXiang on 2015/9/29 0029.
 */

@Service
public class BaseService<T> {

    @Resource
    private LzDao<T> lzDao;

    /**
     * 保存
     * @param t
     * @return
     * @throws Exception
     */
    public Integer save(T t) throws Exception {
        String statement = t.getClass().getSimpleName()+"Mapper.insert";
        return lzDao.save(statement,t);
    }

    /**
     * 查找
     * @param t
     * @return
     * @throws Exception
     */
    public T selectOne(T t) throws Exception {
        String statement = t.getClass().getSimpleName()+"Mapper.selectByPrimaryKey";
        return lzDao.selectOne(statement,t);
    }

    /**
     * 修改
     * @param t
     * @return
     * @throws Exception
     */
    public Integer update(T t) throws Exception {
        String statement = t.getClass().getSimpleName()+"Mapper.updateByPrimaryKey";
        return lzDao.update(statement,t);
    }

    /**
     * 删除
     * @param t
     * @return
     * @throws Exception
     */
    public Integer delete(T t) throws Exception {
        String statement = t.getClass().getSimpleName()+"Mapper.deleteByPrimaryKey";
        return lzDao.delete(statement,t);
    }


    /**
     * 查询列表
     * @param pd
     * @return
     * @throws Exception
     */
    public PageInfo list(PageData pd, Class clazz) throws Exception {
        String statement = clazz.getSimpleName()+"Mapper.list";
        return lzDao.list(statement,pd);
    }

    /**
     * 查询列表
     * @param pd
     * @return
     * @throws Exception
     */
    public PageInfo list(PageData pd,Class clazz,int page,int size) throws Exception {
        String statement = clazz.getSimpleName()+"Mapper.list";
        return lzDao.list(statement,pd,new RowBounds(page,size));
    }


}

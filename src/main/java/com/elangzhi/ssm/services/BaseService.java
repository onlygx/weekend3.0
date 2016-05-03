package com.elangzhi.ssm.services;

import com.elangzhi.ssm.dao.LzDao;
import com.elangzhi.ssm.tools.Logger;
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
    public LzDao<T> lzDao;

    /**
     * 保存
     * @param t
     * @return
     * @throws Exception
     */
    public Integer save(T t) {
        String statement = t.getClass().getSimpleName()+"Mapper.insert";
        try {
            return lzDao.save(statement,t);
        } catch (Exception e) {
            Logger.getLogger(this.getClass()).error(this.getClass()+ " 保存失败！错误原因如下：");
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 查找
     * @param t
     * @return
     * @throws Exception
     */
    public T selectOne(T t){
        String statement = t.getClass().getSimpleName()+"Mapper.selectByPrimaryKey";
        try {

            return lzDao.selectOne(statement,t);
        } catch (Exception e) {
            Logger.getLogger(this.getClass()).error(this.getClass()+ " 查找失败！错误原因如下：");
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 修改
     * @param t
     * @return
     * @throws Exception
     */
    public Integer update(T t) {
        String statement = t.getClass().getSimpleName()+"Mapper.updateByPrimaryKey";
        try {
            return lzDao.update(statement,t);
        } catch (Exception e) {
            Logger.getLogger(this.getClass()).error(this.getClass()+ " 修改失败！错误原因如下：");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 删除
     * @param t
     * @return
     * @throws Exception
     */
    public Integer delete(T t) {
        String statement = t.getClass().getSimpleName()+"Mapper.deleteByPrimaryKey";
        try {
            return lzDao.delete(statement,t);
        } catch (Exception e) {
            Logger.getLogger(this.getClass()).error(this.getClass()+ " 删除失败！错误原因如下：");
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 查询列表
     * @param pd
     * @return
     * @throws Exception
     */
    public PageInfo list(PageData pd, Class clazz) {
        String statement = clazz.getSimpleName()+"Mapper.list";
        try {
            return lzDao.list(statement,pd);
        } catch (Exception e) {
            Logger.getLogger(this.getClass()).error(this.getClass()+ " 获取列表失败！错误原因如下：");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查询列表
     * @param pd
     * @return
     * @throws Exception
     */
    public PageInfo list(PageData pd,Class clazz,int page,int size) {
        String statement = clazz.getSimpleName()+"Mapper.list";
        try {
            return lzDao.list(statement,pd,new RowBounds(page,size));
        } catch (Exception e) {
            Logger.getLogger(this.getClass()).error(this.getClass()+ " 分页获取列表失败！错误原因如下：");
            e.printStackTrace();
            return null;
        }
    }


}

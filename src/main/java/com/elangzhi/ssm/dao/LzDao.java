package com.elangzhi.ssm.dao;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;

/**
 * Created by GaoXiang on 2016/3/2 0002.
 */
@Repository
public class LzDao<T> {

    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 保存对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Integer save(String str, Object obj) throws Exception {
        return sqlSessionTemplate.insert(str, obj);
    }

    /**
     * 删除对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Integer delete(String str, Object obj) throws Exception {
        return sqlSessionTemplate.delete(str, obj);
    }

    /**
     * 修改对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Integer update(String str, Object obj) throws Exception {
        return sqlSessionTemplate.update(str, obj);
    }

    /**
     * 查找对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public T selectOne(String str, Object obj) throws Exception {
        return sqlSessionTemplate.selectOne(str, obj);
    }

    /**
     * 查找对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public PageInfo<T> list(String str, Object obj) throws Exception {
        return new PageInfo(sqlSessionTemplate.selectList(str, obj));
    }

    /**
     * 查找对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public PageInfo<T> list(String str, Object obj, RowBounds rowBounds) throws Exception {
        return new PageInfo(sqlSessionTemplate.selectList(str, obj,rowBounds));
    }
}

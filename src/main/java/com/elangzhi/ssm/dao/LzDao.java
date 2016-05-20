package com.elangzhi.ssm.dao;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;

/**
 * 基础数据访问
 * @author GaoXiang
 * @version 1.0
 */
@Repository
public class LzDao<T> {

    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 获取 sqlSessionTemplate
     * @return sqlSessionTemplate对象
     */
    @SuppressWarnings("unused")
    public SqlSessionTemplate getSqlSessionTemplate(){
        return this.sqlSessionTemplate;
    }

    /**
     * 保存对象
     * @param statement  sql模块位置陈述
     * @param parameter 实体对象
     * @return id
     * @throws Exception 保存失败
     */
    public Integer insert(String statement, Object parameter) throws Exception {
        return sqlSessionTemplate.insert(statement, parameter);
    }

    /**
     * 根据 id 删除对象
     * @param statement  sql模块位置陈述
     * @param parameter id 对象 (long / string)
     * @return 受影响行数
     * @throws Exception 删除失败
     */
    public Integer delete(String statement, Object parameter) throws Exception {
        return sqlSessionTemplate.delete(statement, parameter);
    }

    /**
     * 根据 id 修改对象
     * @param statement  sql模块位置陈述
     * @param parameter 带 id 的实体对象
     * @return 受影响行数
     * @throws Exception 修改失败
     */
    public Integer update(String statement, Object parameter) throws Exception {
        return sqlSessionTemplate.update(statement, parameter);
    }

    /**
     * 根据 id 查找对象
     * @param statement  sql模块位置陈述
     * @param parameter id 对象 (long / string)
     * @return 实体对象
     * @throws Exception 根据id查找失败
     */
    public T selectOne(String statement, Object parameter) throws Exception {
        return sqlSessionTemplate.selectOne(statement, parameter);
    }

    /**
     * 获取列表
     * @param statement  sql模块位置陈述
     * @param parameter 参数对象 (map)
     * @return 实体列表
     * @throws Exception 获取列表错误
     */
    public PageInfo<T> list(String statement, Object parameter) throws Exception {
        return new PageInfo<>(sqlSessionTemplate.selectList(statement, parameter));
    }

    /**
     * 获取列表 带分页
     * @param statement  sql模块位置陈述
     * @param parameter 参数对象 (map)
     * @param rowBounds 分页信息
     * @return PageInfo 带分页信息的列表
     * @throws Exception 获取分页列表错误
     */
    public PageInfo<T> list(String statement, Object parameter, RowBounds rowBounds) throws Exception {
        return new PageInfo<>(sqlSessionTemplate.selectList(statement, parameter,rowBounds));
    }
}

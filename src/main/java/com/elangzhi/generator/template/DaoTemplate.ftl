package com.elangzhi.modules.${lower}.dao;

import ${modelPackage};
import com.elangzhi.ssm.dao.LzDao;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

/**
* ${modelName} Dao
* @author GaoXiang
* @version 1.0
*/
@Repository
public class ${upper}Dao extends LzDao<${upper}> {



    /**
    * 保存数据
    * @param ${lower} 实体对象
    * @return 实体id
    * @throws Exception 数据保存异常
    */
    public Integer insert(${upper} ${lower}) throws Exception {
        return insert("${upper}Mapper.insert",${lower});
    }

    /**
    * 根据 id 修改
    * @param ${lower} 带id的实体对象
    * @return 受影响的行数
    * @throws Exception 数据修改异常
    */
    public Integer updateById(${upper} ${lower}) throws Exception {
        return update("${upper}Mapper.updateById",${lower});
    }

    /**
    * 根据 id 删除
    * @param id 数据id
    * @return 受影响的行数
    * @throws Exception 数据删除异常
    */
    public Integer deleteById(Long id) throws Exception {
        return delete("${upper}Mapper.deleteById",id);
    }

    /**
    * 根据 id 查找
    * @param id 实体id
    * @return 实体
    * @throws Exception 查询异常
    */
    public ${upper} selectById(Long id) throws Exception {
        return selectOne("${upper}Mapper.selectById",id);
    }

    /**
    * 根据 id 批量删除
    * @param ids 要删除的id
    * @return 影响的行数
    * @throws Exception 数据删除异常
    */
    public Integer deleteByIds(List<Long> ids) throws Exception {
        return delete("${upper}Mapper.deleteByIds",ids);
    }

    /**
    * 查询列表
    * @param map 参数
    * @return 列表
    * @throws Exception 数据返回异常
    */
    public PageInfo<${upper}> list(Map map) throws Exception {
        return list("${upper}Mapper.list",map);
    }

    /**
    * 查询列表 带分页
    * @param map 参数
    * @param page 页码
    * @param size 每页大小
    * @return 列表
    * @throws Exception 数据返回异常
    */
    public PageInfo<${upper}> list(Map map,int page,int size) throws Exception {
        return list("${upper}Mapper.list",map,new RowBounds(page,size));
    }

}

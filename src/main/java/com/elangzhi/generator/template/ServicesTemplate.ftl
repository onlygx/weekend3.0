package com.elangzhi.ssm.services;

import ${daoPackage};
import ${modelPackage};
import com.elangzhi.ssm.tools.PageData;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
* @title ${modelName}
* @author Created by GaoXiang
* @time ${dateTime}
* @version 1.0
*/
@Service
public class ${upper}Service extends BaseService<${upper}> {

    @Resource
    private ${upper}Dao ${lower}Dao;


    /**
    * 查询列表 不分页
    * @param pd 参数
    * @return
    * @throws Exception
    */
    public PageInfo<${upper}> list(PageData pd) throws Exception {

        return ${lower}Dao.list("${upper}Mapper.list",pd);
    }

    /**
    * 查询列表 分页
    * @param pd 参数
    * @return
    * @throws Exception
    */
    public PageInfo<${upper}> list(PageData pd,int page,int size) throws Exception {

        return ${lower}Dao.list("${upper}Mapper.list",pd,new RowBounds(page,size));
    }


}

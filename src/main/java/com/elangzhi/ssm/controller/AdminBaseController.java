package com.elangzhi.ssm.controller;

import com.elangzhi.generator.util.GenUtil;
import com.elangzhi.ssm.controller.json.Tip;
import com.elangzhi.ssm.controller.util.ParamMap;
import com.elangzhi.ssm.services.BaseService;
import com.elangzhi.ssm.tools.ProjectConfig;
import com.elangzhi.ssm.tools.UUIDFactory;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 基础页面访问
 * @author GaoXiang
 * @version 1.0
 */
public class AdminBaseController<T> {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource
	BaseService<T> baseService;

    @Autowired
    ProjectConfig projectConfig;
/*

    public AdminBaseController(){
        logger.error(this.getClass());
    }

    public AdminBaseController(T t){
        logger.error("获取到的类型：" + t.getClass().getSimpleName());
    }
*/

    /**
     * 进入添加页面 携带一个生成的id --> longId
     * @param model 返回的实体容器
     * @return 实体容器
     */
    @RequestMapping(value="/add")
    public ModelAndView add(ModelMap model,T t){
        model.put("longId", UUIDFactory.getLongId());
        return new ModelAndView("admin/"+ GenUtil.LowStr(t.getClass().getSimpleName()) +"/add",model);
    }


    /**
     * 进入编辑页面
     * @param model 返回的实体容器
     * @param id 实体id
     * @return 实体容器
     * @throws Exception 进入编辑页面失败
     */
    @RequestMapping(value="/edit")
    public ModelAndView edit(ModelMap model,@RequestParam Long id,T t) throws Exception {
        model.put("data",baseService.selectById(id,t.getClass()));
        return new ModelAndView("admin/"+ GenUtil.LowStr(t.getClass().getSimpleName()) +"/edit",model);
    }

    /**
     * 实体添加
     * @param obj 带id的实体对象
     * @return Tip操作状态
     * @throws Exception 数据添加异常
     */
    @RequestMapping(value="/save")
    @ResponseBody
    public Tip save(T obj) throws Exception {
        try {
            baseService.insert(obj);
            return new Tip();
        } catch (Exception e) {
            logger.error(obj.getClass()+ ": 添加失败！");
            return new Tip(1);
        }
    }

    /**
     * 根据 id 做实体修改
     * @param obj 带id的对象
     * @return Tip操作状态
     * @throws Exception 数据修改异常
     */
    @RequestMapping(value="/update")
    @ResponseBody
    public Tip update(T obj) throws Exception {
        try {
            baseService.updateById(obj);
            return new Tip();
        } catch (Exception e) {
            logger.error(obj.getClass()+ ": 修改失败！");
            return new Tip(1);
        }
    }

    /**
	 * 默认数据库删除
	 * @param id 实体id
	 * @return Tip操作状态
     */
    @RequestMapping(value="/delete")
    @ResponseBody
    public Tip delete(@RequestParam Long id,T t){
        try {
            baseService.deleteById(id,t.getClass());
            return new Tip();
        } catch (Exception e) {
            logger.error(t.getClass()+ ": 删除失败！");
            return new Tip(1);
        }
    }


    /**
     * 根据实体id列表批量删除
     * @param ids 实体id
     * @return Tip操作状态
     */
    @RequestMapping(value="/deleteByIds")
    @ResponseBody
    public Tip deleteByIds(@RequestParam("ids") List<Long> ids,T t){
        try {
            baseService.deleteByIds(ids,t.getClass());
            return new Tip();
        } catch (Exception e) {
            logger.error(t.getClass()+ ": 批量删除失败！");
            return new Tip(1);
        }
    }


    /**
     * 根据id查找
     * @param id 实体id
     * @return 实体json
     * @throws Exception 查找失败
     */
    @RequestMapping(value="/findJson")
    @ResponseBody
	public T find(@RequestParam Long id,T t) throws Exception {
		return baseService.selectById(id,t.getClass());
	}


    /**
     * 获取列表 不分页
     * @param request 请求参数
     * @return 实体列表
     * @throws Exception 获取实体列表失败
     */
    @RequestMapping(value="/all")
    public ModelAndView all(HttpServletRequest request,T t) throws Exception {
        ParamMap paramMap = new ParamMap(request);
        PageInfo<T> pageInfo =  baseService.list(paramMap,t.getClass());
        paramMap.put("pageInfo",pageInfo);
        return new ModelAndView("admin/"+ GenUtil.LowStr(t.getClass().getSimpleName()) +"/list",paramMap);
    }

    /**
     * 获取列表 分页
     * 默认第一页，每页指定行数
     * @param request 请求参数
     * @return 实体列表
     * @throws Exception 获取实体列表失败
     */
    @RequestMapping(value="/list")
    public ModelAndView list(HttpServletRequest request,T t) throws Exception {
        ParamMap paramMap = new ParamMap(request);
        PageInfo<T> pageInfo =  baseService.list(paramMap,1,projectConfig.getPageSize(),t.getClass());
        paramMap.put("pageInfo",pageInfo);
        return new ModelAndView("admin/"+ GenUtil.LowStr(t.getClass().getSimpleName()) +"/list",paramMap);
    }

    /**
     * 获取列表 分页
     * 可选择第几页
     * @param request 请求参数
     * @param page 当前页
     * @return 实体列表
     * @throws Exception 获取实体列表失败
     */
    @RequestMapping(value="/list/{page}")
    public ModelAndView list(HttpServletRequest request,@PathVariable int page,T t) throws Exception {
        ParamMap paramMap = new ParamMap(request);
        PageInfo<T> pageInfo =  baseService.list(paramMap,page,projectConfig.getPageSize(),t.getClass());
        paramMap.put("pageInfo",pageInfo);
        return new ModelAndView("admin/"+ GenUtil.LowStr(t.getClass().getSimpleName()) +"/list",paramMap);
    }

    /**
     * 获取列表 分页
     * 可选择第几页和每页大小
     * @param request 请求参数
     * @param page 当前页
     * @param size 每页大小
     * @return 实体列表
     * @throws Exception 获取实体列表失败
     */
    @RequestMapping(value="/list/{page}/{size}")
    public ModelAndView list(HttpServletRequest request, @PathVariable int page,@PathVariable int size,T t) throws Exception {
        ParamMap paramMap = new ParamMap(request);
        PageInfo<T> pageInfo =  baseService.list(paramMap,page,size,t.getClass());
        paramMap.put("pageInfo",pageInfo);
        return new ModelAndView("admin/"+ GenUtil.LowStr(t.getClass().getSimpleName()) +"/list",paramMap);
    }

}

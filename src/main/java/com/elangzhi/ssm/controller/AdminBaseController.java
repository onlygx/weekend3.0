package com.elangzhi.ssm.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.elangzhi.ssm.controller.json.Tip;
import com.elangzhi.ssm.services.BaseService;
import com.elangzhi.ssm.tools.PageData;
import com.elangzhi.ssm.tools.UUIDFactory;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;


public class AdminBaseController<T> {

	private static final long serialVersionUID = 6357869213649815390L;

	protected Logger logger = Logger.getLogger(this.getClass());

	@Resource
	BaseService<T> baseService;


    /**
     * 进入添加页面
     * @param model
     * @return
     */
    @RequestMapping(value="/add")
    public ModelAndView add(ModelMap model,T clazz){
        model.put("longId", UUIDFactory.getLongId());
        return new ModelAndView("admin/"+clazz.getClass().getSimpleName().toLowerCase()+"/add",model);
    }


    /**
     * 进入编辑页面
     * @param t
     * @param model
     * @return
     */
    @RequestMapping(value="/edit")
    public ModelAndView edit(ModelMap model,T t) throws Exception {
        model.put("data",baseService.selectOne(t));
        return new ModelAndView("admin/"+t.getClass().getSimpleName().toLowerCase()+"/edit",model);
    }

	/**
	 * 默认数据库添加
	 * @param t
	 * @return
     */
    @RequestMapping(value="/save")
    @ResponseBody
    public Tip save(T t) throws Exception {
        try {
            baseService.save(t);
            return new Tip();
        } catch (Exception e) {
            logger.getLogger(t.getClass()).error(this.getClass()+ " 保存失败！错误原因如下：");
            e.printStackTrace();
            return new Tip(1);
        }
    }

    /**
	 * 默认数据库修改
	 * @param t
	 * @return
     */
    @RequestMapping(value="/update")
    @ResponseBody
    public Tip update(T t) throws Exception {
        try {
            baseService.update(t);
            return new Tip();
        } catch (Exception e) {
            logger.getLogger(t.getClass()).error(this.getClass()+ " 修改失败！错误原因如下：");
            e.printStackTrace();
            return new Tip(1);
        }
    }

    /**
	 * 默认数据库删除
	 * @param t
	 * @return
     */
    @RequestMapping(value="/delete")
    @ResponseBody
    public Tip delete(T t){
        try {
            baseService.delete(t);
            return new Tip();
        } catch (Exception e) {
            logger.getLogger(t.getClass()).error(this.getClass()+ " 删除失败！错误原因如下：");
            e.printStackTrace();
            return new Tip(1);
        }
    }



	/**
	 * 查找一个对象（一般根据id，看sql语句写什么，只要是对象里面的属性都行）
	 * @param t
	 * @return
     */
    @RequestMapping(value="/find")
    @ResponseBody
	public ModelMap find(ModelMap model,T t) throws Exception {
        model.put("data",baseService.selectOne(t));
		return model;
	}


    /**
     * 获取所有列，不分页
     * @param clazz
     * @return
     */
    @RequestMapping(value="/list")
    public ModelAndView list(HttpServletRequest request,T clazz) throws Exception {
        PageData pd = new PageData(request);
        PageInfo<T> pageInfo =  baseService.list(pd,clazz.getClass());
        pd.put("pageInfo",pageInfo);
        return new ModelAndView("admin/"+clazz.getClass().getSimpleName().toLowerCase()+"/list",pd);
    }

    /**
     * 获取所有列，分页默认10条
     * @param clazz
     * @return
     */
    @RequestMapping(value="/list/{page}")
    public ModelAndView list(HttpServletRequest request,T clazz,@PathVariable int page) throws Exception {
        PageData pd = new PageData(request);
        PageInfo<T> pageInfo =  baseService.list(pd,clazz.getClass(),page,10);
        pd.put("pageInfo",pageInfo);
        return new ModelAndView("admin/"+clazz.getClass().getSimpleName().toLowerCase()+"/list",pd);
    }

    /**
     * 获取所有列，自定义分页
     * @param clazz
     * @return
     */
    @RequestMapping(value="/list/{page}/{size}")
    public ModelAndView list(HttpServletRequest request,T clazz,@PathVariable int page,@PathVariable int size) throws Exception {
        PageData pd = new PageData(request);
        PageInfo<T> pageInfo =  baseService.list(pd,clazz.getClass(),page,size);
        pd.put("pageInfo",pageInfo);
        return new ModelAndView("admin/"+clazz.getClass().getSimpleName().toLowerCase()+"/list",pd);
    }

}

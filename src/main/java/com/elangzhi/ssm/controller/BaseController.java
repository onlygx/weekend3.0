package com.elangzhi.ssm.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.elangzhi.ssm.tools.PageData;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;


public class BaseController {
	
	protected Logger logger = Logger.getLogger(this.getClass());

	private static final long serialVersionUID = 6357869213649815390L;
	
	/**
	 * 得到PageData
	 */
	public PageData getPageData(){
		return new PageData(this.getRequest());
	}
	

	/**
	 * 得到request对象
	 */
	public static HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		
		return request;
	}

	/**
	 * 添加session
	 * @param sessionName
	 * @param object
     */
	public void putSession(String sessionName,Object object){
		getRequest().getSession().setAttribute(sessionName,object);
	}

    /**
     * 获取session
     * @param sessionName
     * @return
     */
	public Object getSession(String sessionName){
		return getRequest().getSession().getAttribute(sessionName);
	}

    /**
     * 删除session
     * @param sessionName
     */
    public void removeSession(String sessionName){
        getRequest().getSession().removeAttribute(sessionName);
    }


	
}

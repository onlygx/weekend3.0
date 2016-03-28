package com.elangzhi.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elangzhi.ssm.model.Account;
import com.elangzhi.ssm.tools.Const;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 
* 类名称：LoginHandlerInterceptor.java
* 类描述：拦截器
* @author Gx
* @version 1.6
 */
public class LoginHandlerInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		if(path.matches(Const.NO_INTERCEPTOR_PATH)){
			return true;
		}else{
			HttpSession session = request.getSession();
			Account account = (Account)session.getAttribute(Const.SESSION_ACCOUNT);
			if(account != null){
				path = path.substring(1, path.length());
				/*boolean b = Jurisdiction.hasJurisdiction(path);
				if(!b){
					response.sendRedirect(request.getContextPath() + Const.LOGIN);
				}*/
				return true;
			}else{
				//登陆过滤
				response.sendRedirect(request.getContextPath() + Const.LOGIN);
				return false;		
				//return true;
			}
		}
	}
	
}

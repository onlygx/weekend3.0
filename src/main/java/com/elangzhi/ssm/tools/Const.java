package com.elangzhi.ssm.tools;

import org.springframework.context.ApplicationContext;
/**
 * 项目名称：
 * @author:fh
 * 
*/
public class Const {
	public static final String SESSION_SECURITY_CODE = "sessionSecCode";
	public static final String SESSION_ACCOUNT = "sessionAccount";
	public static final String SESSION_USER = "sessionUser";
	public static final String LOGIN = "/login_test";
	//不对匹配该值的访问路径拦截（正则）
	public static final String NO_INTERCEPTOR_PATH = ".*/((login)|(logout)|(code)|(app)|(weixin)|(static)|(main)|(websocket)).*";


	

	

	
}

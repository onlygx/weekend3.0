package com.elangzhi.ssm.tools;

import org.springframework.context.ApplicationContext;
/**
 * 项目session
 * 
*/
public class Const {

	public static final String SECURITY_CODE = "secCode";
	public static final String ACCOUNT = "account";
	public static final String ADMIN = "admin";
	public static final String USER = "user";
	public static final String LOGIN = "/login/loginPage";
	//不对匹配该值的访问路径拦截（正则）
	public static final String NO_INTERCEPTOR_PATH = ".*/((login)|(logout)|(code)|(app)|(weixin)|(static)|(main)|(websocket)).*";


	

	

	
}

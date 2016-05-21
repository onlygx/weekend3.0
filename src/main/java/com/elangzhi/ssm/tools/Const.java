package com.elangzhi.ssm.tools;


/**
 * 项目session字典
 * @author GaoXiang
 * @version 1.0
*/
public class Const {

	/**
	 * 不对匹配该值的访问路径拦截（正则）
	 */
	public static final String NO_INTERCEPTOR_PATH = ".*/((login)|(logout)|(code)|(app)|(weixin)|(static)|(main)|(websocket)).*";

	/**
	 * 登陆界面
	 */
	public static final String LOGIN = "/login/";

	/**
	 * 登陆验证码
	 */
	public static final String SECURITY_CODE = "secCode";

	/**
	 * 账号
	 */
	public static final String ACCOUNT = "account";

	/**
	 * 管理员
	 */
	public static final String ADMIN = "admin";

	/**
	 * 用户
	 */
	public static final String USER = "user";

	/**
	 * 权限集合 用于界面遍历
	 */
	public static final String POWER_LIST = "powerList";

	/**
	 * 某用户的所有权限列表，用于判断权限
	 */
	public static final String ACCOUNT_POWER_LIST = "accountPowerList";

	/**
	 * 某角色的权限列表
	 */
	public static final String ROLE_POWER_LIST = "rolePowerList";

	

	

	
}

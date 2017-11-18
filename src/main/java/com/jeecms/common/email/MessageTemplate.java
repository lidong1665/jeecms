package com.jeecms.common.email;

/**
 * 邮件模板
 */
public interface MessageTemplate {
	/**
	 * 找回密码主题
	 * 
	 * @return
	 */
	public String getForgotPasswordSubject();

	/**
	 * 找回密码内容
	 * 
	 * @return
	 */
	public String getForgotPasswordText();
	
	/**
	 * 注册主题
	 * 
	 * @return
	 */
	public String getRegisterSubject();

	/**
	 * 注册内容
	 * 
	 * @return
	 */
	public String getRegisterText();
}

package com.struts2test02;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

public class UserAction implements SessionAware, ApplicationAware {
	private String username;

	public String Logout() {
		// 1.数量-1,获取在线人数，若数量还大于0，-1
		Integer count = (Integer) application.get("count");
		if (count != null && count > 0) {
			count--;
			application.put("count", count);
		}

		// 2.session失效
		((SessionMap<String, Object>) session).invalidate();
		return "Logout-success";
	}

	public String execute() {
		// 1.把用户信息存入Session域中

		// 2.获取session.通过实现SessionAware接口

		// 3.获取登录信息：通过在Action中添加setter方法

		// 4.把用户信息存入Session域中
		session.put("username", username);
		// 4.在线人数+1；
		// 1.获取当前在线人数，从application中获取
		Integer count = (Integer) application.get("count");
		if (count == null) {
			count = 0;
		}
		// 2.是当前在线人数+1
		count++;
		application.put("count", count);
		return "login-success";
	}

	private Map<String, Object> session;

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	private Map<String, Object> application;

	@Override
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

}

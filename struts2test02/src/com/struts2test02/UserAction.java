package com.struts2test02;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

public class UserAction implements SessionAware, ApplicationAware {
	private String username;

	public String Logout() {
		// 1.����-1,��ȡ����������������������0��-1
		Integer count = (Integer) application.get("count");
		if (count != null && count > 0) {
			count--;
			application.put("count", count);
		}

		// 2.sessionʧЧ
		((SessionMap<String, Object>) session).invalidate();
		return "Logout-success";
	}

	public String execute() {
		// 1.���û���Ϣ����Session����

		// 2.��ȡsession.ͨ��ʵ��SessionAware�ӿ�

		// 3.��ȡ��¼��Ϣ��ͨ����Action�����setter����

		// 4.���û���Ϣ����Session����
		session.put("username", username);
		// 4.��������+1��
		// 1.��ȡ��ǰ������������application�л�ȡ
		Integer count = (Integer) application.get("count");
		if (count == null) {
			count = 0;
		}
		// 2.�ǵ�ǰ��������+1
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

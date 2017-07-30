package com.struts2test02;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class TestActionContextAction {
	public String execute() {
		// ��ȡActionContext����ActionContext��Action�������Ķ��󣬿��Դ��л�ȡ����ǰ��Ҫ��һ�ж���
		ActionContext actionContext = ActionContext.getContext();
		// 1.��ȥapplication��Ӧ��Map�������������һ������
		//ͨ������ActionContext�����getApplication()������ȡapplication�����Map����
		java.util.Map<String, Object> applicationMap = actionContext.getApplication();
		applicationMap.put("applicationKey", "applicationValue");
		// 2.Session
		Map<String, Object> session = actionContext.getSession();
		session.put("sessionKey", "sessionValue");
		// 3.request
		Map<String, Object> requestMap=(Map<String, Object>) actionContext.get("request");
		requestMap.put("requestKey", "requestValue");
		// 4.��ȡ����������Ӧ��Map������ȡָ���Ĳ���
		//����������������֣�ֵ;���������ֵ��Ӧ���ַ�������
		//1.getParameters�ķ���ֵΪ��Map<String,Object>,������Map<String,String[]>
		//2.parameters���Mapֻ�ܶ٣�����д�����ݣ����д�룬��������������
		Map<String, Object> parameters=actionContext.getParameters();
		System.out.println(((String[])parameters.get("name"))[0]);
		return "success";
	}
}

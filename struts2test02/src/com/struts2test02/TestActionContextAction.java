package com.struts2test02;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class TestActionContextAction {
	public String execute() {
		// 获取ActionContext对象，ActionContext是Action的上下文对象，可以从中获取到当前需要的一切对象
		ActionContext actionContext = ActionContext.getContext();
		// 1.后去application对应的Map，并向其中添加一个属性
		//通过调用ActionContext对象的getApplication()方法获取application对象的Map对象
		java.util.Map<String, Object> applicationMap = actionContext.getApplication();
		applicationMap.put("applicationKey", "applicationValue");
		// 2.Session
		Map<String, Object> session = actionContext.getSession();
		session.put("sessionKey", "sessionValue");
		// 3.request
		Map<String, Object> requestMap=(Map<String, Object>) actionContext.get("request");
		requestMap.put("requestKey", "requestValue");
		// 4.获取请求桉树对应的Map，并获取指定的参数
		//键：请求参数的名字；值;请求参数的值对应的字符串数组
		//1.getParameters的返回值为在Map<String,Object>,而不是Map<String,String[]>
		//2.parameters这个Map只能顿，不能写入数据，如果写入，不出错，不起作用
		Map<String, Object> parameters=actionContext.getParameters();
		System.out.println(((String[])parameters.get("name"))[0]);
		return "success";
	}
}

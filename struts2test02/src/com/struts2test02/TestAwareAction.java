package com.struts2test02;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

public class TestAwareAction implements ApplicationAware ,SessionAware,RequestAware,ParameterAware{
	public String execute() {
		// 1.向application中加入一个属性：applicationKey2-applicationValue
		application.put("applicationKey2", "applicationValue");
		// 2.从application中读取一个属性date，并打印
        System.out.println(application.get("date"));
		return "success";
	}
    private Map<String, Object> application;
	@Override
	public void setApplication(Map<String, Object> application) {
		this.application=application;

	}
	@Override
	public void setParameters(Map<String, String[]> arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
}

package com.struts2test02;

public class TestResultAction {
	private int number;

	public void setNumber(int number) {
		this.number = number;
	}

	public String execute() {
		String result = null;
		// 1.根据请求参数number的值，返回对应的jsp页面
		
		// 2.若number是3个整数，返回success.jsp页面
		if(number%3==2)
			result="success";
		
		// 3.若number 除以3余1，返回login.jsp
		else if(number%3==1)
			result="login";
		// 4.若number除以3余2，则返回index.jsp
		else
			result="index";
		
		return result;
	}
}

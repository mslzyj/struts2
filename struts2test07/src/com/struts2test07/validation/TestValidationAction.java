package com.struts2test07.validation;

import com.opensymphony.xwork2.ActionSupport;

public class TestValidationAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int age;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String execute() throws Exception {
		System.out.println("age"+age);
		return SUCCESS;
	}

}

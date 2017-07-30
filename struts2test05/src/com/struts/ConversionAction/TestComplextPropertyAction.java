package com.struts.ConversionAction;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.struts.model.Department;

public class TestComplextPropertyAction extends ActionSupport implements ModelDriven<Department> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		System.out.println(department);
		return "success";
	}

	private Department department;

	@Override
	public Department getModel() {
		department=new Department();
		// TODO Auto-generated method stub
		return department;
	}
}

package com.struts2test02;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class TestServletActionContextAction {
	public String execute() {
		/**
		 * ServletActionContext:可以从中获取到当前Action
		 * 常用的方法：
		 *  1.获取HttpServletRequest：ServletActionContext.getRequest();
		 *  2.获取HttpSession：ServletActionContext.getRequest().getSession();
		 *  获取ServletContext：ServletActionContext.getServletContext();
		 */
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = ServletActionContext.getRequest().getSession();
		ServletContext servletContext = ServletActionContext.getServletContext();
		System.out.println("execute...");
		return "success";
	}
}

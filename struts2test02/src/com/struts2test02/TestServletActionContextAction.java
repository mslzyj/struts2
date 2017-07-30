package com.struts2test02;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class TestServletActionContextAction {
	public String execute() {
		/**
		 * ServletActionContext:���Դ��л�ȡ����ǰAction
		 * ���õķ�����
		 *  1.��ȡHttpServletRequest��ServletActionContext.getRequest();
		 *  2.��ȡHttpSession��ServletActionContext.getRequest().getSession();
		 *  ��ȡServletContext��ServletActionContext.getServletContext();
		 */
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = ServletActionContext.getRequest().getSession();
		ServletContext servletContext = ServletActionContext.getServletContext();
		System.out.println("execute...");
		return "success";
	}
}

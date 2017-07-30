package com.struts2test02;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

public class TestServletAwareAction  implements ServletRequestAware,ServletContextAware,ServletResponseAware{
/**
 * 通过实现由ServletXxxAware接口的方式可以由Struts2 注入
 * 需要的Servlet相关的对象
 * ServletRequestAware:注入HttpServletRequest对象（比较常用）
 * ServletContextAware：注入ServletContext对象（比较常用）
 * ServletResponseAware：注入HttpServletreaponse对象
 * 
 * 
 */
	
	private ServletContext context;
	@Override
	public void setServletResponse(HttpServletResponse response) {
		System.out.println(response);
	}

	@Override
	public void setServletContext(ServletContext context) {
		System.out.println(context);
		this.context=context;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		System.out.println(request);
		
	}
	public String execute(){
	  System.out.println("ServletContext: "+context);
		return "execute..";
	}
   
}

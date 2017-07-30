package com.struts2test02;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

public class TestServletAwareAction  implements ServletRequestAware,ServletContextAware,ServletResponseAware{
/**
 * ͨ��ʵ����ServletXxxAware�ӿڵķ�ʽ������Struts2 ע��
 * ��Ҫ��Servlet��صĶ���
 * ServletRequestAware:ע��HttpServletRequest���󣨱Ƚϳ��ã�
 * ServletContextAware��ע��ServletContext���󣨱Ƚϳ��ã�
 * ServletResponseAware��ע��HttpServletreaponse����
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

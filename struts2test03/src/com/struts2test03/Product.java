package com.struts2test03;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

public class Product implements RequestAware, SessionAware {
	private Integer productId;
	private String productName;
	private String productDesc;
	private double productPrice;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}
    
	public void setProductName(String productName) {
		this.productName = productName;
	}
    
	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDesc=" + productDesc
				+ ", productPrice=" + productPrice + "]";
	}

	private java.util.List<Person> persons = new ArrayList<Person>();

	public java.util.List<Person> getPersons() {
		return persons;
	}

	public String testTag() {
		this.productId = 1001;
		this.productDesc = "desc";
		this.productName = "productName";
		this.productPrice = 1000;

		persons.add(new Person("D", 40));
		persons.add(new Person("B", 20));
		persons.add(new Person("C", 30));
		persons.add(new Person("A", 10));

		return "success";
	}

	public String save() {
		// 在此方法中获取值栈，并往值栈中放一个对象(用property标签通过ognl读取值栈中的值)
		// 1.获取值栈對象
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		// 2.创建test对象，并为其属性赋值
		Test test = new Test();
		test.setProductDesc("AA");
		test.setProductName("ab");
		// 3.把test对象压入到值栈的栈顶
		valueStack.push(test);

		sessionMap.put("product", this);
		requestMap.put("test", test);
		int i = 10 / 0; // 测试出现异常进行处理的方法
		return "success";
	}

	private Map<String, Object> sessionMap;

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;

	}

	private Map<String, Object> requestMap;

	@Override
	public void setRequest(Map<String, Object> requestMap) {
		this.requestMap = requestMap;

	}

}

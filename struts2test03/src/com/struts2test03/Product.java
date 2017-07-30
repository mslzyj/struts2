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
		// �ڴ˷����л�ȡֵջ������ֵջ�з�һ������(��property��ǩͨ��ognl��ȡֵջ�е�ֵ)
		// 1.��ȡֵջ����
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		// 2.����test���󣬲�Ϊ�����Ը�ֵ
		Test test = new Test();
		test.setProductDesc("AA");
		test.setProductName("ab");
		// 3.��test����ѹ�뵽ֵջ��ջ��
		valueStack.push(test);

		sessionMap.put("product", this);
		requestMap.put("test", test);
		int i = 10 / 0; // ���Գ����쳣���д���ķ���
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

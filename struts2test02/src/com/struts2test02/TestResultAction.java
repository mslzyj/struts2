package com.struts2test02;

public class TestResultAction {
	private int number;

	public void setNumber(int number) {
		this.number = number;
	}

	public String execute() {
		String result = null;
		// 1.�����������number��ֵ�����ض�Ӧ��jspҳ��
		
		// 2.��number��3������������success.jspҳ��
		if(number%3==2)
			result="success";
		
		// 3.��number ����3��1������login.jsp
		else if(number%3==1)
			result="login";
		// 4.��number����3��2���򷵻�index.jsp
		else
			result="index";
		
		return result;
	}
}

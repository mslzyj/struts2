package com.struts.ConversionAction;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.struts.model.Customer;

public class ConversionAction extends ActionSupport implements ModelDriven<Customer>{
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String execute(){
		System.out.println("model.."+model);
		return SUCCESS;
	}
  private Customer model;
	@Override
	public Customer getModel() {
		model =new Customer();
		return model;
	}
}

package com.struts2test04;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class EmployeeAction implements RequestAware, ModelDriven<Employee>, Preparable {
	private Dao dao = new Dao();
	private Employee employee;

	public String update() {
		dao.update(employee);
		return "update";
	}
	
	public void prepareUpdate(){
		employee = new Employee();
	}

	public String edit() {
		return "edit";
	}

	public void prepareEdit() {
		employee = dao.get(employeeId);
	}

	public String save() {
		// 2.调用Dao的save方法
		dao.save(employee);
		return "save";
	}

	public void prepareSave() {
		employee = new Employee();
	}

	public String delete() {
		dao.delete(employeeId);
		// 返回结果的类型应为:redirectAction,也可以是chain:实际上chain是没有必要的，因为不需要在下一个Action中保留当前的Action的状态
		// 若使用chain，则多达目标页面后，地址栏显示的依然是删除的那个连接，刷新时会有臭婆娘功夫提交
		return "delete";
	}

	public String list() {
		request.put("emps", dao.getEmployee());
		return "list";
	}

	private Map<String, Object> request;

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public Integer employeeId;

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public Employee getModel() {
		return employee;
	}

	@Override
	public void prepare() throws Exception {
		System.out.println("prepare...");
	}
}

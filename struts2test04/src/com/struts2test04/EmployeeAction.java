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
		// 2.����Dao��save����
		dao.save(employee);
		return "save";
	}

	public void prepareSave() {
		employee = new Employee();
	}

	public String delete() {
		dao.delete(employeeId);
		// ���ؽ��������ӦΪ:redirectAction,Ҳ������chain:ʵ����chain��û�б�Ҫ�ģ���Ϊ����Ҫ����һ��Action�б�����ǰ��Action��״̬
		// ��ʹ��chain������Ŀ��ҳ��󣬵�ַ����ʾ����Ȼ��ɾ�����Ǹ����ӣ�ˢ��ʱ���г����﹦���ύ
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

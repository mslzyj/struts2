package com.struts.model;
/**
 * 1.Department��ģ�ͣ�ʵ��¼���Department��deptName����ֱ��д�뵽
 * s:textfieldD�������У�manager���ԵĴ���
 * Struts2����ǩ��nameֵ���Ա���ֵΪ���Ե����ԣ�name=manager.name , name=manager.birth
 * 2.manager����һ��Date��birth���ԣ��������Զ�ת��
 *Title:Department
 *@author zyj
 *@date2017��7��25������11:04:04
 */
public class Department {
	private Integer id;
	private String deptName;
	private Manager manager;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", deptName=" + deptName + ", manager=" + manager + "]";
	}

}

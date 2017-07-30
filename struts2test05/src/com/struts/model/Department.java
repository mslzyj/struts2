package com.struts.model;
/**
 * 1.Department是模型，实际录入的Department，deptName可以直接写入到
 * s:textfieldD的属性中，manager属性的处理。
 * Struts2表单标签的name值可以被赋值为属性的属性：name=manager.name , name=manager.birth
 * 2.manager中有一个Date的birth属性，如何完成自动转换
 *Title:Department
 *@author zyj
 *@date2017年7月25日上午11:04:04
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

package com.struts2test03;

import java.util.List;

public class UserAction {
	private String userId;
	private String useName;
	private String password;
	private String desc;
	private boolean married;
	
	private String gender;
	private List<String> city;
    private String age;
    

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<String> getCity() {
		return city;
	}

	public void setCity(List<String> city) {
		this.city = city;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUseName() {
		return useName;
	}

	public void setUseName(String useName) {
		this.useName = useName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String save() {
		System.out.println(this);
		UserAction ua = new UserAction();
		ua.setDesc("desc");
		ua.setPassword("123456");
		ua.setUserId("1001");
		ua.setUseName("xain");
		//ActionContext.getContext().getValueStack().push(ua); 加上此语句则不回显
		return "input";
	}

	@Override
	public String toString() {
		return "UserAction [userId=" + userId + ", useName=" + useName + ", password=" + password + ", desc=" + desc
				+ ", married=" + married + ", gender=" + gender + ", city=" + city + ", age=" + age
				+ "]";
	}

	

}

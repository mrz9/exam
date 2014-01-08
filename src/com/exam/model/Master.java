package com.exam.model;

public class Master extends User{
	
	private String name;
	private String sex;
	private String department;
	private String birthday;
	private String power;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	@Override
	public String toString() {
		return "Master [name=" + name + ", sex=" + sex + ", department="
				+ department + ", birthday=" + birthday + ", power=" + power
				+ ", toString()=" + super.toString() + "]";
	}

}

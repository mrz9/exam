package com.exam.model;

import java.sql.Date;

public class Student extends User{
	
	private String name;
	private String sex;
	private String grade;
	private String birthday;
	
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
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", sex=" + sex + ", grade=" + grade
				+ ", birthday=" + birthday + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
}

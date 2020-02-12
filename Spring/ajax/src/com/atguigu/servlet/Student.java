package com.atguigu.servlet;

public class Student {
	
	private String lastName;
	private String email;
	private Integer age;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String lastName, String email, Integer age) {
		super();
		this.lastName = lastName;
		this.email = email;
		this.age = age;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [lastName=" + lastName + ", email=" + email + ", age="
				+ age + "]";
	}
	
	
	

}

package com.atguigu.bean;

import java.util.Date;

import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Employee {

	private Integer id;
	
	@NotEmpty(message="不能为空··")  //EmployeeController.java中addEmp()中也有注解设置
	@Length(min=8,max=18,message="长度必须在8到18位之间··")
	private String lastName;
	
	@Email
	private String email;
	//1 male, 0 female
	private Integer gender;
	
	//规定页面提交的日期格式;springmvc.xml中也有设置东西
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Past //必须是一个过去的时间
	@JsonFormat(pattern="yyyy-MM-dd") //ajax中显示的日期格式
	private Date birth = new Date();
	
	//假设页面，为了显示方便提交的工资是￥10,000.98
	//@NumberFormat(pattern="￥#,###,###,##")
	//private Double salary;
	
	@JsonIgnore  //ajax中不显示改数据
	private Department department;
	
	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Employee(Integer id, String lastName, String email, Integer gender,
			Department department) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.department = department;
	}

	public Employee() {
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", email="
				+ email + ", gender=" + gender + ", birth=" + birth
				+ ", department=" + department + "]";
	}

	
	
	
}

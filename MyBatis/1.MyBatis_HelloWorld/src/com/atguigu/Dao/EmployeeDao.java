package com.atguigu.Dao;

import com.atguigu.bean.Employee;

public interface EmployeeDao {
	//数据库驱动
//	mysql-connector-java-5.1.37-bin.jar
//	log4j-1.2.17.jar
//	mybatis-3.4.1.jar
	
	//按照员工id查询员工
	public Employee getEmpById(Integer id);
}

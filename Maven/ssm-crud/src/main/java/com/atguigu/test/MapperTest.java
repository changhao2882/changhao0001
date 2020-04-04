package com.atguigu.test;


import java.io.IOException;
import java.io.InputStream;











import java.util.UUID;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.bean.Department;
import com.atguigu.bean.Employee;
import com.atguigu.dao.DepartmentMapper;
import com.atguigu.dao.EmployeeMapper;

/**
 * 推荐Spring的项目就可以使用Spring的单元测试，可以注入我们需要的组件
 * 1.导入SpringTest模块
 * 2.@ContextConfiguration指定Spring配置文件的位置
 * 3.直接@Autowired要使用的组件即可
 * @author 67557
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	
	@Autowired
	DepartmentMapper departmentMapper;
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired  
	SqlSession sqlSession;   //批量sqlSession  applicationContext.xml中也有配置
	
	//List<Employee> selectByExampleWithDept(EmployeeExample example);
	@Test
	public void test() {
//		//1.创建SpringIOC容器
//		ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
//		//2.从容器中获取mapper
//		DepartmentMapper bean = ioc.getBean(DepartmentMapper.class);

		System.out.println(departmentMapper);
		
		//1.插入几个部门
//		departmentMapper.insertSelective(new Department(null,"开发部门"));
//		departmentMapper.insertSelective(new Department(null,"测试部门"));
		
		//2.生成员工数据
		//employeeMapper.insertSelective(new Employee(null,"Jerry","M","Jerry@stguigu.com",1));
		//3.批量插入多个员工
		/*for (int i = 0; i < array.length; i++) {
			employeeMapper.insertSelective(new Employee(null,"Jerry","M","Jerry@stguigu.com",1));
		}*/
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		for (int i = 0; i < 1000; i++) {
			String uuid = UUID.randomUUID().toString().substring(0, 5) + i;
			mapper.insertSelective(new Employee(null, uuid, "M", uuid+"@atguigu.com", 1));
		}
		System.out.println("批量插入成功！");
		
	}
	
		
		
}

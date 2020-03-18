package com.atguigu.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.atguigu.dao.EmployeeDao;
import com.atguigu.dao.EmployeeDaoAnnotation;
import com.atguigu.bean.Employee;

public class MyBatisCRUDTest {
	
	//工厂来一个就行了
	SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void initSqlSessionFactory() throws IOException{
		//1.根据全局配置文件创建一个sqlSessionFactory
		//SqlSessionFactory：是SqlSession工厂，负责创建SqlSession对象；
		//SqlSession：sql会话（代表和数据库的一次会话）
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	//查询
	@Test
	public void test() throws IOException {
		
		//initSqlSessionFactory();  @Before相当于每次运行之前提前运行
		//2.获取和数据库的一次会话：openSession();;;;;每个线程都应该有一个连接，放在全局那里，相当于多个线程共用一个连接
		SqlSession openSession = sqlSessionFactory.openSession();
		
		Employee employee = null;
		try {
			//3.使用SqlSession操作数据库,获取到dao接口的实现
			EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
			//4.调用之前的方法
			employee = employeeDao.getEmpById(1);
			System.out.println(employee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			openSession.close();
		}
	}
	
	//插入
	@Test
	public void test1() {
		
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
			//调用之前的方法测试
			int i = employeeDao.insertEmployee(new Employee(null,"tomcat","wtomcat@qq.com",0));
			System.out.println(i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//更新数据库手动提交
			openSession.commit();
			openSession.close();
		}
	}
	
	//修改
	@Test
	public void test2() {
		
		//设置true是自动提交
		SqlSession openSession = sqlSessionFactory.openSession(true);
		try {
			EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
			//调用之前的方法测试
			int i = employeeDao.updateEmployee(new Employee(3,"tomcat","tomcat@qq.com",1));
			System.out.println(i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			openSession.close();
		}
	}

	//删除
	@Test
	public void test3() {
		
		//设置true是自动提交
		SqlSession openSession = sqlSessionFactory.openSession(true);
		try {
			EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
			//class com.sun.proxy.$Proxy3  代理对象
			System.out.println(employeeDao.getClass());
			
			//调用之前的方法测试
			boolean i = employeeDao.deleteEmployee(3);
			System.out.println(i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			openSession.close();
		}
	}
	
	//查询
	@Test
	public void testAnnotation() throws IOException {
			
		//initSqlSessionFactory();  @Before相当于每次运行之前提前运行
		//2.获取和数据库的一次会话：openSession();;;;;每个线程都应该有一个连接，放在全局那里，相当于多个线程共用一个连接
		SqlSession openSession = sqlSessionFactory.openSession();
			
		Employee employee = null;
		try {
			//3.使用SqlSession操作数据库,获取到dao接口的实现
			EmployeeDaoAnnotation employeeDao = openSession.getMapper(EmployeeDaoAnnotation.class);
			//4.调用之前的方法
			employee = employeeDao.getEmpById(1);
			System.out.println(employee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			openSession.close();
		}
	}
}

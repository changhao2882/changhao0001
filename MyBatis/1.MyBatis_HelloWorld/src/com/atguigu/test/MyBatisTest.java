package com.atguigu.test;



import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.atguigu.Dao.EmployeeDao;
import com.atguigu.bean.Employee;

public class MyBatisTest {

	@Test
	public void test() throws IOException {
		//1.根据全局配置文件创建一个sqlSessionFactory
		//SqlSessionFactory：是SqlSession工厂，负责创建SqlSession对象；
		//SqlSession：sql会话（代表和数据库的一次会话）
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//4.调用之前的方法
		Employee employee = null;
		//2.获取和数据库的一次会话：openSession()
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			//3.使用SqlSession操作数据库,获取到dao接口的实现
			EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
			employee = employeeDao.getEmpById(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			openSession.close();
		}
		System.out.println(employee);
	}

}

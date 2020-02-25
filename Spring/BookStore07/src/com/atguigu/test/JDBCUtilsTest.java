package com.atguigu.test;

import java.sql.Connection;

import org.junit.Test;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.entity.User;
import com.atguigu.utils.JDBCUtils;

public class JDBCUtilsTest {
	
	@Test
	public void test(){
		Connection connection = JDBCUtils.getConnection();
		System.out.println(connection);
		JDBCUtils.close(connection);
	}
	
	@Test
	public void test1(){
		//UserDao userDao = new UserDao();
		UserDao ud = new UserDaoImpl();
		//保存一个user
//		User user = new User(null, "张三", "123456", "aa@qq.com");
//		boolean b = ud.saveUser(user);
//		System.out.println("保存："+b);
	}
	
	@Test
	public void test2(){
		UserDao ud = new UserDaoImpl();
		User user = new User(null, "admin", "1234567", "aa@qq.com");
		User user2 = ud.getUserByUserNameAndPassword(user);
		System.out.println("查询到的user对象："+user2);
	}

}

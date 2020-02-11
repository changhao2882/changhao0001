package com.atguigu.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.service.BookService;
import com.atguigu.service.UserService;

public class IOCTest {
	
	ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	@Test
	public void test() {
		BookService bookService = ioc.getBean(BookService.class);
		UserService userService = ioc.getBean(UserService.class);
		bookService.save();
		userService.save();
		
		//父类的类型：class com.atguigu.service.BaseService
		//带泛型的父类类型：com.atguigu.service.BaseService<com.atguigu.bean.Book>
		//Spring可以使用带泛型的父类类型来确定这个子类的类型
		System.out.println(bookService.getClass().getGenericSuperclass());
	}

}

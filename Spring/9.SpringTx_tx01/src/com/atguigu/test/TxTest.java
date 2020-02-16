package com.atguigu.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.service.BookService;

public class TxTest {
	
	ApplicationContext ioc = new ClassPathXmlApplicationContext("tx.xml");
	@Test
	public void test() {
		BookService bean = ioc.getBean(BookService.class);
		bean.checkout("Tom", "ISBN-001");
		System.out.println("结账完成");
	}

}

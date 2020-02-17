package com.atguigu.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.service.BookService;
import com.atguigu.service.MulService;

public class TxTest {
	
	ApplicationContext ioc = new ClassPathXmlApplicationContext("tx.xml");
	@Test
	public void test() throws FileNotFoundException {
		BookService bean = ioc.getBean(BookService.class);
		bean.checkout("Tom", "ISBN-001");
		System.out.println("结账成功");
	}

}

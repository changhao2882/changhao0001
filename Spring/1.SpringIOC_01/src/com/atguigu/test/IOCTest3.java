package com.atguigu.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.bean.Person;

public class IOCTest3 {
	private ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc3.xml");

	@Test
	public void test() {
		System.out.println("容器启动完成...");
		Object bean = ioc.getBean("book");
		Object bean2 = ioc.getBean("book");
		System.out.println(bean == bean2);
	}
	
	@Test
	public void test01() {
		System.out.println("容器启动完成...");
		Object bean = ioc.getBean("airPlane01");
		System.out.println(bean);
	}
	
	@Test
	public void test02() {
		System.out.println("容器启动完成...");
		Object bean = ioc.getBean("airPlane02");
		System.out.println(bean);
	}
	
	@Test
	public void test03() {
		System.out.println("容器启动完成...");
		Object bean = ioc.getBean("myFactoryBeanImple");
		Object bean2 = ioc.getBean("myFactoryBeanImple");
		System.out.println(bean == bean2);
	}

}

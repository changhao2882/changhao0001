package com.atguigu.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.bean.Book;
import com.atguigu.bean.Car;
import com.atguigu.bean.Person;

public class IOCTest2 {
	private ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc2.xml");
	
	/**
	 * 实验4：正确的为各种属性赋值
			    测试使用null值 ,默认类型就是null，基本类型是默认值
	 */
	@Test
	public void test() {
		Person bean = (Person)ioc.getBean("person01");
		System.out.println(bean.getLastName() == null);
		
		System.out.println("person的car"+bean.getCar());
		
		Car bean2 = (Car)ioc.getBean("car01");
		bean2.setCarName("hahhah");
		System.out.println("我修改了容器中的car,你的car变了没？"+bean.getCar());
		
		Car car = bean.getCar();
		System.out.println(bean.getCar() == car);
	}
	
	@Test
	public void test01(){
		Person person01 = (Person)ioc.getBean("person01");
		Car car = person01.getCar();
		System.out.println(car);
		
		Person person02 = (Person)ioc.getBean("person02");
		List<Book> books = person02.getBooks();
		System.out.println(books);
		
		Map<String, Object> maps = person02.getMaps();
		System.out.println(maps);
		
		Properties properties = person02.getProperties();
		System.out.println(properties);
		
		System.out.println("==============");
		/**内部bean是不能用id获取的
		 * org.springframework.beans.factory.NoSuchBeanDefinitionException: 
		 * No bean named 'carInner' is defined
		 */
//		Object bean = ioc.getBean("carInner");
//		System.out.println(bean);
	}
	
	@Test
	public void test02(){
		Person person03 = (Person)ioc.getBean("person03");
		System.out.println(person03.getMaps());
		Map<String, Object> bean = (Map<String, Object>) ioc.getBean("myMap");
		System.out.println(bean.getClass());
	}
	
	/**
	 * 级联属性可以修改属性的属性；注意：原来的bean的值可能会被修改
	 */
	@Test
	public void test03(){
		Person person04 = (Person)ioc.getBean("person04");
		Object car = ioc.getBean("car01");
		System.out.println("容器中的car："+car);
		System.out.println("person中的car："+person04.getCar());
	}
	
	@Test
	public void test04(){
		/**
		 * org.springframework.beans.factory.BeanIsAbstractException: 
		 * Error creating bean with name 'person05': 
		 * Bean definition is abstract
		 */
//		Person person05 = (Person)ioc.getBean("person05");
//		System.out.println("person05:"+person05);

		Person person06 = (Person)ioc.getBean("person06");
		System.out.println("person06:"+person06);
	}

}

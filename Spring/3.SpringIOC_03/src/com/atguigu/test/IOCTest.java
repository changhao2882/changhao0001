package com.atguigu.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.service.BookService;
import com.atguigu.servlet.BookServlet;

/**
 * 使用Spring的单元测试
 * 1，导包：Spring单元测试包spring-test-4.0.0.RELEASE.jar
 * 2,@ContextConfiguration(locations="")使用它来指定Spring的配置文件的位置
 * 3，@RunWith指定用哪种驱动进行单元测试，默认就是junit
 * 		@RunWith(SpringJUnit4ClassRunner.class)
 * 		使用Spring的单元测试模块来执行标了@Test注解的测试方法
 * 		以前@Test注解只是由junit执行
 * 好处：我们不用ioc.getBean()获取组件了，直接Autowired组件，Spring为我们自动装配
 * @author 67557
 *
 */
@ContextConfiguration(locations="classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class IOCTest {
	//ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
	ApplicationContext ioc =null;
	
	@Autowired
	private BookServlet bookServlet;
	@Autowired
	private BookService bookService;
	@Test
	public void test04() {
		System.out.println(bookServlet);
		bookServlet.doGet();
		System.out.println(bookService);
	}
	
	@Test
	public void test() {
		/**
		 * Caused by: java.lang.ClassNotFoundException: 
		 * org.springframework.aop.TargetSource
		 * 
		 * 使用注解加入到容器中的组件，和使用配置加入到容器中的组件行为都是默认一样的
		 * 1）组件的id默认就是组件的类名首字母小写
		 * 		修改：@Repository("bookhahahah")
					public class BookDao {
		 * 2）组件的作用域，默认就是单实例的
		 * 		修改：@Scope(value="prototype")
		 */
		Object bean = ioc.getBean("bookDao");
		Object bean2 = ioc.getBean("bookDao");
		System.out.println(bean == bean2);
	}
	
	@Test
	public void test02() {
		BookServlet bookServlet = ioc.getBean(BookServlet.class);
		bookServlet.doGet();
	}
	
	@Test
	public void test03() {
	}

}

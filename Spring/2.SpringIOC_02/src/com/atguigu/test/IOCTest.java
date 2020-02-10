package com.atguigu.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCTest {
	
	ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
	ConfigurableApplicationContext ioc02 = new ClassPathXmlApplicationContext("applicationContext02.xml");
	ConfigurableApplicationContext ioc03 = new ClassPathXmlApplicationContext("applicationContext03.xml");
	
	/**
	 * 单实例：Bean的生命周期
	 * 		（容器启动）构造器--->初始化方法--->（容器关闭）销毁方法
	 * 多实例：
	 * 		获取bean（构造器--->初始化方法）--->容器关闭不会调用bean的销毁方法
	 * 后置处理器：
	 * 		（容器启动）构造器--->postProcessBeforeInitialization--->初始化方法--->postProcessAfterInitialization--->bean初始化完成
	 * 无论bean有没有初始化方法，后置处理器都会默认其有，还会继续工作
	 */
	
	@Test
	public void test() {
		Object bean = ioc.getBean("book01");
		System.out.println("容器关闭了..."+bean);
		
		Object bean2 = ioc.getBean("car01");
		System.out.println(bean2);
		//ioc.close();
	}
	
	@Test
	public void test02() throws SQLException {
		//1.从容器中拿到连接池
		//DataSource bean = (DataSource) ioc02.getBean("dataSource");
		
		//2.按照类型获取组件，可以获取到这个类型下的所有实现子类等等。。。
		DataSource bean = ioc02.getBean(DataSource.class);
		System.out.println(bean.getConnection());
		
		Object bean2 = ioc02.getBean("car01");
		System.out.println(bean2);
	}
	
	/**
	 * 测试基于XML的自动装配（自定义类型自动赋值）
	 */
	@Test
	public void test03() {
		Object person = ioc03.getBean("person");
		System.out.println(person);
	}
	
	/**
	 * 实验14：[SpEL测试I]
	 */
	@Test
	public void test04() {
		Object person = ioc03.getBean("person01");
		System.out.println(person);
	}

}

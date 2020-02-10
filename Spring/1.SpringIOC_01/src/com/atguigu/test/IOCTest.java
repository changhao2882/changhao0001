package com.atguigu.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.bean.Person;

public class IOCTest {
	
	private ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml"); 
	
	/**
	 * 存在的几个问题：
	 * 1）src,源码包开始的路径，称为类路径的开始；
	 * 		所有源码包里面的东西都会被合并放在类路径里面
	 * 		java:/bin/
	 * 		web:/WEB-INF/classes/
	 * 2）导包commons-logging-1.1.3.jar（依赖）
	 * 3）先导包再创建配置文件；
	 * 4）Spring的容器接管了标志S的类
	 */
	/**
	 * 几个细节：ApplicationContext（IOC容器的接口）
	 * 1）ClassPathXmlApplicationContext("ioc.xml"); ioc容器的配置文件在类路径下 com/atguigu/bean/ioc.xml
	 * 	FileSystemXmlApplicationContext("F://ioc.xml"); ioc容器的配置文件在磁盘路径下
	 * 2）给容器中注册一个组件，我们也从容器中按照id拿到了这个组件的对象？
	 * 		组件的创建工作是容器完成的
	 * 		Person对象是什么时候创建好了呢？
	 * 		容器中对象的创建在容器创建完成的时候就已经创建好了
	 * 3）同一个组件在容器中是单实例的，容器启动完成之前都已经创建准备好了
	 * 4）容器中如果没有这个组件，获取组件？（报异常）
	 * 		org.springframework.beans.factory.NoSuchBeanDefinitionException: 
	 * 		No bean named 'person03' is defined
	 * 5）ioc容器在创建这个组件对象的时候，（property）会利用setter方法为JavaBean的属性进行赋值
	 * 6）JavaBean的属性名是由什么决定的？（getter/setter方法是属性名；set去掉后面那一串首字母小写就是属性名）
	 * 		注意：Boolean类型命名以is开头的set方法很坑爹；所有getter/setter都自动生成！！！
	 * 		private String lastName;？？？
	 */
	
	/**
	 * 从容器中拿到这个组件
	 */
	@Test
	public void test() {
		//ApplicationContext代表IOC容器
		//ClassPathXmlApplicationContext：当前应用的xml文件在ClassPath下
		//根据spring的配置文件得到ioc容器对象
		ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml"); 
		//容器帮我们创建好对象了
		System.out.println("容器启动完成...");
		Person bean = (Person)ioc.getBean("person01");
		Object bean2 = ioc.getBean("person01");
		System.out.println(bean == bean2);//true
		System.out.println("==========");
//		Object bean3 = ioc.getBean("person000003");
	}
	
	/**
	 * 实验2：根据bean的类型从IOC容器中获取bean的实例★
	 * 如果ioc容器中这个类型的bean有多个，查找就会报错（
	 * 		//		Person bean01 = ioc.getBean(Person.class);
	 *		//		System.out.println(bean01);		
	 * ）
	 * org.springframework.beans.factory.NoUniqueBeanDefinitionException: 
	 * 		No qualifying bean of type [com.atguigu.bean.Person] is defined: 
	 * 		expected single matching bean but found 2: person01,person02
	 */
	@Test
	public void test01(){
//		Person bean01 = ioc.getBean(Person.class);
//		System.out.println(bean01);
		Person bean02 = ioc.getBean("person02", Person.class);
		System.out.println(bean02);
		Person bean03 = (Person)ioc.getBean("person03");
		System.out.println(bean03);
		Person bean04 = (Person)ioc.getBean("person04");
		System.out.println(bean04);
		Person bean05 = (Person)ioc.getBean("person05");
		System.out.println(bean05);
		Person bean06 = (Person)ioc.getBean("person06");
		System.out.println(bean06);
	}

}

package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 1.告诉SpringMVC这是一个处理器，可以处理请求
 * 		@Controller:标识哪个组件是控制器
 * @author 67557
 *
 *哈哈 13:53:20
	HelloWorld：细节：
	1、运行流程：
		1)、客户端点击链接会发送http://localhost:8080/springmvc/hello
		2)、来到tomcat服务器
		3)、SpringMVC的前端控制器收到所有请求
		4)、来看请求地址和@RequestMapping标注的哪个匹配，来找找到底使用哪个类的哪个方法
		5)、前端控制器找到了目标处理器类和目标方法，直接利用反射执行目标方法
		6)、方法执行完成以后会有一个返回值；SpringMVC认为这个返回值就是要去的页面地址
		7)、拿到方法返回值以后，用视图解析器进行拼串得到完整的页面地址
		8)、拿到页面地址，前端控制器帮我们转发到页面
	
	2、@RequestMapping
		就是告诉SpringMVC，这个方法用来处理什么请求；
		这个／是可以省略，即使省略了，也是默认从当前项目下开始；
		习惯加上比较好
		@RequestMapping的使用：？
	3、如果不指定配置文件位置？
		/WEB-INF/springDispatcherServlet-servlet.xml
		如果不指定也会默认位置去找一个文件：
			/WEB-INF/springDispatcherServlet-servlet.xml
		就在web应用/WEB-INF,下创建一个名叫：  前端控制器-servlet.xml
 *
 */
@Controller
public class MyFirstController {
	/**
	 *   /代表从当前项目下开始；处理当前项目下的hello请求
	 */
	@RequestMapping("/hello")
	public String myfirstRequest(){
		System.out.println("请求收到了......正在处理中");
		//视图解析器自动拼串
//		<!-- 配置一个视图解析器；能帮我们拼接页面地址 -->
//		<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
//			<property name="prefix" value="/WEB-INF/pages/"></property>
//			<property name="suffix" value=".jsp"></property>
//		</bean>
		//   （前缀）/WEB-INF/pages/+返回值（success）+后缀（.jsp）
		return "success";
	}
	
//	@RequestMapping("/handle01")
//	public String handle01(){
//		System.out.println("handle01..");
//		return "success";
//	}

}

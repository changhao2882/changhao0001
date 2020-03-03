package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HelloController {
	
	@RequestMapping(value="/aaa")
	public String aaa() {
		System.out.println("aaa...");
		//return "forward:/WEB-INF/pages/aaa.jsp";  //OK
		//return "redirect:/WEB-INF/pages/aaa.jsp"; //404
		return "redirect:aaa.jsp";  //OK
	}
	
	@RequestMapping(value="/hello")
	public String hello() {
		System.out.println("hello...");
		//WEB-INF/pages/success.jsp
		//相对路径
		return "../../hello";
	}
	
	/**
	 * forward:转发到一个页面
	 * /hello.jsp:转发到当前项目下的hello
	 * 一定加上/，如果不加就是相对路径；容易出问题
	 * forward:/hello.jsp
	 * forward和redirect:前缀的转发和重定向不会由我们配置的视图解析器进行拼串
	 */
	@RequestMapping(value="/handle01")
	public String handle01() {
		System.out.println("handle01...");
		return "forward:/hello.jsp";
	}
	
	@RequestMapping(value="/handle02")
	public String handle02() {
		System.out.println("handle02...");
		return "forward:/handle01";
	}
	
	/**
	 * 重定向到hello.jsp
	 * 	重定向：redirect:/hello.jsp
	 * 		/hello.jsp：代表就是从当前项目下开始；SpringMVC会为路径自动接上项目名
	 * 
	 * 		原生的Servlet重定向/路径需要加上项目名才能成功
	 * 		response.sendRedirect("/hello.jsp")
	 */
	@RequestMapping(value="/handle03")
	public String handle03() {
		System.out.println("handle03...");
		return "redirect:/hello.jsp";
	}
	
	@RequestMapping(value="/handle04")
	public String handle04() {
		System.out.println("handle04...");
		return "redirect:/handle03";
	}
	
//	@RequestMapping("/toLoginPage")
//	public String toLogin(){
//		//return "forward:/WEB-INF/pages/login.jsp";
//		//return "redirect:/WEB-INF/pages/login.jsp"; //404
//		return "login";
//	}
}

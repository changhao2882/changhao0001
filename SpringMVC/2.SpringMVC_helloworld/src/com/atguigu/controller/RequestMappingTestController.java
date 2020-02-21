package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @RequestMapping的属性
 *
 */

@RequestMapping("/haha") //为当前类所有的方法指定一个基准路径
@Controller
public class RequestMappingTestController {
	@RequestMapping("/handle01")
	public String handle01(){
		System.out.println("RequestMappingTestController...handle01");
		return "success";
	}
	
	/**
	 * @RequestMapping的其他属性：
	 * method:限定请求方式
	 * 		HTTP协议中的所有请求方式：
	 * 			【GET】, HEAD, 【POST】, PUT, PATCH, DELETE, OPTIONS, TRACE
	 * 		method=RequestMethod.POST：只接受这种类型的请求，默认是什么都可以
	 * 		不是规定的方式就报错：（4xx都是客户端错误）
	 * 			405 - Request method 'GET' not supported
	 * params:规定请求参数
	 * 	params和headers支持简单的表达式：
	 *		param1:表示请求必须包含名为param1的请求参数
	 *			eg:params={"username"};没带直接404
	 *		!param1:表示请求不能包含名为param1的请求参数
	 *			eg:params={"!username"}
	 *		param1 != value1:表示请求包含名为param1的请求参数，但其值不能为value1
	 *			eg:params={"username!=111"}
	 *		{"param1 = value1","param2"}:表示请求必须包含param1和param2的两个请求参数，且param1参数的值必须为value1
	 *			eg:params={"username=111","password"}
	 * headers:规定请求头；也和params一样，能写简单的表达式
	 * consumes:只接收内容类型是哪种的请求，规定请求头中的Content-Type
	 * produces:告诉浏览器返回的内容类型是什么，给响应头中加上Content-Type:text/html;charset=utf-8
	 */
	@RequestMapping(value="/handle02",method=RequestMethod.POST)
	public String handle02(){
		System.out.println("RequestMappingTestController...handle02");
		return "success";
	}
	
	@RequestMapping(value="/handle03",params={"username=111","password"})
	public String handle03(){
		System.out.println("RequestMappingTestController...handle03");
		return "success";
	}
	
	/**
	 * User-Agent:浏览器信息
	 * 让IE能访问，谷歌不能访问
	 * 
	 * 谷歌：
	 * 		User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.88 Safari/537.36
	 * IE:
	 * 		User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.140 Safari/537.36 Edge/17.17134
	 */
	@RequestMapping(value="/handle04",headers={"User-Agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.140 Safari/537.36 Edge/17.17134"})
	public String handle04(){
		System.out.println("RequestMappingTestController...handle04");
		return "success";
	}

}

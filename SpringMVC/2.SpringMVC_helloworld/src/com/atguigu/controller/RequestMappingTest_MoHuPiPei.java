package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @PathVariable路径上可以有占位符
 * @RequestMapping模糊匹配（多个匹配情况下精确优先）
 * RequestMapping-Ant风格的URL
 *	URL地址可以写模糊的通配符
 *	？：匹配文件名中的一个字符    /不行
 *	*：匹配文件名中的任意字符，和一层路径
 *	**：匹配多层路径
 */

@Controller
public class RequestMappingTest_MoHuPiPei {
	
	@RequestMapping("/antTest01")
	public String antTest01(){
		System.out.println("RequestMappingTest_MoHuPiPei...antTest01");
		return "success";
	}
	
	@RequestMapping("/antTest0?")
	public String antTest02(){
		System.out.println("RequestMappingTest_MoHuPiPei...antTest02");
		return "success";
	}
	
	@RequestMapping("/antTe*")
	public String antTest03(){
		System.out.println("RequestMappingTest_MoHuPiPei...antTest03");
		return "success";
	}
	
	@RequestMapping("/a/*/antTest04")
	public String antTest04(){
		System.out.println("RequestMappingTest_MoHuPiPei...antTest04");
		return "success";
	}
	
	@RequestMapping("/**/antTest05")
	public String antTest05(){
		System.out.println("RequestMappingTest_MoHuPiPei...antTest05");
		return "success";
	}
	
	//路径上可以有占位符(只能占一层路径)：占位符语法就是可以在任意路径的地方写一个：{变量名}
	//   /user/admin    /user/changhao
	//   /user/{id}   /{user}/{id}  等等等。。。
	@RequestMapping("/user/{id}")
	public String pathVariableTest(@PathVariable("id")String id){
		System.out.println("RequestMappingTest_MoHuPiPei...pathVariableTest"+id);
		return "success";
	}

}

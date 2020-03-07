package com.atguigu.controller;

import java.io.FileInputStream;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.bean.Department;
import com.atguigu.bean.Employee;
import com.atguigu.dao.EmployeeDao;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Controller
public class AjaxTestController {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	/**
	 * 将返回的数据放在响应体中；
	 * 如果是对象，jackson包自动将对象转为json格式
	 * @JsonFormat(pattern="yyyy-MM-dd") //ajax中显示的日期格式
		private Date birth = new Date();
		
		@JsonIgnore  //ajax中不显示改数据
		private Department department;
	 */
	@ResponseBody
	@RequestMapping("/getallajax")
	public Collection<Employee> ajaxGetAll(){
		Collection<Employee> all = employeeDao.getAll();
		return all;
	}
	
	
	/**
	 * @RequestBody：请求体；获取一个请求体
	 * 只有post请求才有请求体；get请求没有请求体
	 * 
	 * @ResponseBody：可以把对象转为json数据，返回给浏览器
	 *  
	 * @RequestBody：接收json数据，封装为对象
	 * @return
	 */
	@RequestMapping("/testRequestBody")
	public String testRequestBody(@RequestBody Employee employee){
		System.out.println("请求体："+employee);
		return "success";
	}
	
	//获取请求体
	@RequestMapping("/test01")
	public String test01(@RequestBody String str){
		System.out.println("请求体："+str);
		return "success";
	}
	
	/**
	 * 如果参数位置写HttpEntity<String>  str;
	 * 比@RequestBody更强，可以拿到请求头【全部的请求头】（也有请求体的数据）；
	 *  @RequestHeader("")
	 * 
	 * @param str
	 * @return
	 */
	@RequestMapping("/test02")
	public String test02(HttpEntity<String> str){
		System.out.println("请求头和体---："+str);
		return "success";
	}
	
	/**
	 * 将返回数据放在响应体中(页面的内容；直接写在页面上)
	 *  @ResponseBody
		@RequestMapping("/haha")
		public String hahah(){
			return "success";
		}
	 * 
	 * 
	 * ResponseEntity<String>：响应体中内容的类型
	 * @return
	 */
	//@ResponseBody
	@RequestMapping("/haha")
	public ResponseEntity<String> hahah(){
		
		MultiValueMap<String, String> headers = new HttpHeaders();
		String body = "<h1>success</h1>";
		headers.add("Set-Cookie", "username=hahahaha");
		
		return new ResponseEntity<String>(body , headers, HttpStatus.OK);
	}
	
	
	/**
	 * SpringMVC文件下载；
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/download")
	public ResponseEntity<byte[]> download(HttpServletRequest request) throws Exception{
		
		//1、得到要下载的文件的流；
		//找到要下载的文件的真实路径
		ServletContext context = request.getServletContext();
		String realPath = context.getRealPath("/scripts/jquery-1.9.1.min.js");
		FileInputStream is = new FileInputStream(realPath);
		
		//读成一个byte数组  is.available()数组长度（文件流有多大，字节数组就多大）
		byte[] tmp = new byte[is.available()];
		is.read(tmp);
		is.close();
		
		//2、将要下载的文件流返回
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Content-Disposition", "attachment;filename="+"jquery-1.9.1.min.js");
		
		return new ResponseEntity<byte[]>(tmp, httpHeaders, HttpStatus.OK);
	}
	
}

package com.atguigu.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;

public class MyView implements View{
	/**
	 * 返回的数据的内容类型
	 */
	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return "text/html";
	}

	@Override
	public void render(Map<String, ?> arg0, HttpServletRequest arg1,
			HttpServletResponse arg2) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("之前保存的数据："+arg0);
		
		//响应还得设置内容类型；要不会乱码
		arg2.setContentType("text/html");
		
		List<String> vn = (List<String>) arg0.get("video");
		arg2.getWriter().write("哈哈<h1>即将展现精彩内容</h1>");
		for (String string : vn) {
			arg2.getWriter().write("<a href='#' >下载"+string+".avi</a><br/>");
		}
		arg2.getWriter().write(""
				+ "<script>"
				+ "window.onload = function(){"
				+ "var aEle = document.getElementsByTagName('a');"
				+ "aEle.onclick=function(){"
				+ "alert('想下载吗？交学费')"
				+ "}"
				+"}"
				+ "</script>");
	}

}

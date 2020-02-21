<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="hello">helloworld</a>
	<br>
	<h1>RequestMapping测试</h1>
	<a href="handle01">写在方法上的RequestMapping</a>
	<h1>RequestMapping测试</h1>
	<a href="haha/handle01">写在类上的RequestMapping</a>
	<h1>测试RequestMapping属性</h1>
	<a href="haha/handle02">handle02</a>
	<form action="haha/handle02" method="post">
		<input type="submit">
	</form>
	<a href="haha/handle03?username=111&password=123456">handle03_测试params</a><br>
	<a href="haha/handle04">handle04_测试headers</a><br>
	<hr>
	<h1>RequestMapping-Ant风格的URL</h1>
	<a href="antTest01">antTest01_测试(精确请求)</a><br>
	<a href="antTest02">antTest02_测试(一个字符)</a><br>
	<a href="antTest03">antTest03_测试(多个字符)</a><br>
	<a href="antTest04">antTest04_测试(一层路径)</a><br>
	<a href="antTest05">antTest05_测试(多层路径)</a><br>
	<hr>
	<h1>@PathVariable-路径上的占位符测试</h1>
	<a href="user/changhao">路径上的占位符测试_changhao</a><br>
	<a href="user/admin">路径上的占位符测试_admin</a><br>
</body>
</html>
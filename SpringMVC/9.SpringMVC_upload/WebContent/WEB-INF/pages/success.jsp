<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>成功！</h1>
	pageContext：${pageScope.msg }<br/>
	request：${requestScope.msg }<br/>
	session：${sessionScope.msg }-${sessionScope.haha}<br/>
	application：${applicationScope.msg }<br/>
	<%System.out.println("来到页面了...."); %>
	
</body>
</html>
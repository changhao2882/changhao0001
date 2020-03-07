<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	pageContext.setAttribute("ctp", request.getContextPath());
%>
<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
</head>
<body>
	<form action="${ctp }/test02" method="post" enctype="multipart/form-data">
		<input name="username" value="tomcat" /><br> 
		<input name="password" value="123456"><br>
		<input type="file" name="file" /><br>
		<input type="submit" value="ajax_获取请求体"><br>
	</form>
	<a href="${ctp }/testRequestBody">ajax发送json数据</a>
</body>
<script type="text/javascript">
	$("a:first").click(function() {
		//点击发送ajax请求，请求带的数据是json
		var emp = {
			lastName : "张三",
			email : "aaa@aa.com",
			gender : 0
		};
		//alert(typeof emp); //Object
		//js对象转成json字符串
		var empStr = JSON.stringify(emp);
		//alert(typeof empStr);  //String
		$.ajax({
			url : '${ctp}/testRequestBody',
			type : "POST",
			data : empStr,
			contentType : "application/json",
			success : function(data) {
				alert(data);
			}
		});
		return false;
	});
</script>
</html>
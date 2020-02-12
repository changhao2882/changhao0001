<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="lib/jquery-1.7.2.min.js"></script>
<% 
	pageContext.setAttribute("ctp", request.getContextPath());
%>
</head>
<body>
	<a href="ajax">ajax</a>
	<div id="displayStudent"></div>
</body>
<script type="text/javascript">
	$("a[href='ajax']").click(function(){
		//项目中直接用带项目名的绝对路径
		$.ajax({
			url:"${ctp}/ajax",
			type:"POST",
			dataType:"JSON",
			success:function(data){
				//console.log(data);
				/*$(data).each(function(){
					//this代表每一次正在遍历的对象
					//alert(this);
					alert(this.lastName);
				});*/
				
				//第一个传入要遍历的数据，第二个传入回调函数
				//回调函数可以接受两个参数;第一个参数总是代表当前遍历的元素的索引，第二个参数代表当前元素
				//元素体掏空；remove是整个元素都没了
				$("#displayStudent").empty();
				$.each(data,function(index,item){
					//alert(index+"_"+this.lastName);
					$("#displayStudent").append("<br/>学生姓名："+item.lastName)
										.append("<br/>email:"+item.email)
										.append("<br/>年龄："+item.age)
										.append("<hr/>");
				});
			}
		});
		
		//取消默认行为
		return false;
	});
</script>
</html>
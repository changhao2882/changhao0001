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
</head>
<body>
	<!-- 
		文件上传：
		1.文件上传准备：enctype="multipart/form-data"
		2.导入fileupload:
			commons-fileupload-1.2.1.jar
			commons-io-2.0.jar
		3.javaWeb:
			Object = new FileItemDiskFactory();
			ServletFileUpload upload = new ServletFileUpload(object);
			
			List<FileItem> items = upload.parseRequest(upload);
			for(FileItem item:item){
				if(item.isFiels()){
					//普通项
				}else{
					//文件项
					IOUtils.copy();//文件保存
				}
			}
		3.只要在SpringMVC配置文件中，编写一个配置，配置文件上传解析器（MultipartResolver）
		4.文件上传请求处理
			@RequestParam("headerimg")MultipartFile file;封装当前文件的信息
	 -->
	<a href="hello">hello</a>${msg}
	<form action="${ctp }/upload" method="post" enctype="multipart/form-data">
		用户头像：<input type="file" name="headerimg"><br>
		用户头像：<input type="file" name="headerimg"><br>
		用户头像：<input type="file" name="headerimg"><br>
		用户头像：<input type="file" name="headerimg"><br>
		
		用户名：<input type="text" name="username"><br>
		<input type="submit">
	</form>
</body>
</html>
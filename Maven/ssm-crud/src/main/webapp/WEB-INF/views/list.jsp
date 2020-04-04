<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工列表</title>

<%
	pageContext.setAttribute("APP_PATH",request.getContextPath());
%>
<!-- 
	不以/开始的相对路径，以当前资源路径为基准，容易出问题
	以/开始的相对路径，以服务器的路径为基准（http://localhost:3306），需要加上项目名
 -->
<!-- 引入jquery -->
<script type="text/javascript" src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
<!-- 引入Bootstrap样式 -->
<link href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<!-- 标题 -->
		<div class="row">
  			<div class="col-md-12">
  				<h1>SSM-CRUD</h1>
			</div>
		</div>
		<!-- 按钮 -->
		<div class="row">
  			<div class="col-md-4 col-md-offset-8">
  				<button class="btn btn-primary">新增</button>
  				<button class="btn btn-danger">删除</button>
  			</div>
		</div>
		<!-- 表格数据 -->
		<div class="row">
  			<div class="col-md-12">
				<table class="table table-hover">
					<tr>
						<th>#</th>
						<th>empName</th>
						<th>gender</th>
						<th>email</th>
						<th>deptName</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${pageInfo.list}" var="tea">
						<tr>
							<td>${tea.empId }</td>
							<td>${tea.empName }</td>
							<td>${tea.gender == 'M'?'男':'女' }</td>
							<td>${tea.email }</td>
							<td>${tea.department.deptName }</td>
							<td>
								<button class="btn btn-primary btn-sm">
									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
 									编辑
								</button>
								<button class="btn btn-danger btn-sm">
									<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
 									删除
								</button>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<!-- 分页信息栏 -->
		<div class="row">
			<!-- 分页信息 -->
  			<div class="col-md-6">
				当前第${pageInfo.pageNum }页,共${pageInfo.pages }页,共${pageInfo.total }条记录
			</div>
  			<!-- 分页条信息 -->
  			<div class="col-md-6">
  				<nav aria-label="Page navigation">
				  <ul class="pagination">
				  	<li>
				  		<a href="${APP_PATH }/emps?pn=1">首页</a>
				  	</li>
				  	<c:if test="${pageInfo.hasPreviousPage}">
				  		<li>
					      <a href="${APP_PATH }/emps?pn=${pageInfo.prePage }" aria-label="Previous">
					        <span aria-hidden="true">&laquo;</span>
					      </a>
					    </li>
				  	</c:if>
				    <c:forEach items="${pageInfo.navigatepageNums}" var="num">
				    	<c:if test="${num == pageInfo.pageNum }">
							<li class="active"><a href="${APP_PATH }/emps?pn=${num }">${num }</a></li>
						</c:if>
						<c:if test="${num != pageInfo.pageNum }">
								<li><a href="${APP_PATH }/emps?pn=${num }">${num }</a></li>
						</c:if>
					</c:forEach>
					<c:if test="${pageInfo.hasNextPage}">
						<li>
					      <a href="${APP_PATH }/emps?pn=${pageInfo.nextPage }" aria-label="Next">
					        <span aria-hidden="true">&raquo;</span>
					      </a>
					    </li>
					</c:if>
				    <li>
				  		<a href="${APP_PATH }/emps?pn=${pageInfo.pages }">末页</a>
				  	</li>
				  </ul>
				</nav>
  			</div>
		</div>
	</div>

















</body>
</html>
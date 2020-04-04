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
	<!-- 员工添加的模态框 -->
	<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">员工添加</h4>
	      </div>
	      <div class="modal-body">
	        <form class="form-horizontal">
			  <div class="form-group">
			    <label class="col-sm-2 control-label">empName</label>
			    <div class="col-sm-10">
			      <input type="text" name="empName" class="form-control" id="empName_add_input" placeholder="empName">
			      <span class="help-block"></span>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-2 control-label">email</label>
			    <div class="col-sm-10">
			      <input type="text" name="email" class="form-control" id="email_add_input" placeholder="email@gmail.com">
			      <span class="help-block"></span>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-2 control-label">gender</label>
			    <div class="col-sm-10">
			      <label class="radio-inline">
				  <input type="radio" name="gender" id="gender1_add_input" value="M" checked="checked"> 男
				  </label>
				  <label class="radio-inline">
					  <input type="radio" name="gender" id="gender2_add_input" value="F"> 女
				  </label>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-2 control-label">deptName</label>
			    <div class="col-sm-4">
			      <!-- 部门提交部门id即可 -->
			      <select class="form-control" name="dId">
					  
				  </select>
			    </div>
			  </div>
			  
			</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        <button type="button" class="btn btn-primary" id="emp_save_btn">确认</button>
	      </div>
	    </div>
	  </div>
	</div>

	
	
	<!-- 员工修改的模态框 -->
	<div class="modal fade" id="empUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">员工修改</h4>
	      </div>
	      <div class="modal-body">
	        <form class="form-horizontal">
			  <div class="form-group">
			    <label class="col-sm-2 control-label">empName</label>
			    <div class="col-sm-10">
			      <p class="form-control-static" id="empName_update_static"></p>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-2 control-label">email</label>
			    <div class="col-sm-10">
			      <input type="text" name="email" class="form-control" id="email_update_input" placeholder="email@gmail.com">
			      <span class="help-block"></span>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-2 control-label">gender</label>
			    <div class="col-sm-10">
			      <label class="radio-inline">
				  <input type="radio" name="gender" id="gender1_update_input" value="M" checked="checked"> 男
				  </label>
				  <label class="radio-inline">
					  <input type="radio" name="gender" id="gender2_update_input" value="F"> 女
				  </label>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-2 control-label">deptName</label>
			    <div class="col-sm-4">
			      <!-- 部门提交部门id即可 -->
			      <select class="form-control" name="dId">
					  
				  </select>
			    </div>
			  </div>
			  
			</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        <button type="button" class="btn btn-primary" id="emp_update_btn">修改</button>
	      </div>
	    </div>
	  </div>
	</div>
	


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
  				<button class="btn btn-primary" id="emp_add_modal_btn">新增</button>
  				<button class="btn btn-danger" id="emp_delete_all_btn">删除</button>
  			</div>
		</div>
		<!-- 表格数据 -->
		<div class="row">
  			<div class="col-md-12">
				<table class="table table-hover" id="emps_table">
					<thead>
						<tr>
							<th>
								<input type="checkbox" id="check_all">
							</th>
							<th>#</th>
							<th>empName</th>
							<th>gender</th>
							<th>email</th>
							<th>deptName</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						
					</tbody>
					
				</table>
			</div>
		</div>
		<!-- 分页信息栏 -->
		<div class="row">
			<!-- 分页信息 -->
  			<div class="col-md-6" id="page_info_area">
				
			</div>
  			<!-- 分页条信息 -->
  			<div class="col-md-6" id="page_nav_area">
  				
  			</div>
		</div>
	</div>
	
	<script type="text/javascript">
	
		//总记录数
		var totalRecord,currentPage;
	
		//1.页面加载完成以后，直接去发送一个Ajax请求，要到分页数据
		$(function(){
			//页面一进来就去首页
			to_page(1);
		});
		
		function to_page(pn){
			$.ajax({
				url:"${APP_PATH }/emps",
				data:"pn="+pn,
				type:"get",
				success:function(result){
					//1.解析并显示员工数据
					build_emps_table(result);
					//2.解析并显示分页信息
					build_page_info(result);
					//3.解析显示分页条
					build_page_nav(result);
				}
			});
		}
		
		function build_emps_table(result){
			//清空table表格
			$("#emps_table tbody").empty();
			
			var emps = result.extend.pageInfo.list;
			$.each(emps,function(index,item){
				var checkBoxTd = $("<td><input type='checkbox' class='check_item'></td>");
				var empIdTd = $("<td></td>").append(item.empId);
				var empNameTd = $("<td></td>").append(item.empName);
				var genderTd = $("<td></td>").append(item.gender=="M"?"男":"女");
				var emailTd = $("<td></td>").append(item.email);
				var deptNameTd = $("<td></td>").append(item.department.deptName);
				/*
					<button class="btn btn-primary btn-sm">
							<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
 							编辑
					</button>
					<button class="btn btn-danger btn-sm">
							<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
 							删除
					</button>
				*/
				var editBnt = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
						.append($("<span></span>").addClass("glyphicon glyphicon-pencil"))
						.append("编辑");
				//为编辑按钮添加保存id值的自定义属性
				editBnt.attr("edit-id",item.empId);
				var delBtn = $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
						.append($("<span></span>").addClass("glyphicon glyphicon-trash"))
						.append("删除");
				//为删除按钮添加一个自定义属性来表示当前删除的员工id
				delBtn.attr("delete-id",item.empId);
				var btn = $("<td></td>").append(editBnt).append(" ")
						.append(delBtn);
				//append方法执行完成之后还是返回原来的元素
				$("<tr></tr>").append(checkBoxTd)
					.append(empIdTd)
					.append(empNameTd)
					.append(genderTd)
					.append(emailTd)
					.append(deptNameTd)
					.append(btn)
					.appendTo("#emps_table tbody");
			});
			
		};
		//解析显示分页信息
		function build_page_info(result){
			//清空table表格
			$("#page_info_area").empty();
			
			var pageInfo = result.extend.pageInfo;
			$("#page_info_area").append("当前第"+pageInfo.pageNum+"页,共"+pageInfo.pages+"页,共"+pageInfo.total+"条记录");
			totalRecord = pageInfo.total;
			currentPage = pageInfo.pageNum;
		}
		//解析显示分页条
		function build_page_nav(result){
			//清空table表格
			$("#page_nav_area").empty();
			
			var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
			
			var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
			if(result.extend.pageInfo.hasPreviousPage == false){
				prePageLi.addClass("disabled");
				firstPageLi.addClass("disabled");
			}else{
				firstPageLi.click(function(){
					to_page(1);
				});
				prePageLi.click(function(){
					to_page(result.extend.pageInfo.pageNum - 1);
				});
			}
			
			var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
			
			var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
			if(result.extend.pageInfo.hasNextPage == false){
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			}else{
				nextPageLi.click(function(){
					to_page(result.extend.pageInfo.pageNum + 1);
				});
				lastPageLi.click(function(){
					to_page(result.extend.pageInfo.pages);
				});
			}
			
			
			var ul = $("<ul></ul>").addClass("pagination");
			
			ul.append(firstPageLi).append(prePageLi);
			$.each(result.extend.pageInfo.navigatepageNums,function(index,item){
				var numLi = $("<li></li>").append($("<a></a>").append(item));
				if(result.extend.pageInfo.pageNum == item){
					numLi.addClass("active");
				}
				numLi.click(function(){
					to_page(item);
				});
				ul.append(numLi);
			});
			ul.append(nextPageLi).append(lastPageLi);
			
			$("#page_nav_area").append("<nav></nav>").addClass("Page navigation")
			.append(ul);
			
			
		}
		//表单全部重置
		function reset_form(ele){
			$(ele)[0].reset();
			//清空样式
			$(ele).find("*").removeClass("has-success has-error");
			$(ele).find(".help-block").text("");
		}
		
		//点击新增按钮弹出模态框
		$("#emp_add_modal_btn").click(function(){
			//弹出之前清除表单数据(表单全部重置)
			reset_form("#empAddModal form");
			//$("#empAddModal form")[0].reset();
			
			//发送Ajax请求，查出部门信息，显示在下拉列表中
			getDepts("#empAddModal select");
			$("#empAddModal").modal({
				backdrop:"static"
			});
		});
		
		//查出所有部门信息并显示在下拉列表中
		function getDepts(ele){
			//清空之前下拉列表的值
			$(ele).empty();
			$.ajax({
				url:"${APP_PATH}/depts",
				type:"GET",
				success:function(result){
					$.each(result.extend.depts,function(){
						var optionEle = $("<option></option>").append(this.deptName).attr("value",this.deptId);
						optionEle.appendTo(ele);
					});
				}
			});
		}
		
		//保存员工信息
		$("#emp_save_btn").click(function(){
			//1.将模态框填写的数据提交给服务器进行保存
				//先提交给服务器进行数据校验
			if(!validate_add_form()){
				return false;
			} 
			//判断之前的Ajax用户名校验是否成功，如果成功才往下走
			if($(this).attr("ajax-va") == "error"){
				return false;
			}
			
			
			//2.发送Ajax请求保存员工信息
			$.ajax({
				url:"${APP_PATH}/emp",
				type:"POST",
				data:$("#empAddModal form").serialize(),
				success:function(result){
					//alert(result.msg);
					if(result.code == 100){
						//员工保存成功后
						//1.关闭动态框
						$('#empAddModal').modal('hide');
						//2.来到最后一页
						//发送ajax显示最后一页数据即可
						to_page(totalRecord);
					}else{
						if(undefined != result.extend.errorFields.empName){
							show_vaildate_msg("#empName_add_input","error",result.extend.errorFields.empName);
						}
						if(undefined != result.extend.errorFields.email){
							show_vaildate_msg("#email_add_input","error",result.extend.errorFields.email);
						}
					}
					
				}
			});
		});
		
		//校验用户名是否可用
		$("#empName_add_input").change(function(){
			//发送Ajax请求校验用户名是否可用checkuser
			var empName = this.value;
			$.ajax({
				url:"${APP_PATH}/checkuser",
				data:"empName="+empName,
				type:"POST",
				success:function(result){
					if(result.code == 100){
						show_vaildate_msg("#empName_add_input","success","用户名正确");
						$("#emp_save_btn").attr("ajax-va","success");
					}else{
						show_vaildate_msg("#empName_add_input","error",result.extend.va_msg);
						$("#emp_save_btn").attr("ajax-va","error");
					}
				}
			});
		});
		
		//校验表单数据
		function validate_add_form(){
			//1.拿到要校验的数据，使用正则表达式
			var empName = $("#empName_add_input").val();
			var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
			if(!regName.test(empName)){
				//alert("用户名应为2-5位中文，或者6-16位英文和数字");
				//应该清空这个元素之前的样式
				show_vaildate_msg("#empName_add_input","error","用户名应为2-5位中文，或者6-16位英文和数字");
				
				return false;
			}else{
				show_vaildate_msg("#empName_add_input","success","用户名正确");
				
			}
			//2.校验邮箱信息
			var email = $("#email_add_input").val();
			var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			if(!regEmail.test(email)){
				//alert("邮箱格式不正确");
				show_vaildate_msg("#email_add_input","error","邮箱格式不正确");
				return false;
			}else{
				show_vaildate_msg("#email_add_input","success","邮箱格式正确");
			}
			return true;
		}
		//校验结果
		function show_vaildate_msg(ele,status,msg){
			//清除当前元素的校验状态
			$(ele).parent().removeClass("has-success has-error");
			$(ele).next("span").text("");
			if("success" == status){
				$(ele).parent().addClass("has-success");
				$(ele).next("span").text(msg);
			}else if("error" == status){
				$(ele).parent().addClass("has-error");
				$(ele).next("span").text(msg);
			}
		}
		
		
		//修改
		//1.我们是按钮创建之前就绑定了click，所以绑定失败
			//.live()为后来的也能绑定，新版本没有了，用on进行替代
		$(document).on("click",".edit_btn",function(){
			//alert("edit");
			
			//1.查出部门信息，并显示部门列表
			//点击更新按钮弹出模态框
			getDepts("#empUpdateModal select");
			//2.查出员工信息，并显示员工信息
			getEmp($(this).attr("edit-id"));
			//3.把员工id传给更新模态框
			$("#emp_update_btn").attr("edit-id",$(this).attr("edit-id"));
			$("#empUpdateModal").modal({
				backdrop:"static"
			});
			
		});
		
		//查询员工信息
		function getEmp(id){
			$.ajax({
				url:"${APP_PATH}/emp/"+id,
				type:"GET",
				success:function(result){
					var empData = result.extend.emp;
					$("#empName_update_static").text(empData.empName);
					$("#email_update_input").val(empData.email);
					$("#empUpdateModal input[name=gender]").val([empData.gender]);
					$("#empUpdateModal select").val([empData.dId]);
				}
			});
		}
		
		
		//点击更新，更新员工信息
		$("#emp_update_btn").click(function(){
			//1.验证邮箱是否合法
			var email = $("#email_update_input").val();
			var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			if(!regEmail.test(email)){
				//alert("邮箱格式不正确");
				show_vaildate_msg("#email_update_input","error","邮箱格式不正确");
				return false;
			}else{
				show_vaildate_msg("#email_update_input","success","邮箱格式正确");
			}
			//2.发送Ajax请求保存更新的员工信息
			$.ajax({
				url:"${APP_PATH}/emp/"+$(this).attr("edit-id"),
				type:"PUT",
				data:$("#empUpdateModal form").serialize(),
				success:function(result){
					//alert(result.msg);
					//员工更新成功后
					//1.关闭动态框
					$('#empUpdateModal').modal('hide');
					//2.回到本页面
					to_page(currentPage);
				}
			});
			
			

			/* //2.发送Ajax请求保存更新的员工信息
			$.ajax({
				url:"${APP_PATH}/emp/"+$(this).attr("edit-id"),
				type:"POST",
				data:$("#empUpdateModal form").serialize()+"&_method=PUT",
				success:function(result){
					//alert(result.msg);
					//员工更新成功后
					//1.关闭动态框
					$('#empUpdateModal').modal('hide');
					
				}
			}); */
			
			
		});
		//删除
		$(document).on("click",".delete_btn",function(){
			//1.弹出是否确认删除对话框
			var empName = $(this).parents("tr").find("td:eq(2)").text();
			if(confirm("确认删除【"+empName+"】吗？"));{
				$.ajax({
					url:"${APP_PATH}/emp/"+$(this).attr("delete-id"),
					type:"DELETE",
					success:function(result){
						alert(result.msg);
						//回到本页面
						to_page(currentPage);
					}
				});
			}
			
		});
		
		//全选/全不选
		$("#check_all").click(function(){
			//原生dom属性prop修改和获取，sttr设置和获取自定义属性的值
			$(".check_item").prop("checked",$(this).prop("checked"));
		});
		
		$(document).on("click",".check_item",function(){
			var flag = $(".check_item:checked").length==$(".check_item").length;
			$("#check_all").prop("checked",flag);
		});
		
		//全部删除emp_delete_all_btn
		$("#emp_delete_all_btn").click(function(){
			var del_idstr = "";
			var empNames = "";
			$.each($(".check_item:checked"),function(){
				empNames += $(this).parents("tr").find("td:eq(2)").text()+",";
				del_idstr += $(this).parents("tr").find("td:eq(1)").text()+"-";
			});
			//取出empNames最后多余的逗号
			empNames = empNames.substring(0, empNames.length-1);
			del_idstr = del_idstr.substring(0, del_idstr.length-1);
			if(confirm("确认删除【"+empNames+"】吗？"));{
				$.ajax({
					url:"${APP_PATH}/emp/"+del_idstr,
					type:"DELETE",
					success:function(result){
						alert(result.msg);
						//回到本页面
						to_page(currentPage);
						$("#check_all").prop("checked",false);
					}
				});
			}
		});
		
	</script>
	


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表显示页面</title>

<!-- 引入jquery资源 -->
<script type="text/javascript" 
	src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
	
</head>

<script type="text/javascript">

	function userDelete(id){
		var isconfirm=window.confirm("您确定要删除吗?");
		if(isconfirm){
			//这是get方式提交的数据
			window.loaction.href="${pageContext.request.contextPath}/user/userDelete.action?id="+id;
		}
	}
	
	
	/* function testBtn(){
		
		window.loaction.href="${pageContext.request.contextPath}/user/testStringIds.action";		
	} */

	
	$(function(){
		// 全选按钮注册点击事件
		$("#checkAllBtn").click(function(){
			$("input[name='ids']").attr("checked","checked");
		});
		
		// 全不选按钮注册点击事件
		$("#checkNoAllBtn").click(function(){
			$("input[name='ids']").removeAttr("checked");
		});
		
		// 反选按钮注册点击事件(这是一个显示按钮)
		$("#checkReverseBtn").click(function(){
			$("input[name='ids']").each(function(){
				if($(this).attr("checked")){
					$(this).removeAttr("checked");
				}else{
					$(this).attr("checked","checked");
				}
			});
		});
		
		
		// 对全选checkbox 添加点击事件
		$("#checkAllBox").click(function(){
			// 判断全选checkbox是否选中
			if($("#checkAllBox").attr("checked")){
				// 选中 -- 全选
				$("input[name='ids']").attr("checked","checked");
			}else{
				// 没有选中 -- 全不选
				$("input[name='ids']").removeAttr("checked");
			}
		});
	});
	


</script>
<body>

<!-- 测试代码 -->

<form action="testStringIds.action" id="myform1" method="post" >
	<table align="center" style="color: red" border="1">
	<tr>
		<td>
			<c:forEach begin="1" end="5" var="i">
				<input type="checkbox" name="testids" id="testids" value="${i}">
					${i}&nbsp;
			</c:forEach>
		</td>
	</tr>
		<tr>
			<td>
				<input type="submit" style="color: red" value="字符串测试" />
			</td>
		</tr>
	</table>
</form>

<!-- 引入外部页面 -->
<c:import url="userFindByConditions.jsp"/>

<form action="userDelete.action" method="post">
	<table border="1" width="60%" align="center">
	<tr>
	<td colspan="6" width="40%" align="left">&nbsp;
		<input type="submit" onclick="return window.confirm('确定要删除这些吗?')" value="批量删除" />
		<a href="userAdd.action" style="border: 1;color: red">添加用户</a>&nbsp;
		<a href="userAddMany.action" style="border: 1;color: red">批量添加用户</a>
	</td>
	</tr>
		<tr>
			<td width="20%">
				<a style="cursor: pointer;" id="checkAllBtn" >全选</a>/
				<a style="cursor: pointer;" id="checkNoAllBtn" >全不选</a>/
				<a style="cursor: pointer;" id="checkReverseBtn">反选</a>
			</td>
			<th>ID</th>
			<th>姓名</th>
			<th>昵称</th>
			<th width="25%">邮箱</th>
			<th width="25%">其他操作</th>
		</tr>
		<c:forEach items="${userList}" var="user">
			<tr>
			<td>
			<input type="checkbox" name="ids" id="ids" value="${user.id}">
			</td>
				<td>${user.id}</td>
				<td>
				<a href="userShow.action?id=${user.id}">${user.username}</a></td>
				<td>${user.nickname}</td>
				<td>${user.email}</td>
				<td>
				<a href="userDelete.action?id=${user.id}" onclick='return window.confirm("您确定要删除吗")'>删除</a>
				<a href="userAdd.action?id=${user.id}">修改</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</form>


</body>
</html>
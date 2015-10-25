<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户页面</title>
</head>
<body>
<!-- 
	<form  action="${pageContext.request.contextPath}/user/userAdd.action" method="post">
 -->
 <!-- 这里的modelAttribute指的是那个被验证的对象的名称,是在userAdd方法中定义的那个属性 -->
	<form:form  modelAttribute="user" method="post">
	
	<!-- 修改用户信息 -->
		<c:if test="${user} ==null">
		添加用户:
		</c:if>
		<table border="1" width="40%" align="center">
			<tr>
				<td>姓名</td>
				<td><input type="text" name="username" value="${user.username}">
				<form:errors path="username"/>
				</td>
			</tr>
			<tr>
				<td>密码</td>
				<td>
					<input type="text" name="password"  value="${user.password}"/>
				<form:errors path="password"/>
				</td>
			</tr>
			<tr>
				<td>昵称</td>
				<td><input type="text" name="nickname" value="${user.nickname}">
				<form:errors path="nickname"/>
				</td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input type="text" name="email" value="${user.email}">
				<form:errors path="email"/>
				</td>
			</tr>
			<tr>
				<td>生日(格式为:yyyy-MM-dd)</td>
				<td>
				<input type="text" name="birthday" value="${user.birthday}">
				<form:errors path="birthday"/>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="提交">
					<a href="javascript:history.go(-1);">返回</a>
				</td>
			</tr>
		</table>
		<%-- <c:if test="${user} ==null">
		添加用户:
		</c:if>
		<table border="1" width="40%" align="center">
			<tr>
				<td>ID</td>
				<td><form:input  path="id"/>
				<form:errors path="id"/>
				</td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><form:input  path="username"/>
				<form:errors path="username"/>
				</td>
			</tr>
			<tr>
				<td>密码</td>
				<td>
					<form:password  path="password" />
				<form:errors path="password"/>
				</td>
			</tr>
			<tr>
				<td>昵称</td>
				<td><form:input  path="nickname"/>
				<form:errors path="nickname"/>
				</td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><form:input  path="email"></form:input>
				<form:errors path="email"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="提交">
					<a href="javascript:history.go(-1);">返回</a>
				</td>
			</tr>
		</table> --%>
		
	</form:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>条件查询用户信息页面</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/user/userFindByConditions.action" method="post">
		<table border="1" width="60%" align="center">
			<tr>
				<td>姓名</td>
				<td><input type="text" name="username" value="${user.username}">
				</td>
				<td>用户ID</td>
				<td><input type="text" name="id" value="${user.id}" /></td>
			</tr>
			<tr>
				<td>昵称</td>
				<td><input type="text" name="nickname" value="${user.nickname}">
				</td>
				<td>邮箱</td>
				<td><input type="text" name="email" value="${user.email}">
				</td>
			</tr>
			<tr>
				<td colspan="4" rowspan="1" align="center">
					<input type="submit" value="条件查询"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
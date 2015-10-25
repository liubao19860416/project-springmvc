<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示用户信息页面</title>
</head>
<body>
	<!-- 显示用户信息 -->
		<table border="1" width="40%" align="center">
			<tr>
				<td>姓名</td>
				<td><input type="text" name="username" readonly="readonly" value="${user.username}">
				</td>
			</tr>
			<tr>
				<td>ID</td>
				<td>
					<input type="text" name="id" readonly="readonly" value="${user.id}" />
				</td>
			</tr>
			<tr>
				<td>昵称</td>
				<td><input type="text" name="nickname" readonly="readonly" value="${user.nickname}">
				</td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input type="text" name="email" readonly="readonly" value="${user.email}">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<a href="javascript:history.go(-1);">返回</a>
				</td>
			</tr>
		</table>
</body>
</html>
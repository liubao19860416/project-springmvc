<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>批量添加用户页面</title>
</head>
<body>
<!-- 
	<form  action="${pageContext.request.contextPath}/user/userAdd.action" method="post">
 -->
 <!-- 这里的modelAttribute指的是那个被验证的对象的名称,是在userAdd方法中定义的那个属性  modelAttribute="userList"-->
 <!-- 这里的action可以不用写 -->
	<form:form action="userAddMany.action"  modelAttribute="userList"  method="post">
	<div align="center" style="color: red"><form:errors path="*"/></div>
	
	<c:forEach begin="0" end="1" step="1"  var="user" varStatus="st">
		<!-- 显示5个用户录入框 -->
		<table border="1" width="80%" align="center" style="color: green">
			<tr>
				<td rowspan="2" width="15%">
					第  ${st.index+1} 个用户${st.count}:${user}:${userList==null}
					<c:out value='${i}'/>
				</td>
				<td>姓名</td>
				<td><input type="text" name="userList[<c:out value='${st.count-1}'/>].username"  />
				</td>
				<td>密码</td>
				<td>
					<input type="text" name="userList[<c:out value='${st.index}'/>].password"  />
					<!-- 
						<form:errors path="userList[0].password"/>
					 -->
				</td>
			</tr>
			<tr>
				<td>昵称</td>
				<td><input type="text" name="userList[<c:out value='${st.index}'/>].nickname"/>
				</td>
				<td>邮箱</td>
				<td><input type="text" name="userList[<c:out value='${st.index}'/>].email" />
				</td>
			</tr>
			</table>
		</c:forEach>
			
			<table border="1" width="80%" align="center" style="color: red">
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="批量添加用户">
					<a href="javascript:history.go(-1);">返回上一步</a>
				</td>
			</tr>
		</table>
	</form:form>
	
</body>
</html>
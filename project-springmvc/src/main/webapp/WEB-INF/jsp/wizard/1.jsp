<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
<title>1.jsp</title>
</head>

<body>
	<form action="${pageContext.request.contextPath}/mywizardform.action"
		method="post">
		id:<input type="text" name="pid" value="${requestScope.person.pid }"><br>
		生日:<input type="text" name="birthday" ><br>
		<input type="submit" name="_cancel" value="取消"> <input
			type="submit" name="_target1" value="下一步">
	</form>
</body>
</html>

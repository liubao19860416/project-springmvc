<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>this is formView.jsp</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/myform.action" method="post">
姓名:<input type="text" name="name" ><br>
学号:<input type="text" name="pid" ><br>
地址:<input type="text" name="addr" ><br>
生日:<input type="text" name="birthday" ><br>
<input type="submit" value="提交"><br>
</form>

</body>
</html>
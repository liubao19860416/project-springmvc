<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <title>2.jsp</title>
  </head>
  
  <body>
    <form action="<%=path %>/mywizardform.action" method="post">
    	name:<input type="text" name="name" value="${requestScope.person.name }"><br>
    	<input type="submit" name="_target0" value="上一步">
    	<input type="submit" name="_cancel" value="取消">
    	<input type="submit" name="_target2" value="下一步">
    </form>
  </body>
</html>

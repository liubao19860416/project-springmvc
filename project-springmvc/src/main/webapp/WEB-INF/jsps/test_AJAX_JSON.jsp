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

//加载完页面后初始化调用
	$(function(){
		
		
		
	});

		//请求json格式对象,响应json格式对象
	function requestJSON(){
			//构造json格式对象
		var userstring =JSON.stringify({username:"requestJSON_LIUBAO",password:123,birthday:'1990-03-06'});
		
		//请求{key:value}格式字符串,响应json对象格式字符串
		$.ajax({
			type:'post',
			url:'requestJSON.action',
			contentType:'application/json;charset=utf-8',
			data:userstring,
			success:function(data){
				alert(data+":"+data.username);
			}
	});
	
	}
		
		//请求key:value格式字符串,响应json格式对象
	function responseJSON(){
			//alert("responseJSON");
		///var userstring =JSON.stringify({username:"LIUBAO",password:123,birthday:'1990-03-06'});
		
		//请求{key:value}格式字符串,响应json对象格式字符串
		$.ajax({
			type:'get',//get/post好像都可以;
			url:'responseJSON.action?username=responseJSON_liubao&password=123',
			//contentType:'application/x-www-form-urlencoded',
			contentType:'application/json;charset=utf-8',//都可以???
			data:null,
			success:function(data){
				alert(data+":"+data.username);
			}
	});
	}
	
	//请求无参数或单个参数{key:value},接受list对象列表
	//扩展:可以显示根据姓名查询列表,或者直接加载指定列表等多种方式
	function responseJSONList(){
		//请求{key:value}格式字符串,响应json对象格式字符串
		$.ajax({
			type:'post',//get好像都可以;
			url:'responseJSONList.action',
			contentType:'application/x-www-form-urlencoded',//可以不设置
			data:null,
			success:function(data){
				alert(data+":"+data[0].username);
			}
	});
	}
		
</script>

<body>

<!-- 测试代码 -->

<form action="testStringIds.action" id="myform1" method="post" >
	<table align="center" style="color: red" border="1">
		<tr>
			<td>
				<input type="button" onclick="requestJSON();" style="color: red" value="requestJSON字符串测试" />
			</td>
			<td>
				<input type="button" onclick="responseJSON()" style="color: red" value="responseJSON字符串测试" />
			</td>
			<td>
				<input type="button" onclick="responseJSONList()" style="color: red" value="responseJSONList字符串测试" />
			</td>
		</tr>
	</table>
</form>

</body>
</html>
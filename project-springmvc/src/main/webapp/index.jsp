<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<H1>默认访问主页面！！！</H1>
	<HR />
	<form id="myUpload" name="myUpload" action="${pageContext.request.contextPath}/myUpload/0.action" method="post" enctype="multipart/form-data">
		<table border="0" cellspacing="0" cellpadding="0" width="100%" bgcolor="#c4d8ed">
			<tbody>
				<tr>
					<td>
						<table class="toptable grid" border="1" cellspacing="1" cellpadding="4" align="center">
							<tbody>
								<tr>
									<td height="30" align="right">选择导入文件</td>
									<td class=category><input type="file" name="multiFile" />
									</td>
								</tr>
								<tr>
									<td colspan="2" align="center" class="category">
										<input type="submit" value="单个文件导入" /> 
									</td>
								</tr>
								<tr>
									<td colspan="2" align="center" class="category">
									</td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	<HR />
	FLASH文件显示1：<br/>
	<a href="http://www.allsmart.com/images/new1.swf"></a>
	<br/>FLASH文件显示2：<br/>
	<EMBED autoplay="true" autosize="true" autostart="true" pluginspage="http://www.macromedia.com/go/getflashplayer" src="http://www.allsmart.com/images/new1.swf" width="895" height="295" type="application/x-shockwave-flash" wmode="transparent" quality="high"></EMBED>
	<br/>FLASH文件显示3：<br/>
	<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
   id="flex" width="100%" height="100%"
   codebase="http://fpdownload.macromedia.com/get/flashplayer/current/swflash.cab">
   <param name="movie" value="http://www.allsmart.com/images/new1.swf"/>
   <param name="quality" value="high" />
   <param name="bgcolor" value="#869ca7" />
   <param name="allowScriptAccess" value="sameDomain" />
   <embed src="http://www.allsmart.com/images/new1.swf"  quality="high" bgcolor="#869ca7"
    width="100%" height="100%" name="flex" align="middle"
    play="true" loop="true" quality="high" allowScriptAccess="sameDomain"
    type="application/x-shockwave-flash" pluginspage="http://www.adobe.com/go/getflashplayer">
    </embed>
 	</object>
	
	<HR />
	<form id="myUpload" name="myUpload" action="${pageContext.request.contextPath}/myUpload/1.action" method="post" enctype="multipart/form-data">
		<table border="0" cellspacing="0" cellpadding="0" width="100%" bgcolor="#c4d8ed">
			<tbody>
				<tr>
					<td>
						<table class="toptable grid" border="1" cellspacing="1" cellpadding="4" align="center">
							<tbody>
								<tr>
									<td height="30" align="right">选择导入文件</td>
									<td class=category><input type="file" name="multiFile" />
									</td>
								</tr>
								<tr>
									<td height="30" align="right">选择导入文件</td>
									<td class=category><input type="file" name="multiFile" />
									</td>
								</tr>
								<tr>
									<td colspan="2" align="center" class="category">
									<input type="submit" value="多个文件导入" /></td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	
	<HR />

</body>
</html>
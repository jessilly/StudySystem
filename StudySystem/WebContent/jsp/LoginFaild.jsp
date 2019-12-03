<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<link type="text/css" rel="stylesheet" href="${basepath}/jsp/css/page_base.css"/>
	<link type="text/css" rel="stylesheet" href="${basepath}/jsp/css/stuInfoPro.css"/>
	<link type="text/css" rel="stylesheet" href="${basepath}/jsp/css/stuInfoAddUp.css"/>
	<title>学生信息添加</title>
</head>
<body>
	<div id="header_bar">课&nbsp;程&nbsp;管&nbsp;理&nbsp;系&nbsp;统</div>
		<%
			response.setHeader("refresh","3;"+basepath+"/jsp/LoginPage.jsp");  
		%>
		<div  style="text-align: center">
				<br><br><br><br><br><br><br><br>
				<span>用户名或密码错误，3秒后返回登录页面</span>
						
		</div>
		<div style="clear:both;"></div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="UTF-8">
        <link type="text/css" rel="stylesheet" href="${basepath}/jsp/css/style.css"/>
        <script type="text/javascript" src="<%=basepath%>/jsp/js/jquery-1.8.3.js"></script>
        <script type="text/javascript" src="<%=basepath%>/jsp/js/MainPage.js"></script>
        <title>信息维护</title>
    </head>
    <body>
        <div id="header_bar">信&nbsp;息&nbsp;维&nbsp;护</div>
        <div id="content">
            <jsp:include page="banner.jsp"/>
            <div style="clear:both;"></div>
        </div>
    </body>
</html>
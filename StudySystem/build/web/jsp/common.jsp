<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="com.hbnu.study.bean.Student"%>
    
	<%
		String basepath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
		
		request.setAttribute("basepath", basepath); 
		
			
	%>

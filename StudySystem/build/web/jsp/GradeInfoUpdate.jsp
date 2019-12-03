<%-- 
    Document   : GradeInfoUpdate
    Created on : 2018-12-19, 20:16:18
    Author     : Administrator
--%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<link type="text/css" rel="stylesheet" href="<%=basepath %>/jsp/css/page_base.css"/>
	<link type="text/css" rel="stylesheet" href="<%=basepath %>/jsp/css/stuInfoPro.css"/>
	<link type="text/css" rel="stylesheet" href="<%=basepath %>/jsp/css/stuInfoAddUp.css"/>
	<script type="text/javascript" src="<%=basepath %>/jsp/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="<%=basepath %>/jsp/js/StudentInfoUpdate.js"></script>
	<title>班级信息修改</title>
</head>
<body>
	
	<input type="hidden" name="gradeName" value="${gra.gradeName}"/>
	<input type="hidden" name="subject" value="${gra.subject}"/>
	<input type="hidden" name="amount" value="${gra.amount}"/>
	<div id="header_bar">班&nbsp;级&nbsp;信&nbsp;息&nbsp;修&nbsp;改</div>
	<div id="content">
<!--		<div id="content_left">
			<div class="block_link">
				
				<a class="a_link" href="${basepath}/student/getStudent" >学生信息维护</a>
			</div>
			<div class="block_link"><a class="a_link" href="${basepath}/teacher/getTeacher">教师信息维护</a></div>
			<div class="block_link"><a class="a_link" href="${basepath}/subject/getSubject">院系信息维护</a></div>
			<div class="block_link"  style="background:rgba(0,191,255,0.2);border:2px dashed white;color:white;"><a class="a_link" href="${basepath}/grade/getGrade">班级信息维护</a></div>
			
			<div class="block_link"><a class="a_link" href="${basepath}/course/getCourse">课程信息维护</a></div>
			<div class="block_link"><a class="a_link" href="${basepath}/elective/getElective">选课信息维护</a></div>
                        <div class="block_link"><a class="a_link" href="${basepath}/score/getScore">成绩信息维护</a></div>
		</div>-->
 <jsp:include page="banner.jsp"/>
		<div id="content_right">
			<form id="addForm" method="post" action="${basepath}/grade/updateGra">
				<input type="hidden" name="id" value="${gra.id}"/>
                                <div id="addAllRows">
<!--					<div class="addRow">
						<span class="addSpan">所&nbsp;属&nbsp;院&nbsp;系：</span>
						<select class="addInput1" id="suoshuyuanxi" name="subject">
							<option value="计算机科学与技术学院">计算机科学与技术学院</option>
							<option value="生科院">生科院</option>
							<option value="音乐学院">音乐学院</option>
							<option value="体育学院">体育学院</option>
							<option value="美术学院">美术学院</option>
						</select>
					</div>
					<div class="addRow">
						<span class="addSpan">所&nbsp;在&nbsp;班&nbsp;级：</span>
						<select class="addInput1" id="suoshubanji" name="gradeName">
							<option value="1601班">1601班</option>
							<option value="1602班">1602班</option>
							<option value="1603班">1603班</option>
							<option value="1604班">1604班</option>
							<option value="1605班">1605班</option>
							<option value="1606班">1606班</option>
							<option value="1607班">1607班</option>
							<option value="1608班">1608班</option>
						
						</select>
					</div>-->
				<div id="addAllRows">
									
					<div class="addRow">
						<span class="addSpan">班&nbsp;&nbsp;&nbsp;&nbsp;号：</span>
						<input class="addInput2" type="text" name="gradeName" value="${gra.gradeName}"/>
					</div>
					<div class="addRow">
						<span class="addSpan">所&nbsp;属&nbsp;院&nbsp;系&nbsp;：</span>
						<input class="addInput2" type="text" name="subject" value="${gra.subject}"/>
					</div>
                                        <div class="addRow">
						<span class="addSpan">人&nbsp;&nbsp;&nbsp;&nbsp;数：</span>
						<input class="addInput2" type="text" name="amount" value="${gra.amount}"/>
					</div>
					
					<div id="infoAddButton">
						<input name="login" type="submit" value="修改" style="width: 60px;height: 30px;font-size: 18px;" align="center">
	        			<input name="reset" type="button" value="重置" style="width: 60px;height: 30px;font-size: 18px;" align="center">
						
					</div>
				</div>
			</form>
		</div>
		<div style="clear:both;"></div>
	</div>
</body>
</html>

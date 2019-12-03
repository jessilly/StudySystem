<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<link type="text/css" rel="stylesheet" href="<%=basepath %>/jsp/css/page_base.css"/>
	<link type="text/css" rel="stylesheet" href="<%=basepath %>/jsp/css/stuInfoPro.css"/>
	<link type="text/css" rel="stylesheet" href="<%=basepath %>/jsp/css/stuInfoAddUp.css"/>
	<script type="text/javascript" src="<%=basepath %>/jsp/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="<%=basepath %>/jsp/js/ClassInfoUpdate.js"></script>
	<title>课程信息修改</title>
</head>
<body>
<input type="hidden" name="courseType" value="${course.courseType}"/>
	<div id="header_bar">课&nbsp;程&nbsp;信&nbsp;息&nbsp;修&nbsp;改</div>
	<div id="content">
<!--		<div id="content_left">
			<div class="block_link">
				
				<a class="a_link" href="${basepath}/student/getStudent" >学生信息维护</a>
			</div>
			<div class="block_link"><a class="a_link" href="${basepath}/teacher/getTeacher">教师信息维护</a></div>
			<div class="block_link"><a class="a_link" href="${basepath}/subject/getSubject">院系信息维护</a></div>
			<div class="block_link"><a class="a_link" href="${basepath}/grade/getGrade">班级信息维护</a></div>
			
			<div class="block_link"  style="background:rgba(0,191,255,0.2);border:2px dashed white;color:white;"><a class="a_link" href="${basepath}/course/getCourse">课程信息维护</a></div>
			<div class="block_link"><a class="a_link" href="${basepath}/elective/getElective">选课信息维护</a></div>
                        <div class="block_link"><a class="a_link" href="${basepath}/score/getScore">成绩信息维护</a></div>
		</div>-->
 <jsp:include page="banner.jsp"/>
		<div id="content_right" style="text-align: center">
			<form id="updateForm" action="${basepath}/course/update" method="post">
				<input type="hidden" name="id" value="${course.id} "/>
				<div id="addAllRows">
					<div class="addRow">
						<span class="addSpan">课程编号：</span>
						<input class="addInput2" id="classId_add" type="text" name="courseNo" value="${course.courseNo} "/>
					</div>
					<div class="addRow">
						<span class="addSpan">课程名称：</span>
						<input class="addInput2" id="className_add" type="text" name="courseName" value="${course.courseName} "/>
					</div>
					<div class="addRow">
						<span class="addSpan">学&nbsp;&nbsp;&nbsp;&nbsp;分：</span>
						<input class="addInput2" id="classGrade_add" type="text" name="credit" value="${course.credit} "/>
					</div>
					<div class="addRow">
						<span class="addSpan">学&nbsp;&nbsp;&nbsp;&nbsp;时：</span>
						<input class="addInput2" id="classTime_add" type="text" name="courseHour" value="${course.courseHour} "/>
					</div>
					<div class="addRow">
						<span class="addSpan">课&nbsp;程&nbsp;类&nbsp;别：</span>
						<select class="addInput1" id="classKinds_add" name="courseType">
							<option value="专业选修">专业选修</option>
							<option value="专业必修">专业必修</option>
							<option value="公选">公选</option>
						</select>
					</div>
					<div id="infoAddButton">
						<span ><input id="right_button" class="add_button" style="line-height:10px;background:rgba(255,140,0,0.2); height:30px;font-size: 14px;" type="submit" value="修&nbsp;改"></span>
						<span ><input id="right_button" class="add_button" style="line-height:10px;background:rgba(255,140,0,0.2); height:30px;font-size: 14px;" type="button" value="重&nbsp;置"></span>
					</div>
				</div>
			</form>
		</div>
		<div style="clear:both;"></div>
	</div>
</body>
</html>
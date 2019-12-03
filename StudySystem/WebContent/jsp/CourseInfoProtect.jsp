<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="UTF-8">
        <link type="text/css" rel="stylesheet" href="<%=basepath%>/jsp/css/page_base.css"/>
        <link type="text/css" rel="stylesheet" href="<%=basepath%>/jsp/css/stuInfoPro.css"/>
        <link type="text/css" rel="stylesheet" href="<%=basepath%>/jsp/css/classAdd.css"/>
        <script type="text/javascript" src="<%=basepath%>/jsp/js/jquery-1.8.3.js"></script>
<!--  <script type="text/javascript" src="<%=basepath%>/jsp/js/StudentInfoProtect.js"></script>-->
        <script type="text/javascript" src="<%=basepath%>/jsp/js/ClassInfoUpdate.js"></script>

        <title>课程信息维护</title>
    </head>
    <body>
        <div id="header_bar">课&nbsp;程&nbsp;信&nbsp;息&nbsp;维&nbsp;护</div>
        <div id="content">
            <!--            <div id="content_left">
                            <div class="block_link">
            
                                <a class="a_link" href="${basepath}/student/getStudent" >学生信息维护</a>
                            </div>
                            <div class="block_link"><a class="a_link" href="${basepath}/teacher/getTeacher">教师信息维护</a></div>
                            <div class="block_link"><a class="a_link" href="${basepath}/subject/getSubject">院系信息维护</a></div>
                            <div class="block_link"><a class="a_link" href="${basepath}/grade/getGrade">班级信息维护</a></div>
            
                            <div class="block_link" style="background:rgba(0,191,255,0.2);border:2px dashed white;color:white;"><a class="a_link" href="${basepath}/course/getCourse">课程信息维护</a></div>
                            <div class="block_link"><a class="a_link" href="${basepath}/elective/getElective">选课信息维护</a></div>
                            <div class="block_link"><a class="a_link" href="${basepath}/score/getScore">成绩信息维护</a></div>
                        </div>-->
            <jsp:include page="banner.jsp"/>
            <form id="findStudent" action="${basepath}/course/findCourse" method="post">
                <div id="content_right">
                    <div id="stuInfo">
                        <span id="span_yuanxi">课程类别：
                            <select class="select_student" id="yuanxi" name="courseType">
                                <option value="">请选择------</option>
                                <option value="专业选修">专业选修</option>
                                <option value="专业必修">专业必修</option>
                                <option value="公选">公选</option>                             
                            </select>
                        </span>                       
                        <button id="search_button1" type="submit">搜&nbsp;索</button>
                        <!--basepath为绝对路径  common-->
                        <span id="search_button"><a href="${basepath}/jsp/CourseInfoAdd.jsp">添&nbsp;加</a></span>
                        </form>
                        <div id="stuInfoTable">
                            <table id="stuTableContent">
                                <tr id="tr_head">
                                    <td class="class_col1">课程编号</td>
                                    <td class="class_col2">课程名称</td>
                                    <td class="class_col3">学分</td>
                                    <td class="class_col4">学时</td>
                                    <td class="class_col5">课程类别</td>
                                    <td class="class_col6">操作</td>
                                </tr>

                                <c:forEach items="${courses}" var="course"><!--  -->
                                    <tr>
                                        <td class="class_col1" id="classId">${course.courseNo}</td>
                                        <td class="class_col2" id="className">${course.courseName}</td>
                                        <td class="class_col3" id="classGrade">${course.credit}</td>
                                        <td class="class_col4" id="classTime">${course.courseHour}</td>
                                        <td class="class_col5" id="classKinds">${course.courseType}</td>
                                        <td class="class_col6" id="classOption"><a href="${basepath}/course/getCourseById?id=${course.id}" class="option">修改</a>&nbsp;|&nbsp;
                                            <a class="option" href="${basepath}/course/delete?id=${course.id}">删除</a></td>
                                    </tr>
                                </c:forEach>

                            </table>
                        </div>
                    </div>
                    <div style="clear:both;"></div>
                </div>
                </body>
                </html>
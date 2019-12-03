<%-- 
    Document   : TeacherInfoUpdate
    Created on : 2018-12-17, 19:41:37
    Author     : ls
--%>

<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="UTF-8">
        <link type="text/css" rel="stylesheet" href="<%=basepath%>/jsp/css/page_base.css"/>
        <link type="text/css" rel="stylesheet" href="<%=basepath%>/jsp/css/stuInfoPro.css"/>
        <link type="text/css" rel="stylesheet" href="<%=basepath%>/jsp/css/stuInfoAddUp.css"/>
        <script type="text/javascript" src="<%=basepath%>/jsp/js/jquery-1.8.3.js"></script>
        <script type="text/javascript" src="<%=basepath%>/jsp/js/StudentInfoUpdate.js"></script>
        <title>教师信息修改</title>
    </head>
    <body>

        <input type="hidden" name="subject" value="${stu.subject}"/>
        <input type="hidden" name="stuClass" value="${stu.stuClass}"/>
        <input type="hidden" name="sex" value="${stu.sex}"/>
        <div id="header_bar">教&nbsp;师&nbsp;信&nbsp;息&nbsp;修&nbsp;改</div>
        <div id="content">
            <!--            <div id="content_left">
                            <div class="block_link">
            
                                <a class="a_link" href="${basepath}/student/getStudent" >学生信息维护</a>
                            </div>
                            <div class="block_link"  style="background:rgba(0,191,255,0.2);border:2px dashed white;color:white;"><a class="a_link" href="${basepath}/teacher/getTeacher">教师信息维护</a></div>
                            <div class="block_link"><a class="a_link" href="${basepath}/subject/getSubject">院系信息维护</a></div>
                            <div class="block_link"><a class="a_link" href="${basepath}/grade/getGrade">班级信息维护</a></div>
            
                            <div class="block_link"><a class="a_link" href="${basepath}/course/getCourse">课程信息维护</a></div>
                            <div class="block_link"><a class="a_link" href="${basepath}/elective/getElective">选课信息维护</a></div>
                            <div class="block_link"><a class="a_link" href="${basepath}/score/getScore">成绩信息维护</a></div>
                        </div>-->
            <jsp:include page="banner.jsp"/>
            <div id="content_right">
                <form id="addForm" method="post" action="${basepath}/teacher/updateTea">
                    <input type="hidden" name="id" value="${tea.id}"/>
                    <div id="addAllRows">                     
                        <div id="addAllRows">
                            <div id="addAllRows">                          
                                <div class="addRow">
                                    <span class="addSpan">编&nbsp;&nbsp;&nbsp;&nbsp;号：</span>
                                    <input class="addInput2" type="text" name="teacherNo" value="${tea.teacherNo}"/>
                                </div>
                                <div class="addRow">
                                    <span class="addSpan">姓&nbsp;&nbsp;&nbsp;&nbsp;名：</span>
                                    <input class="addInput2" type="text" name="teacherName" value="${tea.teacherName}"/>
                                </div>
                                <div class="addRow">
                                    <span class="addSpan">性&nbsp;&nbsp;&nbsp;&nbsp;别：</span>
                                    <span id="addStuSex">
                                        <label class="addSex" for="nan"><input class="" id="nan" name="sex" value="男" type="radio" checked/>&nbsp;&nbsp;&nbsp;男</label>
                                        <label class="addSex" for="nv"><input class="" id="nv" name="sex" value="女" type="radio"/>&nbsp;&nbsp;&nbsp;女</label>
                                    </span>
                                </div>
                                <div class="addRow">
                                    <span class="addSpan">所&nbsp;&nbsp;教&nbsp;&nbsp;科&nbsp;&nbsp;目:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>                    
                                    <select class="addInput2" id="yuanxi" name="type">
                                        <option value="">请选择------</option>                        
                                        <c:forEach items="${courses}" var="course">
                                            <option value="${course.courseName}">${course.courseName}</option>                                    
                                        </c:forEach>
                                    </select>
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

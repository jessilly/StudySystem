<%-- 
    Document   : ScoreInfoProtect
    Created on : 2018-12-28, 18:21:24
    Author     : ls
--%>

<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="UTF-8">
        <link type="text/css" rel="stylesheet" href="${basepath}/jsp/css/page_base.css"/>
        <link type="text/css" rel="stylesheet" href="${basepath}/jsp/css/stuInfoPro.css"/>
        <script type="text/javascript" src="<%=basepath%>/jsp/js/jquery-1.8.3.js"></script>
        <!--  <script type="text/javascript" src="<%=basepath%>/jsp/js/StudentInfoProtect.js"></script>-->
        <script type="text/javascript" src="<%=basepath%>/jsp/js/StudentInfoUpdate.js"></script>

        <title>成绩信息维护</title>
    </head>
    <body>
        <input type="hidden" name="basePath" value="${basepath}"/>
        <div id="header_bar">成&nbsp;绩&nbsp;信&nbsp;息&nbsp;维&nbsp;护</div>
        <div id="content">
            <!--            <div id="content_left">
                            <div class="block_link" style="background:rgba(0,191,255,0.2);border:2px dashed white;color:white;">
                                <a class="a_link" href="${basepath}/student/getStudent" >学生信息维护</a>
                            </div>
                            <div class="block_link"><a class="a_link" href="${basepath}/teacher/getTeacher">教师信息维护</a></div>
                            <div class="block_link"><a class="a_link" href="${basepath}/subject/getSubject">院系信息维护</a></div>
                            <div class="block_link"><a class="a_link" href="${basepath}/grade/getGrade">班级信息维护</a></div>
            
                            <div class="block_link"><a class="a_link" href="${basepath}/course/getCourse">课程信息维护</a></div>
                            <div class="block_link"><a class="a_link" href="${basepath}/elective/getElective">选课信息维护</a></div>
                            <div class="block_link"><a class="a_link" href="${basepath}/score/getScore">成绩信息维护</a></div>
                        </div>-->
            <jsp:include page="banner.jsp"/>          
            <div id="content_right">
                <div id="stuInfo"> 
                      <c:if test="${user.getRole().equals('教师')}">
                    <form id="findStudent" action="${basepath}/score/findScore" method="post">
                        <span>老师：
                            <select class="select_student" id="banji" name="teacherName">
                                <option value="">请选择——</option>
                                <c:forEach items="${teas}" var="tea">
                                    <option value="${tea.teacherName}">${tea.teacherName}</option>                                    
                                </c:forEach>                         
                            </select>
                        </span>
                        <button id="search_button1" type="submit">搜&nbsp;索</button>
                       </c:if>
                            <!--<span id="search_button"><a href="${basepath}/score/preAdd">添&nbsp;加</a></span>-->
                       
                    </form>
                </div>
                <div id="stuInfoTable">
                    <table id="stuTableContent">
                        <tr id="tr_head">
                            <td class="col1" >学&nbsp;号</td>
                            <td class="col2" >姓&nbsp;名</td>
                            <td class="col3" >班&nbsp;级</td>
                            <td class="col3" >性&nbsp;别</td>
                            <td class="col3" >课&nbsp;程&nbsp;号</td>
                            <td class="col3" >课&nbsp;程&nbsp;名</td>
                            <td class="col3" >分&nbsp;数</td>
                            <c:if test="${user.getRole().equals('教师') || user.getRole().equals('管理员')}">
                                <td class="col4" id="stuOption">操&nbsp;作</td>
                            </c:if>
                        </tr>
                        <c:forEach items="${scos}" var="sco">
                            <tr>
                                <td class="col1" >${sco.studentNo} </td>
                                <td class="col2" >${sco.studentName}</td>
                                <td class="col3" >${sco.stuClass}</td>
                                <td class="col3" >${sco.sex} </td>
                                <td class="col3" >${sco.courseNo}</td>
                                <td class="col3" >${sco.courseName}</td>
                                <td class="col3" >${sco.score} </td>
                                    <td class="col4" id="stuOption">
                                        <a href="${basepath}/score/getScoreById?id=${sco.id}" class="option" >修改</a>                                      
                                    </td>                    
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
            <div style="clear:both;"></div>
        </div>
    </body>
</html>

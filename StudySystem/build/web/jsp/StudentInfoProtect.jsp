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

        <title>学生信息维护</title>
    </head>
    <body>
        <input type="hidden" name="basePath" value="${basepath}"/>
        <div id="header_bar">学&nbsp;生&nbsp;信&nbsp;息&nbsp;维&nbsp;护</div>
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
            <form id="findStudent" action="${basepath}/student/findStudent" method="post">
                <div id="content_right">
                    <div id="stuInfo">
                        <span id="span_yuanxi">院系：
                            <select class="select_student" id="yuanxi" name="subject">
                                <option value="">请选择------</option>                        
                                <c:forEach items="${subs}" var="sub">
                                    <option value="${sub.subjectName}">${sub.subjectName}</option>                                    
                                </c:forEach>
                            </select>
                        </span>
                        <span>班级：
                            <select class="select_student" id="banji" name="stuClass">
                                <option value="">请选择---</option>                              
                                <c:forEach items="${gras}" var="gra">
                                    <option value="${gra}">${gra}</option>                                    
                                </c:forEach>
                            </select>
                        </span>
                        <button id="search_button1" type="submit">搜&nbsp;索</button>
                        <c:if test="${user.getRole().equals('管理员')}">
                            <span id="search_button"><a href="${basepath}/student/preAdd">添&nbsp;加</a></span>
                        </c:if>                   
                        </form>
                    </div>
                    <div id="stuInfoTable">
                        <table id="stuTableContent">
                            <tr id="tr_head">
                                <td class="col1" id="xuehao">学&nbsp;号</td>
                                <td class="col2" id="stuName">姓&nbsp;名</td>
                                <td class="col3" id="stuSex">性&nbsp;别</td>
                                <td class="col3" id="stuSex">所在院系</td>
                                <td class="col3" id="stuSex">所在班级</td>
                                <td class="col4" id="stuOption">操作</td>
                            </tr>

                            <c:forEach items="${stus}" var="stu"><!-- 根据items和stu进行循环 -->
                                <tr>
                                    <td class="col1" id="xuehao">${stu.studentNo} </td><!--数据集-->
                                    <td class="col2" id="stuName">${stu.studentName}</td>
                                    <td class="col3" id="stuSex">${stu.sex}</td>
                                    <td class="col3" id="stuSex">${stu.subject}</td>
                                    <td class="col3" id="stuSex">${stu.stuClass}</td>
                                    <td class="col4" id="stuOption">
                                        <!--带参数，指定某一个，当前行的id-->
                                        <c:if test="${user.getRole().equals('管理员')}">    
                                            <a href="${basepath}/student/getStuById?id=${stu.id}" class="option" >修改|&nbsp;</a>
                                            <a class="option" href="${basepath}/student/deleteStu?id=${stu.id}">删除</a>
                                        </c:if>
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
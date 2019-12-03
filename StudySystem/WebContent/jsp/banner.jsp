<%-- 
    Document   : banner
    Created on : 2019-1-2, 19:41:11
    Author     : ls
--%>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="content_left">

    <c:if test="${user.getRole().equals('学生')}">
        <div class="block_link" style="background:rgba(0,191,255,0.2);border:2px dashed white;color:white;">
            <a class="a_link" href="${basepath}/logout">退出登录</a>
        </div>
        <div class="block_link">
            <a class="a_link" href="${basepath}/student/getStudent">学生信息维护</a>
        </div>
        <div class="block_link">         
            <a class="a_link" href="${basepath}/elective/getElective">选课信息维护</a>          
        </div>
        <div class="block_link">
            <a class="a_link" href="${basepath}/score/getScore">成绩查询</a>
        </div>
    </c:if>

    <c:if test="${user.getRole().equals('教师')}">
        <div class="block_link" style="background:rgba(0,191,255,0.2);border:2px dashed white;color:white;">
            <a class="a_link" href="${basepath}/logout">退出登录</a>
        </div>
        <div class="block_link">
            <a class="a_link" href="${basepath}/teacher/getTeacher">教师信息维护</a>
        </div>
        <div class="block_link">
            <a class="a_link" href="${basepath}/score/getScore">成绩录入</a>                             
        </div>
    </c:if>

    <c:if test="${user.getRole().equals('管理员')}">
        <div class="block_link" style="background:rgba(0,191,255,0.2);border:2px dashed white;color:white;">
            <a class="a_link" href="${basepath}/logout">退出登录</a>
        </div>
        <div class="block_link">
            <a class="a_link" href="${basepath}/student/getStudent">学生信息维护</a>
        </div>
        <div class="block_link">
            <a class="a_link" href="${basepath}/teacher/getTeacher">教师信息维护</a>
        </div>
        <div class="block_link">
            <a class="a_link" href="${basepath}/subject/getSubject">院系信息维护</a>
        </div>
        <div class="block_link">
            <a class="a_link" href="${basepath}/grade/getGrade">班级信息维护</a>
        </div>
        <div class="block_link">
            <a class="a_link" href="${basepath}/course/getCourse">课程信息维护</a>
        </div>                             
    </c:if>
</div>
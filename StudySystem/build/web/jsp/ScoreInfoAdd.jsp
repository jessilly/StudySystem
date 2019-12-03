<%-- 
    Document   : ScoreInfoAdd
    Created on : 2018-12-28, 18:22:03
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
        <link type="text/css" rel="stylesheet" href="${basepath}/jsp/css/stuInfoAddUp.css"/>
        <title>成绩信息添加</title>
    </head>
    <body>
        <div id="header_bar">成&nbsp;绩&nbsp;信&nbsp;息&nbsp;添&nbsp;加</div>
        <div id="content">         
            <jsp:include page="banner.jsp"/>
            <div id="content_right">
                <form id="addForm" action="${basepath}/chengji/add" method="post">
                    <div id="addAllRows">
                        <div class="addRow">
                            <span class="addSpan">学&nbsp;&nbsp;&nbsp;&nbsp;号：</span>
                            <input class="addInput2" name="studentNo" type="text"/>
                        </div>

                        <div class="addRow">
                            <span class="addSpan">姓&nbsp;&nbsp;&nbsp;&nbsp;名：</span>
                            <input class="addInput2" name="studentName" type="text"/>
                        </div>

                        <div class="addRow">
                            <span class="addSpan">所&nbsp;在&nbsp;班&nbsp;级：</span>
                            <select class="addInput1" id="suoshubanji" name="stuClass">

                                <option  value="1601班">1601班</option>
                                <option  value="1602班">1602班</option>
                                <option  value="1603班">1603班</option>
                                <option  value="1604班">1604班</option>
                                <option  value="1605班">1605班</option>
                                <option  value="1606班">1606班</option>
                                <option  value="1607班">1607班</option>
                            </select>
                        </div>

                        <div class="addRow">
                            <span class="addSpan">性&nbsp;&nbsp;&nbsp;&nbsp;别：</span>
                            <span id="addStuSex">
                                <label class="addSex" for="nan"><input class="" id="nan" name="sex" value="男" type="radio"/>&nbsp;&nbsp;&nbsp;男</label>
                                <label class="addSex" for="nv"><input class="" id="nv" name="sex" value="女" type="radio"/>&nbsp;&nbsp;&nbsp;女</label>
                            </span>
                        </div>
                        <div class="addRow">
                            <span class="addSpan">课&nbsp;&nbsp;程&nbsp;&nbsp;号：</span>
                            <input class="addInput2" name="courseNo" type="text"/>
                        </div>

                        <div class="addRow">
                            <span class="addSpan">课&nbsp;&nbsp;程&nbsp;&nbsp;名：</span>
                            <select class="addInput1" id="suoshuyuanxi" name="courseName">
                                <c:forEach items="${courses}" var="course">
                                    <option value="${course.getCourseName()}">${course.getCourseName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="addRow">
                            <span class="addSpan">分&nbsp;&nbsp;&nbsp;&nbsp;数：</span>
                            <input class="addInput2" name="score" type="text"/>
                        </div>
                        <div id="infoAddButton">
                            <span ><input id="right_button" class="add_button" style="line-height:10px;background:rgba(255,140,0,0.2); height:30px;font-size: 14px;" type="submit" value="添&nbsp;加"></span>
                            <span ><input id="right_button" class="add_button" style="line-height:10px;background:rgba(255,140,0,0.2); height:30px;font-size: 14px;" type="button" value="重&nbsp;置"></span>
                        </div>
                    </div>
                </form>
            </div>
            <div style="clear:both;"></div>
        </div>
    </body>
</html>

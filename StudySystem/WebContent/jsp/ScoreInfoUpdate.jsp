<%-- 
    Document   : ScoreInfoUpdate
    Created on : 2018-12-28, 18:21:46
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
        <title>成绩信息修改</title>
    </head>
    <body>       
        <div id="header_bar">成&nbsp;绩&nbsp;信&nbsp;息&nbsp;修&nbsp;改</div>
        <div id="content">          
            <%--<jsp:include page="banner.jsp"/>--%>
            <div id="content_right">
                <form id="addForm" method="post" action="${basepath}/score/updateScore">
                    <input type="hidden" name="id" value="${scos.id}"/>
                    <div id="addAllRows">
                        <div class="addRow">
                            <span class="addSpan">学&nbsp;&nbsp;&nbsp;&nbsp;号：</span>
                            <input class="addInput2" type="text" name="studentNo" value="${scos.studentNo}"/>
                        </div>
                        <div class="addRow">
                            <span class="addSpan">姓&nbsp;&nbsp;&nbsp;&nbsp;名：</span>
                            <input class="addInput2" type="text" name="studentName" value="${scos.studentName}"/>
<!--                        </div>                       
                        <div class="addRow">
                            <span class="addSpan">课&nbsp;程&nbsp;名：</span>                          
                        </div>-->
                        <div class="addRow">
                            <span class="addSpan">分&nbsp;&nbsp;数：</span>
                            <input class="addInput2" type="text" name="score" value="${scos.score}"/>
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
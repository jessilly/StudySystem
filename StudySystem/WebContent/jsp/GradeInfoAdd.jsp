<%-- 
    Document   : GradeInfoAdd
    Created on : 2018-12-19, 20:16:38
    Author     : Administrator
--%>

<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="UTF-8">
        <link type="text/css" rel="stylesheet" href="${basepath}/jsp/css/page_base.css"/>
        <link type="text/css" rel="stylesheet" href="${basepath}/jsp/css/stuInfoPro.css"/>
        <link type="text/css" rel="stylesheet" href="${basepath}/jsp/css/stuInfoAddUp.css"/>
        <title>班级信息添加</title>
    </head>
    <body>
        <div id="header_bar">班&nbsp;级&nbsp;信&nbsp;息&nbsp;添&nbsp;加</div>
        <div id="content">
            <!--		<div id="content_left">
                                    <div class="block_link">
                                            
                                            <a class="a_link" href="${basepath}/grade/getGrade" >学生信息维护</a>
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
                <form id="addForm" action="${basepath}/grade/add" method="post">
                    <div id="addAllRows">										
                        <div class="addRow">
                            <span class="addSpan">班&nbsp;&nbsp;&nbsp;&nbsp;名：</span>
                            <input class="addInput2" name="gradeName" type="text"/>
                        </div>
                        <div class="addRow">
                            <span class="addSpan">所&nbsp;属&nbsp;院&nbsp;系：</span>
                            <input class="addInput2" name="subject" type="text"/>
                        </div>
                        <div class="addRow">
                            <span class="addSpan">人&nbsp;&nbsp;&nbsp;数：</span>
                            <input class="addInput2" name="amount" type="text"/>
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

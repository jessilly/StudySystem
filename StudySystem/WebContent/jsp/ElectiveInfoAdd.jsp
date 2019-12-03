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
        <link type="text/css" rel="stylesheet" href="<%=basepath%>/jsp/css/selectClass.css"/>	
        <title>选课信息添加</title>
    </head>
    <body>
        <div id="header_bar">选&nbsp;课&nbsp;信&nbsp;息&nbsp;添&nbsp;加</div>
        <div id="content">
            <div id="content_left">
                <div class="block_link">

                    <a class="a_link" href="${basepath}/student/getStudent" >学生信息维护</a>
                </div>
                <div class="block_link"><a class="a_link" href="${basepath}/teacher/getTeacher">教师信息维护</a></div>
                <div class="block_link"><a class="a_link" href="${basepath}/subject/getSubject">院系信息维护</a></div>
                <div class="block_link"><a class="a_link" href="${basepath}/grade/getGrade">班级信息维护</a></div>

                <div class="block_link"><a class="a_link" href="${basepath}/course/getCourse">课程信息维护</a></div>
                <div class="block_link"  style="background:rgba(0,191,255,0.2);border:2px dashed white;color:white;"><a class="a_link" href="${basepath}/elective/getElective">选课信息维护</a></div>
                <div class="block_link"><a class="a_link" href="${basepath}/score/getScore">成绩信息维护</a></div>
            </div>
            <div id="content_right">
                <!--action提交至相应路径-->
                <form id="addForm" action="${basepath}/elective/add" method="post">
                    <input type="hidden" name="studentId" value="${stu.id }">
                    <div id="addAllRows">
                        <div class="addRow selAddsel">
                            <span class="addSpan">学生所在系：</span>
                            <input type="text" class="addInput2" name="subject" value="${stu.subject }" readonly/>

                        </div>
                        <div class="addRow selAddsel">
                            <span class="addSpan">所在班级：</span>
                            <input type="text" class="addInput2" name="stuClass" value="${stu.stuClass }" readonly/>
                        </div>
<!--                        <div class="addRow selAddsel">
                            <span class="addSpan">课程类别：</span>
                            <select class="addInput1" id="classKinds_add">

                                <option value="1">专业选修</option>
                                <option value="2">专业必修</option>
                                <option value="3">公选</option>
                            </select>
                        </div>-->
                        <div class="addRow selAddsel">
                            <span class="addSpan">课程名称：</span>
                            <select class="addInput1" id="classKinds_add" name="courseId">

                                <c:forEach items="${courses }" var="course">
                                    <option value="${course.id }">${course.courseName }</option>							
                                </c:forEach>

                            </select>
                        </div>
<!--                        <div class="addRow selAddsel">
                            <span class="addSpan">教师所在系：</span>
                            <select class="addInput1" id="classKinds_add" name="teacherSubject">
                                <option value="计算机科学与技术学院">计算机科学与技术学院</option>
                                <option value="生科院">生科院</option>                             
                                <option value="数统学院">数统学院</option>
                                <option value="音乐学院">音乐学院</option>
                            </select>
                        </div>-->
                        <div class="addRow selAddsel">
                            <span class="addSpan">任课教师：</span>
                            <select class="addInput1" id="classKinds_add" name="teacherName">
                                <!--                                    <option value="李白">李白</option>
                                                                    <option value="杜甫">杜甫</option>
                                                                    <option value="王昭君">王昭君</option>-->
                                <c:forEach items="${teas}" var="tea">
                                    <option value="${tea.teacherName}">${tea.teacherName}</option>  
                                </c:forEach>
                            </select>
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
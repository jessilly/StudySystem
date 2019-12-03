<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="UTF-8">
        <title>成绩管理系统</title>
        <link rel="stylesheet" href="${basepath}/jsp/css/style.css">
        <script type="text/javascript" src="<%=basepath%>/jsp/js/jquery-1.8.3.js"></script>
    </head>

    <body>
        <input type="hidden" name="basePath" value="${basepath}"/>
        <div class="login">
            <h1>成绩管理系统</h1>
            <div class="onee">
                <div class="one">
                    <form action="${basepath}/login" method="post">
                        <p><span>用户名 </span><input name="username" type="text"><label id="number">(学号或教工号)</label></p>
                        <p><span>密&nbsp;&nbsp;码 </span><input name="password" type="password"></p>
                        <span id="discode"></span>
                        <div class="radios">
                            <input name="role" type="radio" value="学生">学生
                            <input name="role" type="radio" value="教师">教师
                            <input name="role" type="radio" value="管理员">管理员
                        </div>
                        <div class="radios">
                            <input name="login" type="submit" value="登录" style="width: 60px;height: 30px;font-size: 18px;" align="center">
                            <input name="reset" type="button" value="重置" style="width: 60px;height: 30px;font-size: 18px;" align="center">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
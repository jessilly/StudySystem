package com.hbnu.study.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        // 获得在下面代码中要用的request,response,session对象
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession();

        // 获得用户请求的URI
        String path = servletRequest.getRequestURI();
        
        // 从session里取学生信息
        Object stu = session.getAttribute("student");
        Object user = session.getAttribute("user");
        // 登陆页面无需过滤
        //图片，样式不能过滤
        if(path.indexOf("LoginPage.jsp") > 0 || path.indexOf("login") > 0||
        		   path.indexOf(".css") > 0||
        		   path.indexOf(".js")>0||
        		   path.indexOf(".jpg") > 0 || 
        		   path.indexOf(".bmp") > 0||
        		   path.indexOf(".gif") > 0||
        		   path.indexOf("authImg") > 0|| 
        		   path.indexOf(".png") > 0)
        {
            chain.doFilter(servletRequest, servletResponse);
            return;
        }

        // 判断如果没有取到学生信息,就跳转到登陆页面
        if (stu == null && user==null) {
            // 跳转到登陆页面
            servletResponse.sendRedirect("/StudySystem/jsp/LoginPage.jsp");
        } else {
            // 已经登陆,继续此次请求
            chain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {

    }

}

package com.hbnu.study.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hbnu.study.bean.LoginDto;
import com.hbnu.study.bean.Student;
import com.hbnu.study.bean.User;
import com.hbnu.study.service.LoginService;
import com.hbnu.study.service.impl.LoginServiceImpl;

@Controller
public class LoginController {

    private LoginService loginService = new LoginServiceImpl();
    /**
     * 登录查询出来的学生实体放入session
     *
     * @param
     * @param session
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, HttpSession session) {
        /**
         * user表里面的数据必须来自其他两个表
         */
        System.out.println(user);
        User newUser = loginService.login(user);
        if (newUser == null) {//user对象为空，返回登录失败界面
            return "LoginFaild";
        }
        session.setAttribute("user", newUser);//添加user对象
        if (newUser.getRole().equals("管理员") || newUser.getRole().equals("教师")) {
            return "MainPage";//如果为管理员或者教师  返回主界面
        }

        Student student = loginService.login2(user);
        if (student != null) {
            session.setAttribute("student", student);//如果为学生
            return "MainPage";
        } else {
            System.out.println("对象为空");
        }
        return "LoginFaild";
    }

    /**
     * 退出登录
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        if (session.getAttribute("user") != null
                && session.getAttribute("student") != null) {
            session.removeAttribute("user");
            session.removeAttribute("student");
            return "LoginPage";
        } else {
            return "LoginPage";
        }
    }
}

package com.hbnu.study.service.impl;

import com.hbnu.study.bean.Student;
import com.hbnu.study.bean.User;
import com.hbnu.study.dao.LoginDao;
import com.hbnu.study.dao.StudentDao;
import com.hbnu.study.service.LoginService;

public class LoginServiceImpl implements LoginService {

    private LoginDao loginDao = new LoginDao();
    private StudentDao stuDao = new StudentDao();

    /**
     * 查找出user的所有信息 返回登录处理
     */
    @Override
    public User login(User user) {
        return loginDao.selectForLogin(user);
    }

    /**
     * 查询学生的学号和密码，返回一个学生对象
     */
    @Override
    public Student login2(User user) {
        Student stu = new Student();
        stu.setStudentNo(user.getUsername());
        stu.setPassword(user.getPassword());
        return stuDao.selectForLogin(stu);
    }
}

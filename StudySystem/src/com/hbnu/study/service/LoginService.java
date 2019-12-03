package com.hbnu.study.service;

import com.hbnu.study.bean.Student;
import com.hbnu.study.bean.User;

public interface LoginService {

    User login(User user);

    Student login2(User user);
}

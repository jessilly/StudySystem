package com.hbnu.study.service.impl;

import java.util.List;

import com.hbnu.study.bean.Student;
import com.hbnu.study.dao.StudentDao;
import com.hbnu.study.service.StudentService;

public class StudentServiceImpl implements StudentService {

    private StudentDao stuDao = new StudentDao();

    @Override
    public boolean addStudent(Student stu) {
        int result = stuDao.saveStudent(stu);
        return result == 0 ? false : true;
    }

    @Override
    public List<Student> getStudent() {
        return stuDao.getStudent();
    }

    @Override
    public List<Student> findStudent(Student stu) {
        List<Student> stus = stuDao.findStudent(stu);
        return stus;
    }

    @Override
    public Student getStuById(int id) {
        Student s = stuDao.getStuById(id);
        return s;
    }

    @Override
    public boolean updateStu(Student stu) {

        return stuDao.updateStu(stu) > 0 ? true : false;

    }

    @Override
    public boolean deleteStu(Student stu) {

        return stuDao.deleteStu(stu) > 0 ? true : false;
    }

}

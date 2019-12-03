package com.hbnu.study.service;

import java.util.List;

import com.hbnu.study.bean.Student;

public interface StudentService {

    public boolean addStudent(Student stu);

    public List<Student> getStudent();

    public List<Student> findStudent(Student stu);

    public Student getStuById(int id);

    public boolean updateStu(Student stu);

    public boolean deleteStu(Student stu);

    // public List getStudent();
}

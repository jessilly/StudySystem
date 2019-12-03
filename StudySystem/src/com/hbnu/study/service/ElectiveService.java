package com.hbnu.study.service;

import java.util.List;

import com.hbnu.study.bean.Elective;
import com.hbnu.study.bean.Student;

public interface ElectiveService {

    List<Elective> getElectives(Student stu);

    boolean addElective(Elective elective);

    boolean deleteElective(Elective elective);

    public List<Elective> findElective(Elective elective);

    public Elective getEleById(int id);

    public boolean updateEle(Elective elective);
}

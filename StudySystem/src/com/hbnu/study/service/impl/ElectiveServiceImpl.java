package com.hbnu.study.service.impl;

import java.util.List;

import com.hbnu.study.bean.Elective;
import com.hbnu.study.bean.Student;
import com.hbnu.study.dao.ElectiveDao;
import com.hbnu.study.service.ElectiveService;

public class ElectiveServiceImpl implements ElectiveService {

    private ElectiveDao electiveDao = new ElectiveDao();

    @Override
    public List<Elective> getElectives(Student stu) {
        return electiveDao.getElectives(stu);
    }

    @Override
    public boolean addElective(Elective elective) {

        return electiveDao.addElective(elective) > 0 ? true : false;
    }

    @Override
    public boolean deleteElective(Elective elective) {
        return electiveDao.deleteElective(elective) > 0 ? true : false;
    }

    @Override
    public List<Elective> findElective(Elective elective) {
        List<Elective> electives = electiveDao.findElective(elective);
        return electives;
    }

    @Override
    public Elective getEleById(int id) {
        Elective e = electiveDao.getEleById(id);
        return e;
    }

    @Override
    public boolean updateEle(Elective elective) {
        return electiveDao.updateStu(elective) > 0 ? true : false;
    }

}

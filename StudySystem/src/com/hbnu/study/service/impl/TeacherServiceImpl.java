/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hbnu.study.service.impl;

import com.hbnu.study.bean.Teacher;
import com.hbnu.study.dao.TeacherDao;
import com.hbnu.study.service.TeacherService;
import java.util.List;

/**
 *
 * @author ls
 */
public class TeacherServiceImpl implements TeacherService {

    private TeacherDao teaDao = new TeacherDao();

    @Override
    public boolean addTeacher(Teacher tea) {
        int result = teaDao.saveTeacher(tea);
        return result == 0 ? false : true;
    }

    @Override
    public List<Teacher> getTeacher() {
        return teaDao.getTeacher();
    }

    @Override
    public List<Teacher> findTeacher(Teacher tea) {
        List<Teacher> teas = teaDao.findTeacher(tea);
        return teas;
    }

    @Override
    public Teacher getTeaById(int id) {
        Teacher s = teaDao.getTeaById(id);
        return s;
    }

    @Override
    public boolean updateTea(Teacher tea) {

        return teaDao.updateTea(tea) > 0 ? true : false;

    }

    @Override
    public boolean deleteTea(Teacher tea) {

        return teaDao.deleteTea(tea) > 0 ? true : false;
    }

}

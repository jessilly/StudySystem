/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hbnu.study.service;

import com.hbnu.study.bean.Teacher;
import java.util.List;

/**
 *
 * @author ls
 */
public interface TeacherService {

    public boolean addTeacher(Teacher tea);

    public List<Teacher> getTeacher();

    public List<Teacher> findTeacher(Teacher tea);

    public Teacher getTeaById(int id);

    public boolean updateTea(Teacher tea);

    public boolean deleteTea(Teacher tea);

}

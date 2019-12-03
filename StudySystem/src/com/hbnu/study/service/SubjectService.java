/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hbnu.study.service;

import com.hbnu.study.bean.Subject;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface SubjectService {
    
    public List<Subject> getSubject();

    public boolean addSubject(Subject sub);

    public Subject getSubById(int id);

    public boolean updateSub(Subject sub);

    public boolean deleteSub(Subject sub);
    public List<Subject> findSubject(Subject sub);

    public List<Subject> getSubjectForAdd();
}

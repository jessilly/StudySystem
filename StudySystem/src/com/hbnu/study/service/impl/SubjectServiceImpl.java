/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hbnu.study.service.impl;

import com.hbnu.study.bean.Subject;
import com.hbnu.study.dao.SubjectDao;
import com.hbnu.study.service.SubjectService;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class SubjectServiceImpl implements SubjectService {

    private SubjectDao subDao = new SubjectDao();

    @Override
    public List<Subject> getSubject() {
        return subDao.getSubject();
    }

    @Override
    public boolean addSubject(Subject sub) {
        int result = subDao.saveSubject(sub);
        return result == 0 ? false : true;
    }

    @Override
    public Subject getSubById(int id) {
        Subject s=subDao.getStuById(id);
		return s;
    }
    @Override
	public List<Subject> findSubject(Subject sub) {
		List<Subject> subs=subDao.findSubject(sub);
		return subs;
	}

    @Override
    public boolean updateSub(Subject sub) {
        return subDao.updateSub(sub)>0?true:false;
    }

    @Override
    public boolean deleteSub(Subject sub) {
        return subDao.deleteSub(sub)>0?true:false;
    }

    @Override
    public List<Subject> getSubjectForAdd() {
        return subDao.getSubjectForAdd();
    }
    
    
}

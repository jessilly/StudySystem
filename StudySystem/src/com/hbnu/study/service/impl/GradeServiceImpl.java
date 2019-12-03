/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hbnu.study.service.impl;

import com.hbnu.study.bean.Grade;
import com.hbnu.study.dao.GradeDao;
import com.hbnu.study.service.GradeService;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class GradeServiceImpl implements GradeService {

    private GradeDao graDao = new GradeDao();

	@Override
	public boolean addGrade(Grade gra) {
		int result = graDao.saveGrade(gra);
		return result == 0 ? false : true;
	}

	@Override
	public List<Grade> getGrade() {
		return graDao.getGrade();
	}

	@Override
	public List<Grade> findGrade(Grade gra) {
		List<Grade> gras=graDao.findGrade(gra);
		return gras;
	}

	@Override
	public Grade getGraById(int id) {
		Grade s=graDao.getGraById(id);
		return s;
	}

	@Override
	public boolean updateGra(Grade gra) {
		
		return graDao.updateGra(gra)>0?true:false;
		
	}

	@Override
	public boolean deleteGra(Grade gra) {
		
		return graDao.deleteGra(gra)>0?true:false;
	}
	
	
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hbnu.study.service;

import com.hbnu.study.bean.Grade;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface GradeService {

        public boolean addGrade(Grade gra);
	
	public List<Grade> getGrade();

	public List<Grade> findGrade(Grade gra);

	public Grade getGraById(int id);

	public boolean updateGra(Grade gra);

	public boolean deleteGra(Grade gra);
    
}

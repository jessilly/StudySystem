/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hbnu.study.service;

import com.hbnu.study.bean.Score;
import com.hbnu.study.bean.Teacher;
import java.util.List;

/**
 *
 * @author ls
 */
public interface ScoreService {

      //  public boolean addScore(Score sco);
	
	public List<Score> getScore();

	public List<Score> findScore(Teacher tea);

	public Score getScoreById(int id);

	public boolean updateScore(Score sco);

	public boolean deleteScore(Score sco);

}

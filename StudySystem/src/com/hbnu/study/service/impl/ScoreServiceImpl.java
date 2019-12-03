/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hbnu.study.service.impl;

import com.hbnu.study.bean.Score;
import com.hbnu.study.bean.Teacher;
import com.hbnu.study.dao.ScoreDao;
import com.hbnu.study.service.ScoreService;
import java.util.List;

/**
 *
 * @author ls
 */
public class ScoreServiceImpl implements ScoreService {

    private ScoreDao scoDao = new ScoreDao();
    @Override
    public List<Score> findScore(Teacher tea) {
        List<Score> scos = scoDao.findScore(tea);
        return scos;
    }

    @Override
    public Score getScoreById(int id) {
        Score c = scoDao.getScoreById(id);
        return c;
    }

    @Override
    public boolean updateScore(Score sco) {
        return scoDao.updateScore(sco) > 0 ? true : false;
    }

    @Override
    public boolean deleteScore(Score sco) {
        return scoDao.deleteScore(sco) > 0 ? true : false;
    }

    @Override
    public List<Score> getScore() {
        return scoDao.getScore();
    }

}

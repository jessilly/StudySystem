/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hbnu.study.controller;

import com.hbnu.study.bean.Course;
import com.hbnu.study.bean.Score;
import com.hbnu.study.bean.Student;
import com.hbnu.study.bean.Teacher;
import com.hbnu.study.service.CourseService;
import com.hbnu.study.service.ScoreService;
import com.hbnu.study.service.TeacherService;
import com.hbnu.study.service.impl.CourseServiceImpl;
import com.hbnu.study.service.impl.ScoreServiceImpl;
import com.hbnu.study.service.impl.TeacherServiceImpl;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ls
 */
@Controller
//注解绑定，可以通过url进行访问
@RequestMapping("/score")
public class ScoreController {

    private ScoreService scoService = new ScoreServiceImpl();
    private TeacherService teaService = new TeacherServiceImpl();

    @RequestMapping("/getScore")
    public String getScore(Model m) {
        List scos = scoService.getScore();
        List teas = teaService.getTeacher();
        m.addAttribute("teas", teas);//存在model 中
        m.addAttribute("scos", scos);
        return "ScoreInfoProtect";
    }

    @RequestMapping(value = "/findScore", method = RequestMethod.POST)
    public String findScore(Model m, Teacher tea) {

        List scos = scoService.findScore(tea);
        List teas = teaService.getTeacher();
        m.addAttribute("teas", teas);//存在model 中
        m.addAttribute("scos", scos);
        return "ScoreInfoProtect";
    }

    @RequestMapping("/getScoreById")
    public String getScoreById(Model m, Score sco) {
        Score s = scoService.getScoreById(sco.getId());
        m.addAttribute("scos", s);
        return "ScoreInfoUpdate";
    }

    @RequestMapping(value = "/updateScore", method = RequestMethod.POST)
    public String updateScore(Score sco) {
        if (scoService.updateScore(sco)) {
            return "redirect:/score/getScore";
        } else {
            return "MainPage";
        }
    }

//    @RequestMapping(value = "/delete", method = RequestMethod.GET)
//    public String deleteScore(Score sco) {
//        if (scoService.deleteScore(sco)) {
//            return "redirect:/score/getScore";
//        } else {
//            return "MainPage";
//        }
//    }
}

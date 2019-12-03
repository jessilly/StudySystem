/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hbnu.study.controller;

import com.hbnu.study.bean.Grade;
import com.hbnu.study.bean.Subject;
import com.hbnu.study.service.GradeService;
import com.hbnu.study.service.SubjectService;
import com.hbnu.study.service.impl.GradeServiceImpl;
import com.hbnu.study.service.impl.SubjectServiceImpl;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Administrator
 */
@Controller
//注解绑定，可以通过url进行访问
@RequestMapping("/grade")
public class GradeController {

    private GradeService graService = new GradeServiceImpl();
    private SubjectService subService = new SubjectServiceImpl();

    @RequestMapping("/add")
    public String addGrade(Grade gra) {
        boolean result = graService.addGrade(gra);
        if (result) {
            return "redirect:/grade/getGrade";
        } else {
            return "MainPage";
        }

    }

    @RequestMapping("/getGrade")
    public String getGrade(Model m) {
        //定义了一个集合类，保存所有的学生对象
        List gras = graService.getGrade();
        m.addAttribute("gras", gras);//存在model 中
        List<Subject> subs = subService.getSubject();
        m.addAttribute("subs", subs);
        return "GradeInfoProtect";//调用这个jsp  界面
    }

    @RequestMapping(value = "/findGrade", method = RequestMethod.POST)
    public String findGrade(Model m, Grade gra) {
        List gras = graService.findGrade(gra);
        m.addAttribute("gras", gras);
        List<Subject> subs = subService.getSubject();
        m.addAttribute("subs", subs);
        return "GradeInfoProtect";
    }

    @RequestMapping("/getGraById")
    public String getGraById(Model m, Grade gra) {
        Grade s = graService.getGraById(gra.getId());
        m.addAttribute("gra", s);
        return "GradeInfoUpdate";
    }

    @RequestMapping(value = "/updateGra", method = RequestMethod.POST)
    public String updateGra(Grade gra) {
        System.out.print("121w1edwefdwefw");
        System.out.print(gra.getGradeName());
        if (graService.updateGra(gra)) {
            return "redirect:/grade/getGrade";
        } else {
            return "MainPage";
        }
    }

    @RequestMapping(value = "/deleteGra", method = RequestMethod.GET)
    public String deleteGra(Grade gra) {
        if (graService.deleteGra(gra)) {
            return "redirect:/grade/getGrade";
        } else {
            return "MainPage";
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hbnu.study.controller;

import com.hbnu.study.bean.Subject;
import com.hbnu.study.service.SubjectService;
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
@RequestMapping("/subject")
public class SubjectController {

    private SubjectService subService = new SubjectServiceImpl();

    @RequestMapping("/getSubject")
    public String getSubject(Model b) {
        //定义了一个集合类，保存所有的院系对象
        List sub = subService.getSubject();
        b.addAttribute("subs", sub);//存在model 中
        return "SubjectInfoProtect";//调用这个jsp  界面
    }

    @RequestMapping("/add")
    public String addSubject(Subject sub) {
        boolean result = subService.addSubject(sub);
        if (result) //重定向
        {
            return "redirect:/subject/getSubject";
        } else {
            return "MainPage";
        }

    }

    @RequestMapping(value = "/getSubjectForAdd", method = RequestMethod.GET)
    public String getSubjectForAdd(Model model) {
        List<Subject> subs = null;      
       subs = subService.getSubjectForAdd();       
        model.addAttribute("subs", subs);
        return "/subject/SubjectInfoAdd";
    }

    @RequestMapping("/getSubById")
    public String getSubById(Model m, Subject sub) {
        Subject s = subService.getSubById(sub.getId());
        m.addAttribute("sub", s);
        return "SubjectInfoUpdate";
    }

    @RequestMapping(value = "/findSubject", method = RequestMethod.POST)
    public String findSubject(Model m, Subject sub) {
        List subs = subService.findSubject(sub);
        m.addAttribute("subs", subs);
        return "SubjectInfoProtect";
    }

    @RequestMapping(value = "/updateSub", method = RequestMethod.POST)
    public String updateSub(Subject sub) {
        if (subService.updateSub(sub)) {
            return "redirect:/subject/getSubject";
        } else {
            return "MainPage";
        }
    }

    @RequestMapping(value = "/deleteSub", method = RequestMethod.GET)
    public String deleteSub(Subject sub) {
        if (subService.deleteSub(sub)) {
            return "redirect:/subject/getSubject";
        } else {
            return "MainPage";
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hbnu.study.controller;

import com.hbnu.study.bean.Course;
import com.hbnu.study.bean.Teacher;
import com.hbnu.study.service.CourseService;
import com.hbnu.study.service.TeacherService;
import com.hbnu.study.service.impl.CourseServiceImpl;
import com.hbnu.study.service.impl.TeacherServiceImpl;
import java.util.List;
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
@RequestMapping("/teacher")
public class TeacherController {

    private TeacherService teaService = new TeacherServiceImpl();
    private CourseService courseService = new CourseServiceImpl();

    @RequestMapping("/add")
    public String addTeacher(Teacher tea) {
        boolean result = teaService.addTeacher(tea);
        if (result) {
            return "redirect:/teacher/getTeacher";
        } else {
            return "MainPage";
        }

    }

    @RequestMapping("/preAdd")
    public String toAddTeacher(Teacher tea, Model m) {
        List<Course> courses = courseService.getCourse();
        m.addAttribute("courses", courses);
        return "TeacherInfoAdd";
    }

    @RequestMapping("/getTeacher")
    public String getTeacher(Model m) {
        //定义了一个集合类，保存所有的学生对象
        List teas = teaService.getTeacher();
        m.addAttribute("teas", teas);//存在model 中
        List<Course> courses = courseService.getCourse();
        m.addAttribute("courses", courses);
        return "TeacherInfoProtect";//调用这个jsp  界面
    }

    @RequestMapping(value = "/findTeacher", method = RequestMethod.POST)
    public String findTeacher(Model m, Teacher tea) {
        List teas = teaService.findTeacher(tea);
        m.addAttribute("teas", teas);
        List<Course> courses = courseService.getCourse();
        m.addAttribute("courses", courses);
        return "TeacherInfoProtect";
    }

    @RequestMapping("/getTeaById")
    public String getTeaById(Model m, Teacher tea) {
        Teacher s = teaService.getTeaById(tea.getId());
        m.addAttribute("tea", s);
        List<Course> courses = courseService.getCourse();
        m.addAttribute("courses", courses);
        return "TeacherInfoUpdate";
    }

    @RequestMapping(value = "/updateTea", method = RequestMethod.POST)
    public String updateTea(Teacher tea) {
        if (teaService.updateTea(tea)) {
            return "redirect:/teacher/getTeacher";
        } else {
            return "MainPage";
        }
    }

    @RequestMapping(value = "/deleteTea", method = RequestMethod.GET)
    public String deleteTea(Teacher tea) {
        if (teaService.deleteTea(tea)) {
            return "redirect:/teacher/getTeacher";
        } else {
            return "MainPage";
        }
    }

}

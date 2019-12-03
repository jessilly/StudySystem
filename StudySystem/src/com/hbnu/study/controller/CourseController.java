package com.hbnu.study.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hbnu.study.bean.Course;
import com.hbnu.study.bean.Student;
import com.hbnu.study.service.CourseService;
import com.hbnu.study.service.impl.CourseServiceImpl;

@RequestMapping("/course")
@Controller
public class CourseController {

    private CourseService courseService = new CourseServiceImpl();

    /**
     * 获取所有课程信息
     *
     * @param m
     * @return
     */
    @RequestMapping("/getCourse")
    public String getCourse(Model m) {
        List courses = courseService.getCourse();
        m.addAttribute("courses", courses);
        return "CourseInfoProtect";
    }

    @RequestMapping("/add")
    public String addCourse(Course course) {
        boolean result = courseService.addCourse(course);
        if (result) {
            return "redirect:/course/getCourse";
        } else {
            return "MainPage";
        }
    }

    @RequestMapping("/getCourseById")
    public String getStuById(Model m, Course course) {
        Course c = courseService.getCourseById(course.getId());
        m.addAttribute("course", c);
        return "CourseInfoUpdate";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateStu(Course course) {
        if (courseService.updateCourse(course)) {
            return "redirect:/course/getCourse";
        } else {
            return "MainPage";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteStu(Course course) {
        if (courseService.deleteCourse(course)) {
            return "redirect:/course/getCourse";
        } else {
            return "MainPage";
        }
    }

    @RequestMapping(value = "/findCourse", method = RequestMethod.POST)
    public String findCourse(Model m, Course course) {
        List courses = courseService.findCourse(course);
        m.addAttribute("courses", courses);
        return "CourseInfoProtect";
    }
}

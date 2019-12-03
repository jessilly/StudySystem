package com.hbnu.study.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hbnu.study.bean.Course;
import com.hbnu.study.bean.Elective;
import com.hbnu.study.bean.Student;
import com.hbnu.study.bean.Teacher;
import com.hbnu.study.service.CourseService;
import com.hbnu.study.service.ElectiveService;
import com.hbnu.study.service.TeacherService;
import com.hbnu.study.service.impl.CourseServiceImpl;
import com.hbnu.study.service.impl.ElectiveServiceImpl;
import com.hbnu.study.service.impl.TeacherServiceImpl;

@RequestMapping("/elective")
@Controller
public class ElectiveController {

    private ElectiveService eleService = new ElectiveServiceImpl();
    private CourseService courseService = new CourseServiceImpl();
    private TeacherService teaService = new TeacherServiceImpl();

    /**
     * 获取所有课程信息
     *
     * @param m
     * @return
     */
    @RequestMapping("/getElective")
    public String getElective(Model m, HttpSession session) {
        //从SESSION里取出登录成功时放进去的student对象
        Student stu = (Student) session.getAttribute("student");
        List<Elective> electives = eleService.getElectives(stu);
        m.addAttribute("electives", electives);
        return "ElectiveInfoProtect";
    }

    @RequestMapping("/preAdd")
    public String toAddElective(HttpSession session, Model m) {

        Student stu = null;
        //在session里取出登录的学生信息
        if (null != session.getAttribute("student")) {
            stu = (Student) session.getAttribute("student");
        }
        //搜索全部课程信息,学生在新增选课的页面上可以查看
        List<Course> courses = courseService.getCourse();
        List<Teacher> teas = teaService.getTeacher();
        if (null != stu) {
            m.addAttribute("stu", stu);
            m.addAttribute("courses", courses);
            m.addAttribute("teas", teas);
            return "ElectiveInfoAdd";
        } else {
            return "MainPage";
        }
    }

    @RequestMapping("/add")
    public String addElective(Elective elective) {
        boolean result = eleService.addElective(elective);
        if (result) {
            return "redirect:/elective/getElective";
        } else {
            return "MainPage";
        }
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public String findElective(Model m, Elective elective) {
        List eles = eleService.findElective(elective);
        m.addAttribute("electives", eles);
        return "ElectiveInfoProtect";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteElective(Elective elective) {
        if (eleService.deleteElective(elective)) {
            return "redirect:/elective/getElective";
        } else {
            return "MainPage";
        }
    }

    @RequestMapping("/getEleById")
    public String getEleById(Model m, Elective elective) {
        Elective s = eleService.getEleById(elective.getId());
        m.addAttribute("electives", s);
        return "ElectiveInfoUpdate";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateEle(Elective elective) {
        if (eleService.updateEle(elective)) {
            return "redirect:/elective/getElective";
        } else {
            return "MainPage";
        }
    }
}

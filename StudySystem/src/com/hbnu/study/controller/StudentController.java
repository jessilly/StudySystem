package com.hbnu.study.controller;

import com.hbnu.study.bean.Course;
import com.hbnu.study.bean.Grade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hbnu.study.bean.Student;
import com.hbnu.study.bean.Subject;
import com.hbnu.study.service.CourseService;
import com.hbnu.study.service.GradeService;
import com.hbnu.study.service.StudentService;
import com.hbnu.study.service.SubjectService;
import com.hbnu.study.service.impl.CourseServiceImpl;
import com.hbnu.study.service.impl.GradeServiceImpl;
import com.hbnu.study.service.impl.StudentServiceImpl;
import com.hbnu.study.service.impl.SubjectServiceImpl;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

@Controller
//注解绑定，可以通过url进行访问
@RequestMapping("/student")
public class StudentController {

    private StudentService stuService = new StudentServiceImpl();
    private SubjectService subService = new SubjectServiceImpl();
    private GradeService graService = new GradeServiceImpl();
    private CourseService courseService = new CourseServiceImpl();

    @RequestMapping("/add")
    public String addStudent(Student stu) {
        boolean result = stuService.addStudent(stu);
        if (result) {
            return "redirect:/student/getStudent";
        } else {
            return "MainPage";
        }

    }

    @RequestMapping("/preAdd")
    public String toAddStudent(Student stu, Model m) {
        List<Subject> subs = subService.getSubject();
        List<Grade> gras = graService.getGrade();
        List<String> listTemp = new <String>ArrayList();
        for (int i = 0; i < gras.size(); i++) {
            System.out.print(gras.get(i).getGradeName());
            if (!listTemp.contains(gras.get(i).getGradeName())) {
                listTemp.add(gras.get(i).getGradeName());
            }
        }
        m.addAttribute("gras", listTemp);
        m.addAttribute("subs", subs);
        if (stu != null) {
            return "StudentInfoAdd";
        } else {
            return "MainPage";
        }
    }

    @RequestMapping("/getStudent")
    public String getStudent(Model m) {
        //定义了一个集合类，保存所有的学生对象
        List stus = stuService.getStudent();
        List<Subject> subs = subService.getSubject();
        List<Grade> gras = graService.getGrade();
        List<String> listTemp = new <String>ArrayList();
        for (int i = 0; i < gras.size(); i++) {
            System.out.print(gras.get(i).getGradeName());
            if (!listTemp.contains(gras.get(i).getGradeName())) {
                listTemp.add(gras.get(i).getGradeName());
            }
        }
        m.addAttribute("stus", stus);//存在model 中
        m.addAttribute("gras", listTemp);//存在model 中
        m.addAttribute("subs", subs);
        return "StudentInfoProtect";//调用这个jsp  界面
    }

    @RequestMapping(value = "/findStudent", method = RequestMethod.POST)
    public String findStudent(Model m, Student stu) {
        List stus = stuService.findStudent(stu);
        m.addAttribute("stus", stus);
        List<Subject> subs = subService.getSubject();
        List<Grade> gras = graService.getGrade();
        List<String> listTemp = new <String>ArrayList();
        for (int i = 0; i < gras.size(); i++) {
            System.out.print(gras.get(i).getGradeName());
            if (!listTemp.contains(gras.get(i).getGradeName())) {
                listTemp.add(gras.get(i).getGradeName());
            }
        }
        m.addAttribute("gras", listTemp);
        m.addAttribute("subs", subs);
        return "StudentInfoProtect";
    }

    @RequestMapping("/getStuById")
    public String getStuById(Model m, Student stu) {
        Student s = stuService.getStuById(stu.getId());
        m.addAttribute("stu", s);
        List<Subject> subs = subService.getSubject();
        List<Grade> gras = graService.getGrade();
         List<String> listTemp = new <String>ArrayList();
        for (int i = 0; i < gras.size(); i++) {
            System.out.print(gras.get(i).getGradeName());
            if (!listTemp.contains(gras.get(i).getGradeName())) {
                listTemp.add(gras.get(i).getGradeName());
            }
        }
        m.addAttribute("gras", listTemp);
        m.addAttribute("subs", subs);
        return "StudentInfoUpdate";
    }

    @RequestMapping(value = "/updateStu", method = RequestMethod.POST)
    public String updateStu(Student stu) {
        if (stuService.updateStu(stu)) {
            return "redirect:/student/getStudent";
        } else {
            return "MainPage";
        }
    }

    @RequestMapping(value = "/deleteStu", method = RequestMethod.GET)
    public String deleteStu(Student stu) {
        if (stuService.deleteStu(stu)) {
            return "redirect:/student/getStudent";
        } else {
            return "MainPage";
        }
    }

}

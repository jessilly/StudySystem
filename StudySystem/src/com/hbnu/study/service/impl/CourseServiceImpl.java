package com.hbnu.study.service.impl;

import java.util.List;

import com.hbnu.study.bean.Course;
import com.hbnu.study.dao.CourseDao;
import com.hbnu.study.service.CourseService;

public class CourseServiceImpl implements CourseService {
    private CourseDao courseDao = new CourseDao();
    @Override
    public List<Course> getCourse() {
        return courseDao.getCourse();
    }
    @Override
    public boolean addCourse(Course course) {

        return courseDao.addCourse(course) > 0 ? true : false;
    }

    @Override
    public Course getCourseById(int id) {

        return courseDao.getCourseById(id);
    }

    @Override
    public boolean updateCourse(Course course) {
        return courseDao.updateCourse(course) > 0 ? true : false;
    }

    @Override
    public boolean deleteCourse(Course course) {
        return courseDao.deleteCourse(course) > 0 ? true : false;
    }

    @Override
    public List<Course> findCourse(Course course) {
        List<Course> courses = courseDao.findCourse(course);
        return courses;
    }

}

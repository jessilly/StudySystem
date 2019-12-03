package com.hbnu.study.service;

import java.util.List;

import com.hbnu.study.bean.Course;

public interface CourseService {

	List<Course> getCourse();

	boolean addCourse(Course course);

	Course getCourseById(int id);

	boolean updateCourse(Course course);
	
	boolean deleteCourse(Course course);

        public List<Course> findCourse(Course course);
       

}

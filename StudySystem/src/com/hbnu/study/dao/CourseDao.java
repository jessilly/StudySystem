package com.hbnu.study.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hbnu.study.bean.Course;
import com.hbnu.study.bean.Student;
import com.hbnu.study.dao.common.DBUtils;

public class CourseDao {

    public List<Course> getCourse() {
        Connection conn = DBUtils.getConn();
        ResultSet rs = null;
        List<Course> courses = new ArrayList<Course>();
        String sql = "select * from Course ";
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);

            rs = pStatement.executeQuery();

            while (rs.next()) {
                Course course = new Course();
                course.setId(rs.getInt(1));
                course.setCourseNo(rs.getString(2));
                course.setCourseName(rs.getString(3));
                course.setCredit(rs.getInt(4));
                course.setCourseHour(rs.getInt(5));
                course.setCourseType(rs.getString(6));

                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConn(conn);
        }

        return courses;
    }

    public int addCourse(Course course) {

        Connection conn = DBUtils.getConn();
        int result = 0;
        String sql = "insert into COURSE(COURSE_NO,COURSE_NAME,CREDIT,COURSE_HOUR,COURSE_TYPE) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, course.getCourseNo());
            pStatement.setString(2, course.getCourseName());
            pStatement.setInt(3, course.getCredit());
            pStatement.setInt(4, course.getCourseHour());
            pStatement.setString(5, course.getCourseType());

            result = pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConn(conn);
        }

        return result;
    }

    public Course getCourseById(int id) {

        Connection conn = DBUtils.getConn();
        ResultSet rs = null;
        Course c = null;
        String sql = "select * from Course where ID=?";
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, id);
            rs = pStatement.executeQuery();
            while (rs.next()) {
                c = new Course();
                c.setId(rs.getInt(1));
                c.setCourseNo(rs.getString(2));
                c.setCourseName(rs.getString(3));
                c.setCredit(rs.getInt(4));
                c.setCourseHour(rs.getInt(5));
                c.setCourseType(rs.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConn(conn);
        }

        return c;
    }

    public int updateCourse(Course course) {
        Connection conn = DBUtils.getConn();
        int result = 0;
        String sql = "update COURSE set COURSE_NO=?,COURSE_NAME=?,CREDIT=?,COURSE_HOUR=?,COURSE_TYPE=? where id=?";
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, course.getCourseNo());
            pStatement.setString(2, course.getCourseName());
            pStatement.setInt(3, course.getCredit());
            pStatement.setInt(4, course.getCourseHour());
            pStatement.setString(5, course.getCourseType());
            pStatement.setInt(6, course.getId());
            result = pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConn(conn);
        }
        return result;
    }

    public int deleteCourse(Course course) {

        Connection conn = DBUtils.getConn();
        int result = 0;
        String sql = "delete from COURSE where id=?";
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, course.getId());
            result = pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConn(conn);
        }

        return result;
    }

    public List<Course> findCourse(Course course) {
        StringBuffer sql = new StringBuffer("select * from COURSE ");
        boolean ifand = false;
        if (!("".equals(course.getCourseType()))) {
            sql.append("where ");
        }
        if (!("".equals(course.getCourseType()))) {
            ifand = true;
            sql.append("COURSE_TYPE ='" + course.getCourseType() + "'");
        }
        Connection conn = DBUtils.getConn();
        ResultSet rs = null;
        List<Course> courses = new ArrayList<Course>();
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql.toString());
            rs = pStatement.executeQuery();
            while (rs.next()) {
                Course c = new Course();
                c.setId(rs.getInt(1));
                c.setCourseNo(rs.getString(2));
                c.setCourseName(rs.getString(3));
                c.setCredit(rs.getInt(4));
                c.setCourseHour(rs.getInt(5));
                c.setCourseType(rs.getString(6));
                courses.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConn(conn);
        }
        return courses;
    }

}

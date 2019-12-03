package com.hbnu.study.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hbnu.study.bean.Elective;
import com.hbnu.study.bean.Student;
import com.hbnu.study.dao.common.DBUtils;

public class ElectiveDao {

    /**
     * 根据登录学生 的信息查询当前用户的选课信息
     *
     * @param stu
     * @return
     */
    public List<Elective> getElectives(Student stu) {
        Connection conn = DBUtils.getConn();
        ResultSet rs = null;
        List<Elective> electives = new ArrayList<Elective>();
        //三表(学生表,课程表,选课信息表)联合查询
        String sql = "select id ,"
                + "(select course_name from course where id=e.COURSE_ID) as course_name_c,"
                + "(select STU_CLASS from student where id=e.student_id) as class_name_c,"
                + "(select subject from student where id=e.student_id) as subject_name_c,"
                + "TEACHER_NAME "
                + "from ELECTIVE e "
                + "where student_id=?";
        System.out.println("============" + sql);
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, stu.getId());
            rs = pStatement.executeQuery();
            while (rs.next()) {
                Elective elective = new Elective();
                elective.setId(rs.getInt(1));
                elective.setCourseName(rs.getString(2));
                elective.setClassName(rs.getString(3));
                elective.setSubjectName(rs.getString(4));
                elective.setTeacherName(rs.getString(5));
                electives.add(elective);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConn(conn);
        }

        return electives;
    }

    public int addElective(Elective elective) {

        Connection conn = DBUtils.getConn();
        int result = 0;
        String sql = "insert into ELECTIVE(COURSE_ID,STUDENT_ID,TEACHER_SUBJECT,TEACHER_NAME) VALUES(?,?,?,?)";
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, elective.getCourseId());
            pStatement.setInt(2, elective.getStudentId());
            pStatement.setString(3, elective.getTeacherSubject());
            pStatement.setString(4, elective.getTeacherName());

            result = pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConn(conn);
        }

        return result;
    }

    public int deleteElective(Elective elective) {

        Connection conn = DBUtils.getConn();
        int result = 0;
        String sql = "delete from ELECTIVE where id=?";
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, elective.getId());
            result = pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConn(conn);
        }

        return result;
    }

    public List<Elective> findElective(Elective elective) {
        StringBuffer sql = new StringBuffer("select * from ELECTIVE ");
        boolean ifand = false;
        if (!("".equals(elective.getTeacherName()))) {
            sql.append("where ");
        }

        if (!("".equals(elective.getTeacherName()))) {
            ifand = true;
            sql.append("TEACHER_NAME ='" + elective.getTeacherName() + "'");
        }

        Connection conn = DBUtils.getConn();
        ResultSet rs = null;
        List<Elective> electives = new ArrayList<Elective>();
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql.toString());
            rs = pStatement.executeQuery();
            while (rs.next()) {
                elective = new Elective();
                elective.setId(rs.getInt(1));
                elective.setCourseName(rs.getString(2));
                elective.setClassName(rs.getString(3));
                elective.setSubjectName(rs.getString(4));
                elective.setTeacherName(rs.getString(5));
                electives.add(elective);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConn(conn);
        }
        return electives;
    }

    public Elective getEleById(int id) {
        Connection conn = DBUtils.getConn();
        ResultSet rs = null;
        Elective ele = null;
        String sql = "select * from ELECTIVE where ID=?";
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, id);
            rs = pStatement.executeQuery();
            while (rs.next()) {
                Elective elective = new Elective();
                elective.setId(rs.getInt(1));
                elective.setCourseName(rs.getString(2));
                elective.setClassName(rs.getString(3));
                elective.setSubjectName(rs.getString(4));
                elective.setTeacherName(rs.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConn(conn);
        }

        return ele;
    }

    public int updateStu(Elective elective) {
        Connection conn = DBUtils.getConn();
        int result = 0;
        String sql = "update ELECTIVE set STUDENT_NO=?,STUDENT_NAME=?,SEX=?,SUBJECT=?,STU_CLASS=? where id=?";
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, elective.getSubjectName());
            pStatement.setString(2, elective.getCourseName());
            pStatement.setString(3, elective.getClassName());
            pStatement.setString(4, elective.getTeacherName());
            pStatement.setInt(5, elective.getId());
            result = pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConn(conn);
        }
        return result;
    }

}

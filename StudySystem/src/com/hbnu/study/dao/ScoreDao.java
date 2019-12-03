/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hbnu.study.dao;

import com.hbnu.study.bean.Score;
import com.hbnu.study.bean.Teacher;
import com.hbnu.study.dao.common.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ls
 */
public class ScoreDao {

    /**
     * 搜索所有学生信息
     *
     * @param stu
     * @return
     */
    public List<Score> getScore() {
        Connection conn = DBUtils.getConn();
        ResultSet rs = null;
        List<Score> scos = new ArrayList<Score>();
        String sql1 = "select "
                + "sco.ID,"
                + "stu.STUDENT_NO,stu.STUDENT_NAME,stu.STU_CLASS,stu.SEX,"
                + "cou.COURSE_NO,cou.COURSE_NAME,sco.SCORE "
                + "FROM "
                + "student as stu,"
                + "course as cou,"
                + "score as sco "
                + "where stu.STUDENT_NO=sco.STUDENT_NO "
                + "and cou.COURSE_NO=sco.COURSE_NO";
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql1);
            rs = pStatement.executeQuery();
            while (rs.next()) {

                Score s = new Score();
                s.setId(rs.getInt(1));
                s.setStudentNo(rs.getString(2));
                s.setStudentName(rs.getString(3));
                s.setStuClass(rs.getString(4));
                s.setSex(rs.getString(5));
                s.setCourseNo(rs.getString(6));
                s.setCourseName(rs.getString(7));
                s.setScore(rs.getString(8));
                scos.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConn(conn);
        }
        return scos;
    }

    /**
     * 条件搜索成绩信息
     *
     * @param
     * @return
     */
    public List<Score> findScore(Teacher tea) {
        StringBuffer sql = new StringBuffer(
                "select "
                + "sco.ID,stu.STUDENT_NO,"
                + "stu.STUDENT_NAME,"
                + "stu.STU_CLASS,"
                + "stu.SEX,"
                + "cou.COURSE_NO,"
                + "cou.COURSE_NAME,"
                + "sco.SCORE "
                + "FROM "
                + "student as stu,course as cou,score as sco,teacher as tea "
                + "where stu.STUDENT_NO=sco.STUDENT_NO and cou.COURSE_NO=sco.COURSE_NO and cou.course_name=tea.type and tea.teacher_name="
                + "'" + tea.getTeacherName() + "'");
        boolean ifand = false;
        Connection conn = DBUtils.getConn();
        ResultSet rs = null;
        List<Score> stus = new ArrayList<Score>();
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql.toString());
            rs = pStatement.executeQuery();
            while (rs.next()) {
                Score s = new Score();
                s.setId(rs.getInt(1));
                s.setStudentNo(rs.getString(2));
                s.setStudentName(rs.getString(3));
                s.setStuClass(rs.getString(4));
                s.setSex(rs.getString(5));
                s.setCourseNo(rs.getString(6));
                s.setCourseName(rs.getString(7));
                s.setScore(rs.getString(8));
                stus.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConn(conn);
        }
        return stus;
    }

    public Score getScoreById(int id) {
        Connection conn = DBUtils.getConn();
        ResultSet rs = null;
        Score s = null;
        String sql = "select "
                + "so.id,"
                + "so.student_no,"
                + "so.course_no,"
                + "so.score,"
                + "st.student_name "
                + "from Score as so,student as st"
                + " where so.id=? and so.student_no=st.student_no";
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, id);
            rs = pStatement.executeQuery();
            while (rs.next()) {
                s = new Score();
                s.setId(rs.getInt(1));
                s.setStudentNo(rs.getString(2));
                s.setCourseNo(rs.getString(3));
                s.setScore(rs.getString(4));
                s.setStudentName(rs.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConn(conn);
        }

        return s;
    }

    public int updateScore(Score sco) {
        Connection conn = DBUtils.getConn();
        int result = 0;
        String sql = "update Score set SCORE=? where id=?";
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);

            pStatement.setString(1, sco.getScore());
            pStatement.setInt(2, sco.getId());
            result = pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConn(conn);
        }

        return result;
    }

    public int deleteScore(Score sco) {

        Connection conn = DBUtils.getConn();
        int result = 0;
        String sql = "delete from Score where id=?";
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            System.out.println("成绩的id" + sco.getId());
            pStatement.setInt(1, sco.getId());
            result = pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConn(conn);
        }

        return result;
    }

}

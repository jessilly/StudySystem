/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hbnu.study.dao;

import com.hbnu.study.bean.Grade;
import com.hbnu.study.dao.common.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class GradeDao {

    public int saveGrade(Grade gra) {
        Connection conn = DBUtils.getConn();
        int result = 0;
        String sql = "insert into GRADE(GRADE_NAME,SUBJECT,AMOUNT) VALUES(?,?,?)";
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, gra.getGradeName());
            pStatement.setString(2, gra.getSubject());
            pStatement.setInt(3, gra.getAmount());
            result = pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConn(conn);
        }
        return result;
    }

    public List<Grade> getGrade() {
        Connection conn = DBUtils.getConn();
        ResultSet rs = null;
        List<Grade> gras = new ArrayList<Grade>();
        String sql = "select * from GRADE ";
        try {

            PreparedStatement pStatement = conn.prepareStatement(sql);//预处理			
            rs = pStatement.executeQuery();	//执行	
            while (rs.next())//将查询的结果放在集合类中，只要有下一条数据就不断的执行
            {
                Grade s = new Grade();
                s.setId(rs.getInt(1));
                s.setGradeName(rs.getString(2));
                s.setSubject(rs.getString(3));
                s.setAmount(rs.getInt(4));
                gras.add(s);//每创建一个就放在对象中
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConn(conn);//数据库关闭
        }
        return gras;
    }

    public List<Grade> findGrade(Grade gra) {
        StringBuffer sql = new StringBuffer("select * from GRADE where subject=" + "'" + gra.getSubject() + "'");
        boolean ifand = false;
        Connection conn = DBUtils.getConn();
        ResultSet rs = null;
        List<Grade> gras = new ArrayList<Grade>();
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql.toString());
            rs = pStatement.executeQuery();
            while (rs.next()) {
                Grade s = new Grade();
                s.setId(rs.getInt(1));
                s.setSubject(rs.getString(2));
                s.setGradeName(rs.getString(3));
                s.setAmount(rs.getInt(4));
                gras.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConn(conn);
        }
        return gras;
    }

    public Grade getGraById(int id) {
        Connection conn = DBUtils.getConn();
        ResultSet rs = null;
        Grade s = null;
        String sql = "select * from GRADE where ID=?";
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, id);
            rs = pStatement.executeQuery();
            while (rs.next()) {
                s = new Grade();
                s.setId(rs.getInt(1));
                s.setGradeName(rs.getString(2));
                s.setSubject(rs.getString(3));
                s.setAmount(rs.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConn(conn);
        }

        return s;
    }

    public int updateGra(Grade gra) {
        Connection conn = DBUtils.getConn();
        int result = 0;
        String sql = "update GRADE set GRADE_NAME=?,SUBJECT=?,AMOUNT=? where id=?";
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, gra.getGradeName());
            pStatement.setString(2, gra.getSubject());
            pStatement.setInt(3, gra.getAmount());
            pStatement.setInt(4, gra.getId());
            result = pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConn(conn);
        }

        return result;
    }

    public int deleteGra(Grade gra) {
        Connection conn = DBUtils.getConn();
        int result = 0;
        String sql = "delete from GRADE where id=?";
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, gra.getId());
            result = pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConn(conn);
        }

        return result;
    }

}

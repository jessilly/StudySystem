package com.hbnu.study.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hbnu.study.bean.Teacher;
import com.hbnu.study.dao.common.DBUtils;
import java.util.ArrayList;
import java.util.List;

public class TeacherDao {

    public int saveTeacher(Teacher tea) {
        Connection conn = DBUtils.getConn();
        int result = 0;
        String sql = "insert into TEACHER(TEACHER_NO,PASSWORD,TEACHER_NAME,SEX,TYPE) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, tea.getTeacherNo());
            //默认初始密码为123456
            pStatement.setString(2, "123456");
            pStatement.setString(3, tea.getTeacherName());
            pStatement.setString(4, tea.getSex());
            pStatement.setString(5, tea.getType());
            result = pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConn(conn);
        }

        return result;
    }

    public List<Teacher> getTeacher() {
        //controller--service--dao通过三层调用写在此数据库操作类
        //创建数据库连接对象
        Connection conn = DBUtils.getConn();
        ResultSet rs = null;
        //集合类来保存student这种类型
        List<Teacher> teas = new ArrayList<Teacher>();
        String sql = "select * from TEACHER ";
        try {

            PreparedStatement pStatement = conn.prepareStatement(sql);//预处理			
            rs = pStatement.executeQuery();	//执行	
            while (rs.next())//将查询的结果放在集合类中，只要有下一条数据就不断的执行
            {
                Teacher s = new Teacher();//创建学生对象
                s.setId(rs.getInt(1));
                s.setTeacherNo(rs.getString(2));
                s.setPassword(rs.getString(3));
                s.setTeacherName(rs.getString(4));
                s.setSex(rs.getString(5));
                s.setType(rs.getString(6));
                teas.add(s);//每创建一个就放在对象中
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConn(conn);//数据库关闭
        }
        return teas;
    }

    public List<Teacher> findTeacher(Teacher tea) {
        StringBuffer sql = new StringBuffer("select * from TEACHER ");
        boolean ifand = false;
        if (!("".equals(tea.getType()))) {
            sql.append("where ");
        }

        if (!("".equals(tea.getType()))) {
            ifand = true;
            sql.append("TYPE ='" + tea.getType() + "'");
        }
        Connection conn = DBUtils.getConn();
        ResultSet rs = null;
        List<Teacher> teas = new ArrayList<Teacher>();
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql.toString());
            rs = pStatement.executeQuery();
            while (rs.next()) {
                Teacher s = new Teacher();
                s.setId(rs.getInt(1));
                s.setTeacherNo(rs.getString(2));
                s.setPassword(rs.getString(3));
                s.setTeacherName(rs.getString(4));
                s.setSex(rs.getString(5));
                s.setType(rs.getString(6));
                teas.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConn(conn);
        }

        return teas;
    }

    public Teacher getTeaById(int id) {
        Connection conn = DBUtils.getConn();
        ResultSet rs = null;
        Teacher s = null;
        String sql = "select * from TEACHER where ID=?";
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, id);
            rs = pStatement.executeQuery();
            while (rs.next()) {
                s = new Teacher();
                s.setId(rs.getInt(1));
                s.setTeacherNo(rs.getString(2));
                s.setPassword(rs.getString(3));
                s.setTeacherName(rs.getString(4));
                s.setSex(rs.getString(5));
                s.setType(rs.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConn(conn);
        }

        return s;
    }

    public int updateTea(Teacher tea) {
        Connection conn = DBUtils.getConn();
        int result = 0;
        String sql = "update TEACHER set TEACHER_NO=?,TEACHER_NAME=?,SEX=?,TYPE=? where id=?";
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, tea.getTeacherNo());
            pStatement.setString(2, tea.getTeacherName());
            pStatement.setString(3, tea.getSex());
            pStatement.setString(4, tea.getType());
            pStatement.setInt(5, tea.getId());
            result = pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConn(conn);
        }

        return result;
    }

    public int deleteTea(Teacher tea) {
        Connection conn = DBUtils.getConn();
        int result = 0;
        String sql = "delete from TEACHER where id=?";
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, tea.getId());
            result = pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConn(conn);
        }

        return result;
    }

}

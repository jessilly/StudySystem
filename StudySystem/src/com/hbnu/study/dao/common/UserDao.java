package com.hbnu.study.dao.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hbnu.study.bean.User;

public class UserDao {
	/**
     * 新增用户
     */
    public int addUser(User user) {
        Connection conn = DBUtils.getConn();
        int result = 0;
        String sql = "insert into user(username, password, role) VALUES(?,?,?)";
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, user.getUsername());
            pStatement.setString(2, user.getPassword());
            pStatement.setString(3, user.getRole());
            result = pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConn(conn);
        }
        return result;
    }

    /**
     * 更新用户
     */
    public int updateUser(User user) {
        Connection conn = DBUtils.getConn();
        int result = 0;
        String sql = "update user set username=?,password=?,role=? where username=?";
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, user.getUsername());
            pStatement.setString(2, user.getPassword());
            pStatement.setString(3, user.getRole());

            result = pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConn(conn);
        }
        return result;
    }

    /**
     * 删除用户
     */
    public int delUser(String username) {
        Connection conn = DBUtils.getConn();
        int result = 0;
        String sql = "delete from user where username=?";
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, username);
            result = pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConn(conn);
        }
        return result;
    }
}

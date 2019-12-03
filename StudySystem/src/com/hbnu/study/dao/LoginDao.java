package com.hbnu.study.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hbnu.study.bean.User;
import com.hbnu.study.dao.common.DBUtils;

public class LoginDao {
	public User selectForLogin(User user) {
        Connection conn = DBUtils.getConn();
        ResultSet rs = null;
        String sql = "select * from user where USERNAME=? and PASSWORD=? and ROLE=?";
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, user.getUsername());
            pStatement.setString(2, user.getPassword());
            pStatement.setString(3, user.getRole());
            rs = pStatement.executeQuery();
            if (rs.next()) {
                user.setRole( rs.getString("ROLE"));
            } else {
                return null;
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConn(conn);
        }
        return user;
    }
}

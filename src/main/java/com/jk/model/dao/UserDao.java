package com.jk.model.dao;

import com.jk.model.Db.DataBase;
import com.jk.model.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private final Connection con;
    public UserDao() {

        con = DataBase.getConnection();
    }

    private String selectSQL = "SELECT id, username, password FROM auth WHERE username=? and password=?";
    private String InsertSQL="INSERT INTO auth (username, password) VALUES (?, ?)";

    public User loginUser(String username, String password) throws SQLException {
        User user = null;
        try {
            PreparedStatement ps = con.prepareStatement(selectSQL);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(Integer.parseInt(rs.getString("id")));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User RegUser(String username, String password) throws SQLException {
        User user = null;
        try {
            System.out.println("jhayakrish");
            PreparedStatement ps = con.prepareStatement(InsertSQL);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(Integer.parseInt(rs.getString("id")));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}

package com.jk.model.dao;

import com.jk.model.Db.DataBase;
import com.jk.model.model.Todo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodoDao {
    private final Connection con;
    private final String SELECT_ALL = "SELECT id, todo, userId FROM todo WHERE userId=?";
    private final String SELECT_TODO = "SELECT id, todo, userId FROM todo WHERE id=?";
    private final String INSERT_TODO = "INSERT INTO todo (todo, userId) VALUES (?, ?);";
    private final String UPDATE_TODO = "UPDATE todo SET todo = ? WHERE id = ?;";
    private final String DELETE_TODO = "DELETE todo WHERE id=?;";

    public TodoDao() {
        con = DataBase.getConnection();
    }

    public List<Todo> selectAllTodos(int userId) {
        List<Todo> todos = new ArrayList<Todo>();
        try {
            PreparedStatement ps = con.prepareStatement(SELECT_ALL);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Todo todo = new Todo();
                todo.setId(Integer.parseInt(rs.getString("id")));
                todo.setTodo(rs.getString("todo"));
                todo.setUserId(rs.getInt("userId"));
                todos.add(todo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todos;
    }

    public void addTodo(String todo, int userId) {
        try {
            PreparedStatement ps = con.prepareStatement(INSERT_TODO);
            ps.setString(1, todo);
            ps.setInt(2, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTodo(int id) {
        try {
            PreparedStatement ps = con.prepareStatement(DELETE_TODO);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Todo getTodo(int id) {
        Todo todo = null;
        try {
            PreparedStatement ps = con.prepareStatement(SELECT_TODO);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                todo = new Todo();
                todo.setId(Integer.parseInt(rs.getString("id")));
                todo.setTodo(rs.getString("todo"));
                todo.setUserId(rs.getInt("userId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todo;
    }

    public void editTodo(String item, int id) {
        try {
            PreparedStatement ps = con.prepareStatement(DELETE_TODO);
            ps.setString(1, item);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

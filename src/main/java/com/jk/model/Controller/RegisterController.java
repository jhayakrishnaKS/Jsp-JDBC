package com.jk.model.Controller;

import com.jk.model.dao.UserDao;
import com.jk.model.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class RegisterController  extends HttpServlet {
    private UserDao userDao;
    public RegisterController() {
        userDao=new UserDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email=req.getParameter("username");
        String password=req.getParameter("password");
        userDao.register(email, password);
        RequestDispatcher rs = req.getRequestDispatcher("index.jsp");
        rs.forward(req, resp);
    }
}
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

public class RegisterController extends HttpServlet {
    private final UserDao userDao;

    public RegisterController() {
        userDao = new UserDao();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String cpassword = req.getParameter("cpassword");
        User RegInUser = null;
//        System.out.println("hellofs");
        try {
            RegInUser = userDao.RegUser(username, password);
            RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
            rd.forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (RegInUser != null) {
            RequestDispatcher rd = req.getRequestDispatcher("login");
            rd.forward(req, resp);
        } else {
            req.setAttribute("error", true);
            RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
            rd.forward(req, resp);
        }
    }
}


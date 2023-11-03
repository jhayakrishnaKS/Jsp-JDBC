package com.jk.model.Controller;

import com.jk.model.Db.DataBase;
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

public class AuthController extends HttpServlet {

    private final UserDao userDao;

    public AuthController() {
        userDao = new UserDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User loggedInUser = null;
        try {
            loggedInUser = userDao.loginUser(username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (loggedInUser != null) {
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("id", loggedInUser.getId());
            RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
            rd.forward(req, resp);
//            System.out.println("heyy");
        } else {
            req.setAttribute("error", true);
            RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
            rd.forward(req, resp);
        }
    }
}

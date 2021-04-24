package com.login.servlet;

import com.login.user.User;
import com.login.user.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (password == ""){
            req.setAttribute("inf", "注册输入的账号密码为空");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        }
        try {
            UserDao userDao = new UserDao();
            userDao.addUser(username, password);
        } catch (Exception e) {
            req.setAttribute("inf", "注册失败");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        }
        req.setAttribute("inf", "注册成功，请进行登录");
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
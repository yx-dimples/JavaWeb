package com.login.servlet;

import com.login.user.User;
import com.login.user.UserDao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        session.removeAttribute("code");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        System.out.println(username);


        UserDao dao = new UserDao();

        try {
            if (dao.queryByParams(user) !=null){
                req.setAttribute("username",username);
                req.getRequestDispatcher("welcome.jsp").forward(req, resp);
            }else{
                req.setAttribute("inf", "你的账号或密码错误，请确认账号密码登录");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        try {
//            if (dao.queryByParams(user) != null) {
//                req.setAttribute("username",name);
//               req.getRequestDispatcher("welcome.jsp").forward(req, resp);
//            }
//            else {
//                System.out.println("----------------");
//                resp.sendRedirect("/login.jsp");
//            }
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    }
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException{
        doPost(request, response);
    }
}
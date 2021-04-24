package org.s166.ums.controller;

import com.google.gson.Gson;
import org.s166.ums.commons.ResultDto;
import org.s166.ums.dao.UserDao;
import org.s166.ums.entity.User;
import org.s166.ums.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register.do")
public class RegisterServlet extends BaseServlet{
    //从客户端获取数据

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pass = req.getParameter("pass");
        String sex = req.getParameter("sex");
        int age = Integer.parseInt(req.getParameter("age"));

        User user = new User();
        user.setName(name);
        user.setPass(pass);
        user.setSex(sex);
        user.setAge(age);

        UserDao dao = new UserDaoImpl();
        int r = dao.add(user);

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();

        String json = null;
        if(r==1){
            ResultDto resultDto = successJson(null,200,"注册成功");
            json = new Gson().toJson(resultDto);
        }else{
            ResultDto resultDto = errorJson("注册失败");
            json = new Gson().toJson(resultDto);
        }

        out.print(json);
        out.flush();
        out.close();

    }
}

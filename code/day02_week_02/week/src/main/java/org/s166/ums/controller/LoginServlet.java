package org.s166.ums.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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

/**
 * 用户登录接口
 */
@WebServlet("/login.do")
public class LoginServlet extends BaseServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pass = req.getParameter("pass");

        UserDao dao = new UserDaoImpl();
        User user = dao.queryByLogin(name, pass);

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();

        String json = null;
        if(user!=null){
            //封装结果集到ResultDto对象中
            ResultDto resultDto = successJson(user,200,"登录成功");
            //日期格式处理
            json = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(resultDto);
        }else{
            ResultDto resultDto = errorJson("错误的账号或密码");
            json = new Gson().toJson(resultDto);
        }

        out.print(json);
        out.flush();
        out.close();
    }

}

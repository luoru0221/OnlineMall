package com.rul.mall.servlet.login;


import com.rul.mall.bean.User;
import com.rul.mall.dao.impl.UserDaoImpl;
import com.rul.mall.utils.Md5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String id = req.getParameter("username");
        String password = Md5.toMd5(req.getParameter("password"));

        //根据用户id查询用户所有信息
        User user = new UserDaoImpl().queryUserById(id);
        if (user != null && user.getPassword().equals(password)) {
            //用户存在并且账号密码正确
            int type = user.getType();
            HttpSession session = req.getSession();
            session.setAttribute("loginId", id);
            session.setAttribute("userType",type);
            if(type==0){
                //重定向到后台
                resp.sendRedirect("ordersManager");
            }else {
                //重定向到首页
                resp.sendRedirect("index.jsp");
            }
        } else {
            //用户名和账号不匹配，返回到登录界面，并提示用户
            req.setAttribute("prompt", "用户名或密码错误，请重新登录！");
            //请求转发到登录界面
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doGet(req, resp);
    }
}

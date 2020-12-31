package com.rul.mall.servlet.usercenter;


import com.rul.mall.bean.User;
import com.rul.mall.dao.impl.UserDaoImpl;
import com.rul.mall.utils.Md5;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/updatePwd")
public class UpdatePwd extends HttpServlet {
    private UserDaoImpl userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String userId = (String) req.getSession().getAttribute("loginId");
        String password = Md5.toMd5(req.getParameter("password"));
        User user = new User();
        user.setId(userId);
        user.setPassword(password);
        int num = userDao.updateUserPwd(user);
        boolean success = (num >= 1);
        try {
            PrintWriter writer = resp.getWriter();
            writer.print(success);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

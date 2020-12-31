package com.rul.mall.servlet.usercenter;


import com.rul.mall.bean.User;
import com.rul.mall.dao.impl.UserDaoImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/updateAddress")
public class UpdateAddress extends HttpServlet {
    private UserDaoImpl userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String loginId = (String) req.getSession().getAttribute("loginId");
        String recName = req.getParameter("recName");//收件人姓名
        String address = req.getParameter("address");
        User user = new User();
        user.setId(loginId);
        user.setRecName(recName);
        user.setAddress(address);
        int change = userDao.updateUserAddress(user);
        boolean success = (change > 0);
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

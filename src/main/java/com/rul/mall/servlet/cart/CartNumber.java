package com.rul.mall.servlet.cart;


import com.rul.mall.dao.impl.CartDaoImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cartNumber")
public class CartNumber extends HttpServlet {

    private CartDaoImpl cartDao = new CartDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        String userId = (String)session.getAttribute("loginId");
        int number = cartDao.selectCartNumber(userId);
        PrintWriter writer = resp.getWriter();
        writer.print(number);
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.doGet(req,resp);
    }
}

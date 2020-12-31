package com.rul.mall.servlet.cart;


import com.rul.mall.bean.Cart;
import com.rul.mall.dao.impl.CartDaoImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteCart")
public class DeleteCart extends HttpServlet {
    private CartDaoImpl cartDao = new CartDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String uid = (String)req.getSession().getAttribute("loginId");
        String pid = req.getParameter("pid");
        Cart cart = new Cart();
        cart.setUid(uid);
        cart.setPid(Integer.parseInt(pid));
        cartDao.deleteCart(cart);
        PrintWriter writer = resp.getWriter();
        writer.print(true);
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.doGet(req,resp);
    }
}

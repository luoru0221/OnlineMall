package com.rul.mall.servlet.cart;


import com.rul.mall.bean.Product;
import com.rul.mall.dao.impl.CartDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/cartLoad")
public class CartLoad extends HttpServlet {
    private CartDaoImpl cartDao = new CartDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        ArrayList<Product> productCart = cartDao.selectCartByUserId(userId);
        req.setAttribute("productCart", productCart);
        req.getRequestDispatcher("cart.jsp").forward(req, resp);//请求转发到购物车
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

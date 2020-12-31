package com.rul.mall.servlet.order;


import com.rul.mall.bean.OrderItem;
import com.rul.mall.dao.impl.OrderItemDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/orderList")
public class OrderListLoad extends HttpServlet {

    private OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = (String)req.getSession().getAttribute("loginId");
        HashMap<String, ArrayList<OrderItem>> orders = orderItemDao.selectAllOrdersByUserId(userId);

        req.setAttribute("orders",orders);
        req.getRequestDispatcher("orderlist.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}

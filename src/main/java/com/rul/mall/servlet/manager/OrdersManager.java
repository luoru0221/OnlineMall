package com.rul.mall.servlet.manager;


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

@WebServlet("/ordersManager")
public class OrdersManager extends HttpServlet {
    private OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HashMap<String, ArrayList<OrderItem>> orders = orderItemDao.selectAllOrder();  //查询到所有的订单
        req.setAttribute("orders", orders);

        HashMap<String, String> orderTypes = new HashMap<>();
        for (String orderId : orders.keySet()) {
            orderTypes.put(orderId, "订单已完成");
            ArrayList<OrderItem> orderItems = orders.get(orderId);
            for (OrderItem orderItem : orderItems) {
                if (orderItem.getType() != 4) {
                    orderTypes.put(orderId, "订单未完成");
                    break;
                }
            }
        }
        req.setAttribute("orderTypes", orderTypes);  //订单状态
        req.getRequestDispatcher("orders_manager.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

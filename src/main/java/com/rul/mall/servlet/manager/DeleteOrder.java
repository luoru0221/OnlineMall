package com.rul.mall.servlet.manager;


import com.rul.mall.bean.OrderItem;
import com.rul.mall.dao.impl.OrderDaoImpl;
import com.rul.mall.dao.impl.OrderItemDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteOrder")
public class DeleteOrder extends HttpServlet {
    private OrderDaoImpl orderDao = new OrderDaoImpl();
    private OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        int changeNumber = orderDao.deleteOrder(orderId);

        OrderItem orderItem = new OrderItem();
        orderItem.setOid(orderId);
        int changeNum = orderItemDao.delateOrderItem(orderItem);

        PrintWriter writer = resp.getWriter();
        if (changeNumber > 0 || changeNum > 0) {
            writer.print(true);
            writer.flush();
        }
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

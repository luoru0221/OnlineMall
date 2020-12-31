package com.rul.mall.servlet.merchan;


import com.rul.mall.bean.OrderItem;
import com.rul.mall.dao.impl.OrderItemDaoImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sendProduct")
public class SendProduct extends HttpServlet {
    private OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String orderId = req.getParameter("orderId");
        int productId = Integer.parseInt(req.getParameter("productId"));
        OrderItem orderItem = new OrderItem();
        orderItem.setOid(orderId);
        orderItem.setPid(productId);
        orderItem.setType(2);
        orderItemDao.updateOrderItemType(orderItem);

        PrintWriter writer = resp.getWriter();
        writer.print(true);
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.doGet(req, resp);
    }
}

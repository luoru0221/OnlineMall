package com.rul.mall.servlet.order;


import com.rul.mall.bean.OrderItem;
import com.rul.mall.dao.impl.OrderItemDaoImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/payOrderItem")
public class PayOrderItem extends HttpServlet {
    private OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String oid = req.getParameter("oid");
        int pid = Integer.parseInt(req.getParameter("pid"));
        OrderItem orderItem = new OrderItem();
        orderItem.setOid(oid);
        orderItem.setPid(pid);
        orderItem.setType(1); //状态改为1，已支付
        int changeNum = orderItemDao.updateOrderItemType(orderItem);
        PrintWriter writer = resp.getWriter();
        writer.print(changeNum>0);
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.doGet(req, resp);
    }
}

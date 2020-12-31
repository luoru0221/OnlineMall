package com.rul.mall.servlet.order;


import com.rul.mall.bean.Evaluate;
import com.rul.mall.bean.OrderItem;
import com.rul.mall.dao.impl.EvaluateDaoImpl;
import com.rul.mall.dao.impl.OrderItemDaoImpl;
import com.rul.mall.utils.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/commentOrder")
public class CommentOrder extends HttpServlet {
    private EvaluateDaoImpl evaluateDao = new EvaluateDaoImpl();
    private OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pid = Integer.parseInt(req.getParameter("pid"));  //商品id
        String uid = (String) req.getSession().getAttribute("loginId");  //用户Id
        String content = req.getParameter("content");   //评价内容
        String orderId = req.getParameter("orderId");
        String time = LocalTime.getStringDate();  //评价时间
        Evaluate evaluate = new Evaluate();
        evaluate.setPid(pid);
        evaluate.setUid(uid);
        evaluate.setContent(content);
        evaluate.setTime(time);

        OrderItem orderItem = new OrderItem();
        orderItem.setType(4);
        orderItem.setOid(orderId);
        orderItem.setPid(pid);

        int changeNumber = evaluateDao.addEvaluateForProduct(evaluate);
        orderItemDao.updateOrderItemType(orderItem);
        PrintWriter writer = resp.getWriter();
        if (changeNumber > 0) {
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

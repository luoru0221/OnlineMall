package com.rul.mall.servlet.order;


import com.rul.mall.bean.Product;
import com.rul.mall.bean.User;
import com.rul.mall.dao.impl.CartDaoImpl;
import com.rul.mall.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet("/orderLoad")
public class OrderLoad extends HttpServlet {
    private CartDaoImpl cartDao = new CartDaoImpl();
    private UserDaoImpl userDao = new UserDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = (String) req.getSession().getAttribute("loginId");
        ArrayList<Product> products = cartDao.selectToOrderCart(userId);
        User user = userDao.queryUserById(userId);
        req.setAttribute("loginUser",user);
        req.setAttribute("products", products);
        req.setAttribute("totalPrice",getTotalPrice(products));
        req.getRequestDispatcher("order.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    /**
     * 计算商品总价
     * @param products 待计算的Product的ArrayList集合
     * @return 商品总价
     */
    private double getTotalPrice(ArrayList<Product> products){
        double sum = 0;
        for (Product product : products) {
            sum+=product.getPrice()*product.getNumber();
        }
        return sum;
    }
}

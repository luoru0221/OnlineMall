package com.rul.mall.servlet.cart;


import com.rul.mall.bean.Cart;
import com.rul.mall.dao.impl.CartDaoImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 添加商品到购物车
 *
 * @author LuoRu
 */
@WebServlet("/addToCart")
public class AddToCart extends HttpServlet {

    private CartDaoImpl cartDao = new CartDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        //用户ID
        String userId = req.getParameter("userId");
        //商品ID
        int productId = Integer.parseInt(req.getParameter("productId"));
        //商品数量
        int number = Integer.parseInt(req.getParameter("number"));
        boolean isNewCart = addToCart(userId, productId, number);
        try {
            PrintWriter writer = resp.getWriter();
            writer.print(isNewCart);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        this.doGet(req, resp);
    }

    /**
     * 将购物车插入数据库
     *
     * @param uid    用户ID
     * @param pid    商品ID
     * @param number 商品数量
     * @return 是否为新的购物车，即购物车中已存在相同商品时返回false，否则返回true
     */
    private boolean addToCart(String uid, int pid, int number) {
        Cart cart = new Cart();
        cart.setUid(uid);
        cart.setPid(pid);
        cart.setNumber(number);
        cart.setType(0);
        return cartDao.addCart(cart);
    }

}

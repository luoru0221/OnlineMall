package com.rul.mall.servlet.cart;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rul.mall.bean.Cart;
import com.rul.mall.dao.impl.CartDaoImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/updateCart")
public class UpdateCart extends HttpServlet {
    private CartDaoImpl cartDao = new CartDaoImpl();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        String uid = (String) req.getSession().getAttribute("loginId");
        String jsonCarts = req.getParameter("carts");
        JSONArray jsonArray = JSONArray.parseArray(jsonCarts);
        ArrayList<Cart> carts = new ArrayList<>();
        Cart cart;
        for (Object object : jsonArray) {
            cart = new Cart();
            JSONObject jsonCart = (JSONObject) object;
            int pid = jsonCart.getIntValue("pid");
            int number = jsonCart.getIntValue("number");
            cart.setPid(pid);
            cart.setNumber(number);
            cart.setUid(uid);
            cart.setType(1); //设置购物车状态
            carts.add(cart);
        }
        int num = 0; //影响的数据条数
        for (Cart cartItem : carts) {
            num += cartDao.updateCart(cartItem);
        }
        if (num == carts.size()) {
            try {
                PrintWriter writer = resp.getWriter();
                writer.print(true);
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        this.doPost(req, resp);
    }
}

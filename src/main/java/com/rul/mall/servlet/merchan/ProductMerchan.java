package com.rul.mall.servlet.merchan;


import com.rul.mall.bean.Product;
import com.rul.mall.dao.impl.ProductDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/productMerchan")
public class ProductMerchan extends HttpServlet {
    private ProductDaoImpl productDao = new ProductDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String store = (String) req.getSession().getAttribute("loginId");
        ArrayList<Product> products = productDao.queryProductByStore(store);
        req.setAttribute("products", products);
        req.getRequestDispatcher("product_merchan.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

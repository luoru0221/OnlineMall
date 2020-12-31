package com.rul.mall.servlet.product;

import com.alibaba.fastjson.JSONObject;
import com.rul.mall.bean.Product;
import com.rul.mall.dao.impl.ProductDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/searchProductPage")
public class SearchProductPage extends HttpServlet {
    private ProductDaoImpl productDao = new ProductDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        int pageCode = Integer.parseInt(req.getParameter("pageCode"));
        ArrayList<Product> products = productDao.selectLikeProductLimit(keyword, (pageCode - 1) * 15, 15);
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String JSONString = JSONObject.toJSONString(products);

        PrintWriter writer = resp.getWriter();
        writer.print(JSONString);
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

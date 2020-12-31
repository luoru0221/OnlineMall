package com.rul.mall.servlet.onload;


import com.rul.mall.bean.Product;
import com.rul.mall.dao.impl.ProductDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/searchProduct")
public class SearchProduct extends HttpServlet {
    private ProductDaoImpl productDao = new ProductDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        ArrayList<Product> products = productDao.selectLikeProduct(keyword);
        int pageSize;
        if (products.size() % 15 == 0) {
            pageSize = products.size() / 15;
        } else {
            pageSize = products.size() / 15+1;
        }
        ArrayList<String> pages = new ArrayList<>();
        for (int i = 1; i <= pageSize; i++) {
            pages.add(i + "");
        }
        req.getSession().setAttribute("keyword",keyword);
        req.getSession().setAttribute("nowPage","1");
        req.getSession().setAttribute("pages", pages);
        resp.sendRedirect("list.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

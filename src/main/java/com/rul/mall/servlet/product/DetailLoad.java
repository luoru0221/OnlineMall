package com.rul.mall.servlet.product;


import com.rul.mall.bean.Evaluate;
import com.rul.mall.bean.Product;
import com.rul.mall.dao.impl.EvaluateDaoImpl;
import com.rul.mall.dao.impl.ProductDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/detailLoad")
public class DetailLoad extends HttpServlet {
    private ProductDaoImpl productDao = new ProductDaoImpl();
    private EvaluateDaoImpl evaluateDao = new EvaluateDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("productId"));
        Product product = productDao.queryProductById(id);
        ArrayList<Evaluate> evaluates = evaluateDao.selectEvaluatesByPid(id);
        req.setAttribute("product",product);
        req.setAttribute("evaluates",evaluates);
        //请求转发到商品详情页
        req.getRequestDispatcher("detail.jsp?productId="+id).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}

package com.rul.mall.servlet.product;


import com.rul.mall.bean.Product;
import com.rul.mall.dao.impl.ProductDaoImpl;
import com.rul.mall.utils.ImageUpload;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addProduct")
public class AddProduct extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String fileName = ImageUpload.upLoadImg(req);
        try {
            PrintWriter writer = resp.getWriter();
            writer.print(fileName);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        addProduct(req);
    }

    /**
     * 保存基本信息以及分类信息到数据库
     */
    private void addProduct(HttpServletRequest req) {

        String store = (String)req.getSession().getAttribute("loginId");
        String pName = req.getParameter("pName");   //商品名字
        String pDescription = req.getParameter("pDescription"); //商品描述
        double pPrice = Double.parseDouble(req.getParameter("pPrice")); //商品价格
        int pType = Integer.parseInt(req.getParameter("pType"));    //商品分类
        String pImage = req.getParameter("pImage");

        Product product = new Product();
        product.setStore(store);
        product.setName(pName);
        product.setDescription(pDescription);
        product.setPrice(pPrice);
        product.setImage(pImage);
        product.setType(pType);

        saveData(product);
    }

    /**
     * 将数据保存到数据库
     */
    private void saveData(Product product) {
        ProductDaoImpl productDao = new ProductDaoImpl();
        productDao.addProduct(product);
    }
}



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

@WebServlet("/updateProduct")
public class UpdateProduct extends HttpServlet {
    private ProductDaoImpl productDao = new ProductDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int productId = Integer.parseInt(req.getParameter("productId"));
        String productName = req.getParameter("productName");
        String productDescription = req.getParameter("productDescription");
        double productPrice = Double.parseDouble(req.getParameter("productPrice"));
        String productImage = req.getParameter("productImage");
        int productType = Integer.parseInt(req.getParameter("productType"));

        Product product = new Product();
        product.setId(productId);
        product.setName(productName);
        product.setDescription(productDescription);
        product.setPrice(productPrice);
        product.setImage(productImage);
        product.setType(productType);
        productDao.updateProduct(product);

        PrintWriter writer = resp.getWriter();
        writer.print(true);
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String imageAddress = ImageUpload.upLoadImg(req);
        PrintWriter writer = resp.getWriter();
        writer.print(imageAddress);
        writer.flush();
        writer.close();
    }
}

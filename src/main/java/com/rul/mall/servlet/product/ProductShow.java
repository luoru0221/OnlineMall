package com.rul.mall.servlet.product;


import com.rul.mall.bean.Product;
import com.rul.mall.bean.Type;
import com.rul.mall.dao.impl.ProductDaoImpl;
import com.rul.mall.dao.impl.TypeDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/productShow")
public class ProductShow extends HttpServlet {
    private ProductDaoImpl productDao = new ProductDaoImpl();
    private TypeDaoImpl typeDao = new TypeDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String typeid = req.getParameter("typeId");
        int typeId = -1;
        if(typeid!=null&&!typeid.equals("")){
            typeId = Integer.parseInt(typeid);
        }
        ArrayList<Product> products = productDao.queryProductByType(typeId);
        int pageNumber;
        if(products.size()%15==0){
            pageNumber = products.size()/15;
        }else{
            pageNumber = products.size()/15+1;
        }
        ArrayList<String> pageCodes = new ArrayList<>();
        for(int i =1;i<=pageNumber;i++){
            pageCodes.add(i+"");
        }
        Type fatherType = typeDao.selectFatherType(typeId);
        ArrayList<Type> slibingTypes = typeDao.selectSlibingTypes(typeId);
        req.getSession().setAttribute("pageCodes",pageCodes);
        req.getSession().setAttribute("slibingTypes",slibingTypes);
        req.getSession().setAttribute("fatherType",fatherType);
        req.getSession().setAttribute("nowType",typeId);  //当前分类
        resp.sendRedirect("moreproduct.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

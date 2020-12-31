package com.rul.mall.servlet.onload;

import com.alibaba.fastjson.JSONObject;
import com.rul.mall.bean.Product;
import com.rul.mall.dao.impl.ProductDaoImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/indexServlet")
public class Index extends HttpServlet {
    private ProductDaoImpl productDao = new ProductDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        ArrayList<ArrayList<Product>> arrayLists = queryLists(); //商品分类后的集合
        //集合转化为JSON字符串
        String jsonLists = JSONObject.toJSONString(arrayLists);
        try {
            req.setCharacterEncoding("utf-8");
            resp.setContentType("text/html;charset=utf-8"); //设置编码格式，避免中文乱码
            PrintWriter writer = resp.getWriter(); //获取响应输出流
            writer.println(jsonLists); //输出JSON数据
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
     * 对商品进行分类，共6类
     */
    private ArrayList<ArrayList<Product>> queryLists() {
        ArrayList<ArrayList<Product>> arrayLists = new ArrayList<>();
        int[] recommend = {110,111,115,116,119,122};
        ArrayList<Product> arrayList;
        for (int i = 0; i < 6; i++) {
            arrayList = productDao.queryProductByType(recommend[i]);
            arrayLists.add(arrayList);
        }
        return arrayLists;
    }
}

package com.rul.mall.servlet.manager;

import com.alibaba.fastjson.JSONObject;
import com.rul.mall.bean.Type;
import com.rul.mall.dao.impl.TypeDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/selectInitTypes")
public class SelectInitTypes extends HttpServlet {
    private TypeDaoImpl typeDao = new TypeDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Type> types1 = typeDao.selectChildrenTypes(0);  //一级分类
        ArrayList<Type> types2 = typeDao.selectChildrenTypes(types1.get(0).getId());  //二级分类
        ArrayList<Type> types3 = typeDao.selectChildrenTypes(types2.get(0).getId());  //三级分类
        ArrayList<ArrayList<Type>> types = new ArrayList<>();
        types.add(types1);
        types.add(types2);
        types.add(types3);
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8"); //设置编码格式，避免中文乱码
        String JSONString = JSONObject.toJSONString(types);
        PrintWriter writer = resp.getWriter();
        writer.println(JSONString);
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

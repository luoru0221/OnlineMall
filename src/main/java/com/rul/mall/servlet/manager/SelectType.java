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

@WebServlet("/selectType")
public class SelectType extends HttpServlet {
    private TypeDaoImpl typeDao = new TypeDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int fId = Integer.parseInt(req.getParameter("fId"));
        ArrayList<Type> types = typeDao.selectChildrenTypes(fId);
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8"); //设置编码格式，避免中文乱码
        String JSONString = JSONObject.toJSONString(types);
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

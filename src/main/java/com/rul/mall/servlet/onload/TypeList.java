package com.rul.mall.servlet.onload;

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

@WebServlet("/typeList")
public class TypeList extends HttpServlet {
    private TypeDaoImpl typeDao = new TypeDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Type> firstTypes = typeDao.selectChildrenTypes(0);
        for (Type firstType : firstTypes) {
            ArrayList<Type> secondTypes = typeDao.selectChildrenTypes(firstType.getId());
            firstType.setcTypes(secondTypes);
            for (Type secondType : secondTypes) {
                ArrayList<Type> thirdTypes = typeDao.selectChildrenTypes(secondType.getId());
                secondType.setcTypes(thirdTypes);
            }
        }
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String JSONString = JSONObject.toJSONString(firstTypes);
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

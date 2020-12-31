package com.rul.mall.servlet.merchan;

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

@WebServlet("/initAllTypes")
public class InitAllTypes extends HttpServlet {
    private TypeDaoImpl typeDao = new TypeDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Type> type1 = typeDao.selectChildrenTypes(0);
        ArrayList<Type> type2 = typeDao.selectChildrenTypes(type1.get(0).getId());
        ArrayList<Type> type3 = typeDao.selectChildrenTypes(type2.get(0).getId());
        ArrayList<ArrayList<Type>> allTypes = new ArrayList<>();
        allTypes.add(type1);
        allTypes.add(type2);
        allTypes.add(type3);
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String JSONString = JSONObject.toJSONString(allTypes);
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

package com.rul.mall.servlet.manager;


import com.rul.mall.bean.Type;
import com.rul.mall.dao.impl.TypeDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/updateType")
public class UpdateType extends HttpServlet {
    private TypeDaoImpl typeDao = new TypeDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int typeId = Integer.parseInt(req.getParameter("typeId"));
        String typeName = req.getParameter("typeName");
        Type type = new Type();
        type.setId(typeId);
        type.setName(typeName);
        typeDao.updateTypeName(type);

        PrintWriter writer = resp.getWriter();
        writer.print(true);
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

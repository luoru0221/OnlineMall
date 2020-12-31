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

@WebServlet("/addType")
public class AddType extends HttpServlet {
    private TypeDaoImpl typeDao = new TypeDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int fid = Integer.parseInt(req.getParameter("fid"));
        String name = req.getParameter("name");
        Type type = new Type();
        type.setFid(fid);
        type.setName(name);
        typeDao.addType(type);
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

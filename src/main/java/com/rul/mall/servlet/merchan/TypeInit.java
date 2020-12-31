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
import java.util.Collections;

@WebServlet("/typeInit")
public class TypeInit extends HttpServlet {
    private TypeDaoImpl typeDao = new TypeDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String typeId = req.getParameter("typeId");

        int thirdId = Integer.parseInt(typeId);
        ArrayList<Type> thirdTypes = typeDao.selectSlibingTypes(thirdId);
        int index = 0;
        for (int i = 0; i < thirdTypes.size(); i++) {
            if (thirdTypes.get(i).getId() == thirdId) {
                index = i;
                break;
            }
        }
        Collections.swap(thirdTypes,0,index);

        int secondId = thirdTypes.get(0).getFid();
        ArrayList<Type> secondTypes = typeDao.selectSlibingTypes(secondId);
        index = 0;
        for (int i = 0; i < secondTypes.size(); i++) {
            if (secondTypes.get(i).getId() == secondId) {
                index = i;
                break;
            }
        }
        Collections.swap(secondTypes,0,index);

        int firstId = secondTypes.get(0).getFid();
        ArrayList<Type> firstTypes = typeDao.selectSlibingTypes(firstId);
        index = 0;
        for (int i = 0; i < firstTypes.size(); i++) {
            if (firstTypes.get(i).getId() == firstId) {
                index = i;
                break;
            }
        }
        Collections.swap(firstTypes,0,index);

        ArrayList<ArrayList<Type>> allTypes = new ArrayList<>();
        allTypes.add(firstTypes);
        allTypes.add(secondTypes);
        allTypes.add(thirdTypes);

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

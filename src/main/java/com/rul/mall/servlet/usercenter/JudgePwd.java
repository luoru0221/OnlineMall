package com.rul.mall.servlet.usercenter;


import com.rul.mall.bean.User;
import com.rul.mall.dao.impl.UserDaoImpl;
import com.rul.mall.utils.Md5;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 用户中心修改个人资料验证用户的初始密码是否正确
 */
@WebServlet("/judgePwd")
public class JudgePwd extends HttpServlet {
    private UserDaoImpl userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userId = (String)req.getSession().getAttribute("loginId");
        String oldPwd = Md5.toMd5(req.getParameter("oldPwd"));
        System.out.println(oldPwd);
        User user = userDao.queryUserById(userId);
        boolean pwdTrue = false;
        if (user != null && user.getPassword().equals(oldPwd)) {
            pwdTrue = true;
            System.out.println(user.getPassword());
        }
        PrintWriter writer = resp.getWriter();
        writer.print(pwdTrue);
        writer.flush();
        writer.close();
    }
}

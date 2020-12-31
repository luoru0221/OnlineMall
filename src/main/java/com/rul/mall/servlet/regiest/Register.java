package com.rul.mall.servlet.regiest;


import com.rul.mall.bean.User;
import com.rul.mall.dao.impl.UserDaoImpl;
import com.rul.mall.utils.Md5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

/**
 * 注册
 */
@WebServlet("/register")
public class Register extends HttpServlet {
    private UserDaoImpl userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8"); //设置编码格式，避免中文乱码
        String msgCode = req.getParameter("msg_code"); //用户输入的验证码
        String emailCode = null; //从Cookie中取出验证码

        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if ("EmailCode".equals(cookie.getName())) {
                emailCode = cookie.getValue();
                break;
            }
        }

        if (emailCode != null && emailCode.equals(msgCode)) {
            User newUser = this.getNewUser(req);
            if (userDao.addUser(newUser) > 0) {
                //注册成功，跳转至登录界面
                req.setAttribute("newUserId",newUser.getId());
                req.getRequestDispatcher("login.jsp").forward(req,resp);
            } else {
                req.setAttribute("log","注册失败，请稍后重试！");
                req.getRequestDispatcher("register.jsp").forward(req,resp);
            }
        } else {
            req.setAttribute("log","验证码错误");
            req.getRequestDispatcher("register.jsp").forward(req,resp);
        }

    }

    /**
     * 根据请求判断用户的验证码是否正确
     * 正确则返回一个User对象，否则提示用户验证码错误
     */
    private User getNewUser(HttpServletRequest req) {
        String name = req.getParameter("user_name"); //用户名
        String password = Md5.toMd5(req.getParameter("pwd"));  //密码
        String email = req.getParameter("email");   //邮箱
        String newId; //新的账号

        User user;
        do {
            //生成新的账号
            newId = this.getNewId();
            user = userDao.queryUserById(newId);
        } while (user != null);

        return new User(newId, name, password, email); //新的用户
    }

    /**
     * 生成新的用户id，id由小写字母和数字构成
     */
    private String getNewId() {
        char[] tmp = new char[40];
        for (int i = 0; i < 26; i++) {
            tmp[i] = (char) ('a' + i);
        }
        for (int i = 26; i < 36; i++) {
            tmp[i] = (char) ('0' + i - 26);
        }
        Random random = new Random();
        int number;
        char[] newId = new char[10];
        for (int i = 0; i < 6; i++) {
            number = random.nextInt(36);
            newId[i] = tmp[number];
        }
        return new String(newId);
    }
}

package com.rul.mall.servlet.usercenter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/judgeCode")
public class JudgeCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String code = req.getParameter("emailCode");//获取请求参数中的验证码

        String emailCode = null; //保存在cookie中的验证码
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if ("EmailCode".equals(cookie.getName())) {
                emailCode = cookie.getValue();
                break;
            }
        }
        boolean isTrue = false;  //验证码是否正确的标志
        if (code != null && code.equals(emailCode)) {
            isTrue = true;
        }
        try {
            PrintWriter writer = resp.getWriter();
            writer.print(isTrue);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.rul.mall.servlet.regiest;


import com.rul.mall.utils.SendMail;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

/**
 * 发送邮箱验证码
 */

@WebServlet("/sendEmailCode")
public class SendEmailCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        send(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        this.doGet(req, resp);
    }

    private void send(HttpServletRequest req, HttpServletResponse resp) {

        String address = req.getParameter("address");//用户输入的邮箱地址
        String code = getCode();//生成的验证码

        SendMail sendMail = new SendMail(address);
        sendMail.setTitle("【1号店】");
        sendMail.setContent("您本次的验证码为：" + code + ",十分钟内输入有效。若非本人操作，请忽略");
        try {
            //发送验证码
            sendMail.sendMessage();
            //将验证码存入Cookie中
            Cookie emailCode = new Cookie("EmailCode", code);
            emailCode.setMaxAge(10*60); //设置cookie最大存活时间10分钟
            resp.addCookie(emailCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //随机生成4位数验证码
    private String getCode() {
        int code = new Random().nextInt(9000) + 1000;
        return code + "";
    }
}

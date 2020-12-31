<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>1号店-注册</title>
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/register.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="js/register.js"></script>
</head>
<body>
<div class="register_con">
    <div class="l_con fl">
        <a class="reg_logo"><img src="images/logo03.png" alt="logo"></a>
    </div>

    <div class="r_con fr">
        <div class="reg_title priority">
            <h1>用户注册</h1>
            <a href="login.jsp">登录</a>
        </div>
        <div class="reg_form priority" id="app" >
            <form action="register" method="post">
                <ul>
                    <li>
                        <label for="user_name">用户名:</label>
                        <input type="text" name="user_name" id="user_name">
                        <span class="error_tip">请输入1-20个字符的用户名</span>
                    </li>
                    <li>
                        <label for="pwd">密码:</label>
                        <input type="password" name="pwd" id="pwd">
                        <span class="error_tip">密码最少8位，最长20位</span>
                    </li>
                    <li>
                        <label for="cpwd">确认密码:</label>
                        <input type="password" name="cpwd" id="cpwd">
                        <span class="error_tip">两次输入的密码不一致</span>
                    </li>
                    <li>
                        <label for="email">邮箱:</label>
                        <input type="text" name="email" id="email">
                        <span class="error_tip">您输入的邮箱格式不正确</span>
                    </li>
                    <li>
                        <label for="msg_code">邮箱验证码:</label>
                        <input type="text" name="msg_code" id="msg_code" class="msg_input">
                        <button class="get_msg_code" id="get_msg_code" onclick="sendMCode();">获取验证码</button>
                        <span class="error_tip">请正确填写邮箱验证码</span>
                    </li>
                    <li class="agreement">
                        <input type="checkbox" name="allow" id="allow" checked="checked">
                        <label for="allow">同意”Mall用户使用协议“</label>
                        <span class="error_tip2">请勾选同意</span>
                    </li>
                    <li class="reg_sub">
                        <input type="submit" value="注 册" name="">
                    </li>
                </ul>
            </form>
        </div>
    </div>
</div>

<div class="footer no-mp">
    <div class="foot_link">
        <a href="#">关于我们</a>
        <span>|</span>
        <a href="#">联系我们</a>
        <span>|</span>
        <a href="#">招聘人才</a>
        <span>|</span>
        <a href="#">友情链接</a>
    </div>
    <p>CopyRight © 2020 吉首大学CCW</p>
    <p>电话：0730-****888 湘ICP备*******8号</p>
</div>

</body>
</html>
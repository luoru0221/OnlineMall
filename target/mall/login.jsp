<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="fun" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>1号店-登录</title>
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
    <script src="js/login.js" type="text/javascript"></script>
</head>


<body>
<!--顶部空白区域-->
<div class="login_top priority"></div>

<!--中间登录部分-->
<div class="login_form_bg">
    <div class="login_form_wrap priority">
        <div class="login_image fl"></div>
        <div class="login_form fr">
            <div class="login_title priority">
                <a href="javascript:" class="cur">账户登录</a>
            </div>
            <div class="form_con">
                <div class="form_input cur">
                    <form action="login" method="post">
                        <label id="userId" userid=${requestScope.newUserId}>
                            <input class="name_input" name="username" placeholder="请输入用户名" type="text"
                                   value="">
                        </label>
                        <div class="user_error"></div>
                        <label>
                            <input type="password" name="password" class="pass_input" placeholder="请输入密码">
                        </label>
                        <div class="pwd_error"></div>
                        <div class="more_input priority">
                            <a href="">忘记密码</a>
                        </div>
                        <input type="submit" name="" value="登 录" class="input_submit">
                    </form>
                </div>
            </div>
            <div class="third_party">
                <label id="prompt">${requestScope.prompt}</label>
                <a href="register.jsp" class="register_btn">立即注册</a>
            </div>

        </div>
    </div>
</div>

<!--底部-->
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
    <p>QQ：331980169 湘ICP备*******8号</p>
</div>

</body>
</html>
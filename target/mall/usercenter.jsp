<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/usercenter.css">
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="js/usercenter.js"></script>
</head>
<body>
<div class="header_con">
    <div class="header">
        <div class="welcome fl">欢迎来到1号店！</div>
        <c:if test="${sessionScope.userType == '1'}">
            <div class="welcome fl"><a href="ordersMerchan">我的店铺</a></div>
        </c:if>
        <c:if test="${sessionScope.userType == '2'}">
            <div class="welcome fl"><a href="javascript:">免费申请开店</a></div>
        </c:if>
        <div class="fr">
            <div class="login_btn fl">
                <c:if test="${sessionScope.loginId == null}">
                    <a href="login.jsp">登录</a>
                    <span>|</span>
                    <a href="register.jsp">注册</a>
                </c:if>
                <c:if test="${sessionScope.loginId != null}">
                    <a href="usercenter.jsp">欢迎${sessionScope.loginId}</a>
                    <span>|</span>
                    <a href="exitLogin">退出登录</a>
                </c:if>
            </div>
            <div class="user_link fl">
                <c:if test="${sessionScope.loginId != null}">
                    <span>|</span>
                    <a href="usercenter.jsp">用户中心</a>
                    <span>|</span>
                    <a href="cartLoad?userId=${sessionScope.loginId}">我的购物车</a>
                    <span>|</span>
                    <a href="orderList">我的订单</a>
                </c:if>
            </div>
        </div>
    </div>
</div>
<div class="user_header">
    <div class="wrap">
        <a href="" class="wrap_logo">
            <img src="images/logo04.png" alt="">
        </a>
    </div>
</div>
<div class="main_con priority">
    <div class="left_menu priority">
        <h3>个人中心</h3>
        <ul id="menu">
            <li class="nav_item active">个人信息</li>
            <li class="nav_item">收货地址</li>
            <li class="nav_item">修改密码</li>
        </ul>
    </div>

    <div class="right_content priority con_active">
        <!--用户个人信息-->
        <div class="content user_information priority con_active">
            <h3 class="content_title">个人信息</h3>
            <ul class="inf_con">
                <li><label>ID:</label><b id="uId"></b></li>
                <li><label>用户名:</label><b id="uName"></b></li>
                <li><label>email:</label><b id="uEmail"></b></li>
                <li><label>收件人姓名:</label><b id="recName"></b></li>
                <li><label>收货地址:</label><b id="uAddress"></b></li>
            </ul>
        </div>

        <!--收货地址-->
        <div class="content priority">
            <h3 class="content_title">收货地址</h3>
            <div class="address_con">
                <div style="width: 505px;margin: 10px auto" class="priority">
                    <label for="recipient" class="fl">收件人姓名：</label>
                    <div class="recipient fr">
                        <input id="recipient" type="text" value="">
                    </div>
                    <label for="address" class="fl">详细地址：</label>
                    <div class="address fr">
                        <textarea name="address" id="address" cols="30" rows="10"></textarea>
                    </div>
                    <button id="saveAddress">保存</button>
                </div>
            </div>
        </div>

        <%--修改密码--%>
        <div class="content priority">
            <h3 class="content_title">修改密码</h3>
            <div class="edit_con">
                <ul class="edit_ul">
                    <li>
                        <label for="old_pwd">原密码：</label>
                        <input type="password" id="old_pwd" placeholder="请输入原密码">
                        <span class="error_tip">密码错误</span>
                    </li>
                    <li>
                        <label for="new_pwd">新密码：</label>
                        <input type="password" id="new_pwd" placeholder="请输入8-20位字母及数字的密码">
                        <span class="error_tip">密码最少8位，最多20位</span>
                    </li>
                    <li>
                        <label for="con_pwd">确认密码：</label>
                        <input type="password" id="con_pwd" placeholder="请再次确认密码">
                        <span class="error_tip">两次输入的密码不一致</span>
                    </li>
                </ul>
                <button id="saveEdit">确认修改</button>
            </div>
        </div>
    </div>
</div>

<div class="footer">
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




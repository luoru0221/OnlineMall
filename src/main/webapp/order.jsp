<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <link rel="stylesheet" type="text/css" href="css/order.css">
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
<div class="search_bar priority">
    <a href="index.jsp" class="logo fl"><img src="images/logo03.png" alt="logo"></a>
    <div class="sub_page_name fl">|&nbsp;&nbsp;&nbsp;我的订单</div>
    <div class="search_con fr">
        <label>
            <input type="text" class="input_text fl" id="search_keyword" placeholder="搜索商品">
        </label>
        <input type="button" class="input_btn fr" value="搜索">
    </div>
</div>

<div class="main_con">
    <div class="address_con">
        <div>收件人姓名：<span>${requestScope.loginUser["recName"]}</span></div>
        <div>收货地址：<span>${requestScope.loginUser["address"]}</span></div>
        <a href="usercenter.jsp">编辑收货地址</a>
    </div>
    <div class="order_list priority">
        <c:forEach var="product" items="${requestScope.products}">
            <ul class="order_list_td priority">
                <li class="order_image fl"><img alt="image" src=${product["image"]}></li>
                <li class="order_name fl">${product["name"]}</li>
                <li class="order_price fl">单价：￥${product["price"]}</li>
                <li class="order_number fl">数量：${product["number"]}</li>
                <li class="order_total_price fr">小计：￥${product["price"]*product["number"]}</li>
            </ul>
        </c:forEach>
        <div class="submit_order_con priority">
            <div>总价：<span>￥${requestScope.totalPrice}</span></div>
            <a href="addOrder" id="submit_order" class="fr">提交订单</a>
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
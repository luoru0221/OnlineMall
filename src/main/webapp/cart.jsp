<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="fun" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>1号店-购物车</title>
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <link rel="stylesheet" type="text/css" href="css/cart.css">
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="js/cart.js"></script>
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
    <div class="sub_page_name fl">|&nbsp;&nbsp;&nbsp;购物车</div>
    <div class="search_con fr">
        <label>
            <input type="text" class="input_text fl" name="" placeholder="搜索商品">
        </label>
        <input type="button" class="input_btn fr" name="" value="搜索">
    </div>
</div>

<div class="total_count">全部商品<em>${fn:length(requestScope.productCart)}</em>件</div>
<ul class="cart_list_th priority">
    <li class="col01">商品名称</li>
    <li class="col02">商品单价</li>
    <li class="col03">数量</li>
    <li class="col04">小计</li>
    <li class="col05">操作</li>
</ul>

<c:forEach var="product" items="${requestScope.productCart}">
    <ul class="cart_list_td priority">
        <li class="col01"><label>
            <input type="checkbox" name="item_box">
        </label></li>
        <li class="col02"><img alt="image" src=${product["image"]}></li>
        <li class="col03">${product["name"]}</li>
        <li class="col04">￥${product["price"]}</li>
        <li class="col05">
            <div class="num_add">
                <a href="javascript:" class="add fl">+</a>
                <label class="pId" productId=${product["id"]}>
                    <input type="text" class="num_show fl" value=${product["number"]}>
                </label>
                <a href="javascript:" class="minus fl">-</a>
            </div>
        </li>
        <li class="col06">￥${product["price"]*product["number"]}</li>
        <li class="col07"><a href="javascript:" id="delate" productId=${product["id"]}>删除</a></li>
    </ul>
</c:forEach>

<ul class="settlements">
    <li class="col01"><label>
        <input type="checkbox" name="all_checked">
    </label></li>
    <li class="col02">全选</li>
    <li class="col03">合计：<span>¥</span><em id="total_price">0</em><br>共计<b id="total_number">0</b>件商品</li>
    <li class="col04"><a href="javascript:" id="submit">去结算</a></li>
</ul>

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
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="fun" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <link rel="stylesheet" type="text/css" href="css/list.css">
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="js/list.js"></script>
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
    <div class="search_con fl">
        <label>
            <input type="text" class="input_text fl" id="keyword_input" placeholder="搜索商品" keyword=${sessionScope.keyword}>
        </label>
        <input type="button" class="input_btn fr" onclick="searchProduct()" value="搜索">
    </div>
    <div class="guest_cart fr">
        <c:if test="${sessionScope.loginId != null}">
            <a class="cart_name fl" href="cartLoad?userId=${sessionScope.loginId}">我的购物车</a>
            <div class="goods_count fl" id="show_count"></div>
        </c:if>
    </div>
</div>
<div class="navbar_con">
</div>
<div class="center_con priority">
    <div class="warp priority">
        <ul class="goods_list">

        </ul>
    </div>
    <div class="pagenation priority">
        <a href="javascript:" class="prePage">&lt上一页</a>
        <c:forEach var="page" items="${sessionScope.pages}">
            <c:if test="${page==sessionScope.nowPage}">
                <a href="#" class="pageCode active">${page}</a>
            </c:if>
            <c:if test="${page!=sessionScope.nowPage}">
                <a href="#" class="pageCode">${page}</a>
            </c:if>
        </c:forEach>
        <a href="javascript:" class="nextPage">下一页&gt</a>
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
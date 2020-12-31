<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/merchant.css">
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="js/orders_merchan.js"></script>
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
        <a href="index.jsp" class="wrap_logo">
            <img src="images/logo04.png" alt="">
        </a>
    </div>
</div>
<div class="main_con priority">
    <div class="left_menu priority">
        <h3>商家中心</h3>
        <ul id="menu">
            <li class="active"><a href="ordersMerchan" class="menu_a">订单管理</a></li>
            <li class=""><a href="productMerchan" class="menu_a">商品管理</a></li>
            <li class=""><a href="addproduct_merchan.jsp" class="menu_a">添加商品</a></li>
        </ul>
    </div>

    <!--    订单管理页-->
    <div class="right_content con_active priority">
        <h3 class="content_title">订单管理</h3>
        <c:forEach var="order" items="${requestScope.orders}">
            <div class="content_con priority">
                <ul class="order_list_th priority">
                    <li class="col01">订单号：${order.key}</li>
                    <li class="col02">收件人地址：${requestScope.infor[order.key].address}</li>
                    <li class="col03">收件人姓名：${requestScope.infor[order.key].name}</li>
                </ul>
                <c:forEach var="orderItem" items="${order.value}">
                    <ul class="order_list_td priority">
                        <li class="order_image fl"><img src="${orderItem.product['image']}" alt="image"></li>
                        <li class="order_name fl">${orderItem.product["name"]}</li>
                        <li class="order_price fl">￥${orderItem.product["price"]}</li>
                        <li class="order_number fl">${orderItem["number"]}</li>
                        <li class="order_total_price fl">￥${orderItem.product["price"]*orderItem["number"]}</li>
                        <c:if test="${orderItem.type==0}">
                            <li class="order_operation fr"><a class="" href="javascript:">待付款</a></li>
                        </c:if>
                        <c:if test="${orderItem.type==1}">
                            <li class="order_operation fr"><a class="send_btn" href="javascript:">待发货</a></li>
                        </c:if>
                        <c:if test="${orderItem.type==2}">
                            <li class="order_operation fr"><a class="" href="javascript:">待收货</a></li>
                        </c:if>
                        <c:if test="${orderItem.type==3}">
                            <li class="order_operation fr"><a class="" href="javascript:">待评价</a></li>
                        </c:if>
                        <c:if test="${orderItem.type==4}">
                            <li class="order_operation fr"><a class="finish_btn" href="javascript:">订单已完成</a></li>
                        </c:if>
                    </ul>
                    <ul class="send_con">
                        <button class="send_product_btn" productId="${orderItem.product.id}">发货</button>
                    </ul>
                </c:forEach>
            </div>
        </c:forEach>
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
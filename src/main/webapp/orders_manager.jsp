<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/manager.css">
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="js/orders_manager.js"></script>
</head>
<body>
<div class="header_con">
    <div class="header">
        <div class="welcome fl">1号店管理员后台</div>
        <div class="fr">
            <div class="user_link fl">
                <a href="exitLogin">退出管理系统</a>
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
        <h3>管理员中心</h3>
        <ul id="menu">
            <li class="active"><a href="ordersManager" class="menu_a">订单管理</a></li>
            <li><a href="userManager" class="menu_a">用户管理</a></li>
            <li><a href="productManager" class="menu_a">商品管理</a></li>
            <li><a href="addproduct_manager.jsp" class="menu_a">添加商品</a></li>
            <li><a href="addtype_manager.jsp" class="menu_a">分类管理</a></li>
        </ul>
    </div>

    <!--    订单管理页-->
    <div class="right_content priority con_active">
        <h3 class="content_title">订单管理</h3>
        <c:forEach var="order" items="${requestScope.orders}">
            <div class="content_con">
                <ul class="order_list_th priority">
                    <li class="col01">订单号：${order.key}</li>
                    <li class="col02">订单状态：${requestScope.orderTypes[order.key]}</li>
                    <c:if test="${requestScope.orderTypes[order.key]=='订单已完成'}">
                        <li class="col03"><a href="javascript:" class="delete_order_btn">删除订单</a></li>
                    </c:if>
                </ul>
                <c:forEach var="orderItem" items="${order.value}">
                    <ul class="order_list_td priority">
                        <li class="order_image fl"><img src="${orderItem.product['image']}" alt="image"></li>
                        <li class="order_name fl">${orderItem.product['name']}</li>
                        <li class="order_price fl">${orderItem.product['price']}</li>
                        <li class="order_number fl">${orderItem.number}</li>
                        <li class="order_total_price fl">￥${orderItem.number*orderItem.product['price']}</li>
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

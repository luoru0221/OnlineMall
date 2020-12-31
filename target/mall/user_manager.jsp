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
    <script type="text/javascript" src="js/user_manager.js"></script>
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
            <li><a href="ordersManager" class="menu_a">订单管理</a></li>
            <li class="active"><a href="userManager" class="menu_a">用户管理</a></li>
            <li><a href="productManager" class="menu_a">商品管理</a></li>
            <li><a href="addproduct_manager.jsp" class="menu_a">添加商品</a></li>
            <li><a href="addtype_manager.jsp" class="menu_a">分类管理</a></li>
        </ul>
        <div class="search_user_con">
            <input type="text" id="search_user" placeholder="搜索用户">
            <button onclick="searchUser()">搜索</button>
        </div>
    </div>
    <!--    用户管理页-->
    <div class="right_content priority con_active">
        <h3 class="content_title">用户管理</h3>
        <div class="content_con">
            <ul class="user_list_th priority">
                <li class="user_id">ID</li>
                <li class="user_name">昵称</li>
                <li class="user_email">Email</li>
                <li class="user_operation">操作</li>
            </ul>
            <c:forEach var="user" items="${requestScope.users}">
                <ul class="user_list_td priority">
                    <li class="user_id_show">${user['id']}</li>
                    <li class="user_name_show">${user['name']}</li>
                    <li class="user_email_show">${user['email']}</li>
                    <li class="user_operation_show"><a class="user_operation_a" href="javascript:">删除</a></li>
                </ul>
            </c:forEach>
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

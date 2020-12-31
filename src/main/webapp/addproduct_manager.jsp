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
    <script type="text/javascript" src="js/addproduct_manager.js"></script>
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
            <li><a href="userManager" class="menu_a">用户管理</a></li>
            <li><a href="productManager" class="menu_a">商品管理</a></li>
            <li class="active"><a href="addproduct_manager.jsp" class="menu_a">添加商品</a></li>
            <li><a href="addtype_manager.jsp" class="menu_a">分类管理</a></li>
        </ul>
    </div>
    <div class="right_content priority con_active">
        <h3 class="content_title">添加商品</h3>
        <div class="add_information fl">
            <label for="pName">商品名称：</label>
            <input type="text" id="pName"><br>
            <label for="pDescription">商品描述：</label>
            <textarea rows="10" cols="30" id="pDescription"></textarea><br>
            <label for="pPrice">商品价格：</label>
            <input type="text" id="pPrice"><br>
            <label>商品分类：</label><br>
            <select name="pType" id="firstType">
            </select>
            <select name="pType" id="secondType">
            </select>
            <select name="pType" id="thirdType">
            </select>
        </div>
        <div class="pImageDiv fr priority">
            <label for="pImage">商品图片：</label>
            <input type="file" id="pImage" accept=".png,.jpg,.jpeg,image/png,image/jpg,image/jpeg" onchange="showImg()"><br>
            <img src="" id="pImageShow" alt="暂未上传图片">
        </div>
        <div class="fl priority" id="add_tips">
            <button class="fr" onclick="addProduct()">确认添加</button>
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

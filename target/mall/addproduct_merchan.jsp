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
    <script type="text/javascript" src="js/addproduct_merchan.js"></script>
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
            <li class=""><a href="ordersMerchan" class="menu_a">订单管理</a></li>
            <li class=""><a href="productMerchan" class="menu_a">商品管理</a></li>
            <li class="active"><a href="addproduct_merchan.jsp" class="menu_a">添加商品</a></li>
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
        <button class="submit fr" onclick="addProduct()">确认添加</button>
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
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
    <script type="text/javascript" src="js/product_merchan.js"></script>
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
            <li class="active"><a href="productMerchan" class="menu_a">商品管理</a></li>
            <li class=""><a href="addproduct_merchan.jsp" class="menu_a">添加商品</a></li>
        </ul>
    </div>
    <div class="right_content priority con_active">
        <h3 class="content_title">商品管理</h3>
        <div class="content_con">
            <ul class="product_list_th priority">
                <li class="product_id">商品ID</li>
                <li class="product_name">名称</li>
                <li class="product_price">单价</li>
                <li class="product_operation">操作</li>
            </ul>
            <c:forEach var="product" items="${requestScope.products}">
                <ul class="product_list_td priority">
                    <li class="product_id_show">${product.id}</li>
                    <li class="product_name_show">${product.name}</li>
                    <li class="product_price_show">${product.price}</li>
                    <li class="product_operation_show"><a class="operation" href="javascript:">编辑</a></li>
                </ul>
                <div class="operation_con priority">
                    <div class="product_information fl">
                        <div class="con_input">
                            <label for="p_id">ID：</label>
                            <input type="text" id="p_id" class="productId_input" value="${product.id}" readonly='true'>
                        </div>
                        <div class="con_input">
                            <label for="p_name">名称：</label>
                            <input type="text" id="p_name" class="productName_input" value="${product.name}">
                        </div>
                        <div class="con_area">
                            <label for="p_description">详情：</label>
                            <textarea id="p_description"
                                      class="productDescription_input">${product.description}</textarea>
                        </div>
                        <div class="con_input">
                            <label for="p_price">单价：</label>
                            <input type="text" id="p_price" class="productPrice_input" value="${product.price}">
                        </div>
                        <div class="select_con">
                            <label typeId="${product['type']}">商品分类：</label><br>
                            <select name="pType" class="firstType">
                            </select>
                            <select name="pType" class="secondType">
                            </select>
                            <select name="pType" class="thirdType">
                            </select>
                        </div>
                        <div class="con_btn priority">
                            <button class="save_change fl">保存修改</button>
                            <button class="delate_product fr">删除商品</button>
                        </div>
                    </div>
                    <div class="product_img fr">
                        <div class="p_image">
                            <label>上传商品图片</label>
                            <input type="file" id="p_image" class="productImage_input"
                                   accept=".png,.jpg,.jpeg,image/png,image/jpg,image/jpeg">
                        </div>
                        <img src="${product.image}" id="p_img_show" class="productImage_show" alt="暂未上传图片">
                    </div>
                </div>
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
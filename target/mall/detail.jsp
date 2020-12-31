<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="fun" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>1号店-商品详情</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/detail.css">
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="js/detail.js"></script>
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
    <div class="search_con fl">
        <label>
            <input type="text" class="input_text fl" id="search_keyword" placeholder="搜索商品">
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
<!--空白填充-->
<div class="block_div">
    <div class="block_div_bottom"></div>
    <div></div>
</div>
<div class="goods_detail_con priority">
    <div class="goods_detail_pic fl"><img alt="image" src=${requestScope.product["image"]}></div>
    <div class="goods_detail_wrap fr">
        <ul class="goods_detail_tab priority">
            <li class="active">购&nbsp;&nbsp;&nbsp;&nbsp;买</li>
            <li>商品详情</li>
            <li>商品评价</li>
        </ul>
        <!-- 导航底部内容-->
        <div class="tab_content checked"><!--购买-->
            <div class="tab_content_buy">
                <h3>${requestScope.product["name"]}</h3>
                <div class="goods_num priority">
                    <div class="num_name fl">数量:</div>
                    <div class="num_add fl">
                        <label>
                            <input class="fl num_show" type="text" value="1">
                        </label>
                        <a href="javascript:" class="add fr">+</a>
                        <a href="javascript:" class="minus fr">-</a>
                    </div>
                </div>
                <div class="total_price">
                    单价：
                    <em>￥${requestScope.product["price"]}</em>
                </div>
                <div class="operate_btn">
                    <c:if test="${sessionScope.loginId == null}">
                        <a href="javascript:" class="buy_btn"
                           onclick="rightBuy('',${requestScope.product['id']})">立即购买</a>
                    </c:if>
                    <c:if test="${sessionScope.loginId != null}">
                        <a href="javascript:" class="buy_btn"
                           onclick="rightBuy('${sessionScope.loginId}',${requestScope.product['id']})">立即购买</a>
                    </c:if>
                    <c:if test="${sessionScope.loginId == null}">
                        <a href="javascript:" class="add_cart_btn"
                           onclick="addToCart('',${requestScope.product['id']})">加入购物车</a>
                    </c:if>
                    <c:if test="${sessionScope.loginId != null}">
                        <a href="javascript:" class="add_cart_btn"
                           onclick="addToCart('${sessionScope.loginId}',${requestScope.product['id']})">加入购物车</a>
                    </c:if>
                </div>
            </div>
        </div>

        <div class="tab_content"><!--商品详情-->
            <dl>
                <dt>商品详情</dt>
                <dd>${requestScope.product['description']}</dd>
            </dl>
        </div>

        <div class="tab_content"><!--商品评价-->
            <ul class="judge_list_con">
                <c:forEach var="evaluate" items="${requestScope.evaluates}">
                    <li>
                        <b class="user_name">${evaluate['uid']}&nbsp;&nbsp;${evaluate['time']}</b>
                        <div class="judge_detail">
                            ${evaluate['content']}
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
<div class="footer priority">
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

<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="fun" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>1号店-首页</title>
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
<%--    <link rel="stylesheet" type="text/css" href="css/new.css">--%>
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="js/index.js"></script>
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
            <div class="welcome fl"><a href="javascript:beStore()">免费申请开店</a></div>
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
<div class="navbar_con">
    <div class="navbar">
        <h1 class="fl">全部商品分类</h1>
    </div>
</div>
<div class="pos_center_con priority">
    <div class="img_bk">
        <img src="images/slide01.jpg" alt="background">
    </div>

    <ul class="sub_menu">
    </ul>

    <div class="news">
        <div class="news_title">
            <h3>快讯</h3>
            <a href="#">更多 &gt;</a>
        </div>
        <ul class="news_list">
            <li><a href="http://www.xinhuanet.com/politics/2020-12/31/c_1126934359.htm" target="_blank">国家主席习近平发表二〇二一年新年贺词</a></li>
            <li><a href="https://new.qq.com/omn/20210102/20210102A09S1G00.html" target="_blank">时政微纪录丨2020我们一起走过</a></li>
        </ul>
    </div>
</div>

<div class="list_model">
    <div class="list_title priority">
        <h3 class="fl" id="model01">手机数码</h3>
        <div class="subtitle fl"></div>
<%--        <a href="list.jsp" class="goods_more fr" id="fruit_more">查看更多 ></a>--%>
    </div>

    <div class="goods_con priority">
        <div class="goods_banner fl"><img src="images/banner01.jpg" alt="image"></div>
        <ul class="goods_list fl">
            <li>
                <h4><a href="detailLoad"></a></h4>
                <a href="detailLoad"><img src="" alt="image"></a>
                <div class="prize"></div>
            </li>
            <li>
                <h4><a href="detailLoad"></a></h4>
                <a href="detailLoad"><img src="" alt="image"></a>
                <div class="prize"></div>
            </li>
            <li>
                <h4><a href="detailLoad"></a></h4>
                <a href="detailLoad"><img src="" alt="image"></a>
                <div class="prize"></div>
            </li>
            <li>
                <h4><a href="detailLoad"></a></h4>
                <a href="detailLoad"><img src="" alt="image"></a>
                <div class="prize"></div>
            </li>
        </ul>
    </div>
</div>

<div class="list_model">
    <div class="list_title priority">
        <h3 class="fl" id="model02">电脑办公</h3>
        <div class="subtitle fl">
        </div>
<%--        <a href="list.jsp" class="goods_more fr">查看更多 ></a>--%>
    </div>

    <div class="goods_con priority">
        <div class="goods_banner fl"><img src="images/banner02.jpg" alt="image"></div>
        <ul class="goods_list fl">
            <li>
                <h4><a href="detailLoad"></a></h4>
                <a href="detailLoad"><img src="" alt="image"></a>
                <div class="prize"></div>
            </li>
            <li>
                <h4><a href="detailLoad"></a></h4>
                <a href="detailLoad"><img src="" alt="image"></a>
                <div class="prize"></div>
            </li>
            <li>
                <h4><a href="detailLoad"></a></h4>
                <a href="detailLoad"><img src="" alt="image"></a>
                <div class="prize"></div>
            </li>
            <li>
                <h4><a href="detailLoad"></a></h4>
                <a href="detailLoad"><img src="" alt="image"></a>
                <div class="prize"></div>
            </li>
        </ul>
    </div>
</div>

<div class="list_model">
    <div class="list_title priority">
        <h3 class="fl" id="model03">美妆护理</h3>
        <div class="subtitle fl"></div>
<%--        <a href="list.jsp" class="goods_more fr">查看更多 ></a>--%>
    </div>

    <div class="goods_con priority">
        <div class="goods_banner fl"><img src="images/banner03.png" alt="image"></div>
        <ul class="goods_list fl">
            <li>
                <h4><a href="detailLoad"></a></h4>
                <a href="detailLoad"><img src="" alt="image"></a>
                <div class="prize"></div>
            </li>
            <li>
                <h4><a href="detailLoad"></a></h4>
                <a href="detailLoad"><img src="" alt="image"></a>
                <div class="prize"></div>
            </li>
            <li>
                <h4><a href="detailLoad"></a></h4>
                <a href="detailLoad"><img src="" alt="image"></a>
                <div class="prize"></div>
            </li>
            <li>
                <h4><a href="detailLoad"></a></h4>
                <a href="detailLoad"><img src="" alt="image"></a>
                <div class="prize"></div>
            </li>
        </ul>
    </div>
</div>

<div class="list_model">
    <div class="list_title priority">
        <h3 class="fl" id="model04">家居家装</h3>
        <div class="subtitle fl"></div>
<%--        <a href="list.jsp" class="goods_more fr">查看更多 ></a>--%>
    </div>

    <div class="goods_con priority">
        <div class="goods_banner fl"><img src="images/banner04.jpg" alt="image"></div>
        <ul class="goods_list fl">
            <li>
                <h4><a href="detailLoad"></a></h4>
                <a href="detailLoad"><img src="" alt="image"></a>
                <div class="prize"></div>
            </li>
            <li>
                <h4><a href="detailLoad"></a></h4>
                <a href="detailLoad"><img src="" alt="image"></a>
                <div class="prize"></div>
            </li>
            <li>
                <h4><a href="detailLoad"></a></h4>
                <a href="detailLoad"><img src="" alt="image"></a>
                <div class="prize"></div>
            </li>
            <li>
                <h4><a href="detailLoad"></a></h4>
                <a href="detailLoad"><img src="" alt="image"></a>
                <div class="prize"></div>
            </li>
        </ul>
    </div>
</div>

<div class="list_model">
    <div class="list_title priority">
        <h3 class="fl" id="model05">生活电器</h3>
        <div class="subtitle fl"></div>
<%--        <a href="list.jsp" class="goods_more fr">查看更多 ></a>--%>
    </div>

    <div class="goods_con priority">
        <div class="goods_banner fl"><img src="images/banner05.jpg" alt="image"></div>
        <ul class="goods_list fl">
            <li>
                <h4><a href="detailLoad"></a></h4>
                <a href="detailLoad"><img src="" alt="image"></a>
                <div class="prize"></div>
            </li>
            <li>
                <h4><a href="detailLoad"></a></h4>
                <a href="detailLoad"><img src="" alt="image"></a>
                <div class="prize"></div>
            </li>
            <li>
                <h4><a href="detailLoad"></a></h4>
                <a href="detailLoad"><img src="" alt="image"></a>
                <div class="prize"></div>
            </li>
            <li>
                <h4><a href="detailLoad"></a></h4>
                <a href="detailLoad"><img src="" alt="image"></a>
                <div class="prize"></div>
            </li>
        </ul>
    </div>
</div>

<div class="list_model">
    <div class="list_title priority">
        <h3 class="fl" id="model06">食品零食</h3>
        <div class="subtitle fl"></div>
    </div>

    <div class="goods_con priority">
        <div class="goods_banner fl"><img src="images/banner06.png" alt="image"></div>
        <ul class="goods_list fl">
            <li>
                <h4><a href="detailLoad"></a></h4>
                <a href="detailLoad"><img src="" alt="image"></a>
                <div class="prize"></div>
            </li>
            <li>
                <h4><a href="detailLoad"></a></h4>
                <a href="detailLoad"><img src="" alt="image"></a>
                <div class="prize"></div>
            </li>
            <li>
                <h4><a href="detailLoad"></a></h4>
                <a href="detailLoad"><img src="" alt="image"></a>
                <div class="prize"></div>
            </li>
            <li>
                <h4><a href="detailLoad"></a></h4>
                <a href="detailLoad"><img src="" alt="image"></a>
                <div class="prize"></div>
            </li>
        </ul>
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
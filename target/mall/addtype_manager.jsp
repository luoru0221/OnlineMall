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
    <script type="text/javascript" src="js/addtype_manager.js"></script>
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
            <li><a href="addproduct_manager.jsp" class="menu_a">添加商品</a></li>
            <li class="active"><a href="addtype_manager.jsp" class="menu_a">分类管理</a></li>
        </ul>
    </div>
    <%--分类管理--%>
    <div class="right_content fl con_active">
        <h3 class="content_title">分类管理</h3>
        <div class="add_type fl">
            <div class="add_type_con">
                <h4>添加一级分类:</h4>
                <div class="input_con">
                    <input type="text" id="first_type_input" placeholder="填写一级分类名">
                    <button id="first_add_btn">添加</button>
                </div>
            </div>
            <div class="add_type_con">
                <h4>添加二级分类:</h4>
                <div class="input_con">
                    <select id="first_select">
                    </select>
                    <input type="text" id="second_type_input" placeholder="填写二级分类名">
                    <button id="second_add_btn">添加</button>
                </div>
            </div>
            <div class="add_type_con">
                <h4>添加三级分类:</h4>
                <div class="input_con">
                    <select id="second_select">
                    </select>
                    <select id="third_select">
                    </select>
                    <input type="text" placeholder="填写三级分类名">
                    <button id="third_add_btn">添加</button>
                </div>
            </div>
        </div>
        <div class="update_type fr">
            <div class="update_type_con">
                <h4>修改三级分类:</h4>
                <div class="input_con">
                    <select id="update_thirdType_first">
                    </select>
                    <select id="update_thirdType_second">
                    </select>
                    <select id="update_thirdType_third">
                    </select>
                    <input type="text" placeholder="填写新的三级分类名">
                    <button id="update_thirdType_btn">修改</button>
                </div>
            </div>
            <div class="update_type_con">
                <h4>修改二级分类:</h4>
                <div class="input_con">
                    <select id="update_secondType_first">
                    </select>
                    <select id="update_secondType_second">
                    </select>
                    <input type="text" placeholder="填写新的二级分类名">
                    <button id="update_secondType_btn">修改</button>
                </div>
            </div>
            <div class="update_type_con">
                <h4>修改一级分类:</h4>
                <div class="input_con">
                    <select id="update_firstType_first">
                    </select>
                    <input type="text" placeholder="填写新的一级分类名">
                    <button id="update_firstType_btn">修改</button>
                </div>
            </div>
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

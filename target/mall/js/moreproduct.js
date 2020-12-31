$(function () {

    var typeId = $(".c_type.active").attr("typeId");  //分类ID
    var pageCode = $(".pageCode.active").text();  //页码

    $.ajax({
        url: "selectProductByType",
        type: "GET",
        dataType: "JSON",
        data: {
            "typeId": typeId,
            "pageCode": pageCode
        },
        success: function (products) {
            var $goods_list = $(".goods_list");
            $goods_list.empty();
            for (var index in products) {
                var product = products[index];
                var $goods_li = $("<li></li>");
                var $goods_li_a = $("<a href='detailLoad?productId="+product['id']+"'><img src='"+product['image']+"' alt=''></a>");
                var $goods_li_h4 = $("<h4><a href='detailLoad?productId="+product['id']+"'>"+product['name']+"</a></h4>");
                var $goods_li_div = $("<div class='price'>￥"+product['price']+"</div>");

                $goods_li_a.appendTo($goods_li);
                $goods_li_h4.appendTo($goods_li);
                $goods_li_div.appendTo($goods_li);
                $goods_li.appendTo($goods_list);
            }
        }
    });

    /**
     * 上一页
     */
    $(".prePage").click(function () {
        if ($(".pageCode.active").prev().text() !== "<上一页") {
            $(".pageCode.active").removeClass("active").prev().addClass("active");
        }
        var typeId = $(".c_type.active").attr("typeId");  //分类ID
        var pageCode = $(".pageCode.active").text();  //页码

        $.ajax({
            url: "selectProductByType",
            type: "GET",
            dataType: "JSON",
            data: {
                "typeId": typeId,
                "pageCode": pageCode
            },
            success: function (products) {
                var $goods_list = $(".goods_list");
                console.log(products);
                $goods_list.empty();
                for (var index in products) {
                    var product = products[index];
                    var $goods_li = $("<li></li>");
                    var $goods_li_a = $("<a href='detailLoad?productId="+product['id']+"'><img src='"+product['image']+"' alt=''></a>");
                    var $goods_li_h4 = $("<h4><a href='detailLoad?productId="+product['id']+"'>"+product['name']+"</a></h4>");
                    var $goods_li_div = $("<div class='price'>￥"+product['price']+"</div>");

                    $goods_li_a.appendTo($goods_li);
                    $goods_li_h4.appendTo($goods_li);
                    $goods_li_div.appendTo($goods_li);
                    $goods_li.appendTo($goods_list);
                }
            }
        });
    });

    /**
     * 下一页
     */
    $(".nextPage").click(function () {
        if ($(".pageCode.active").next().text() !== "下一页>") {
            $(".pageCode.active").removeClass("active").next().addClass("active");
        }
        var typeId = $(".c_type.active").attr("typeId");  //分类ID
        var pageCode = $(".pageCode.active").text();  //页码

        $.ajax({
            url: "selectProductByType",
            type: "GET",
            dataType: "JSON",
            data: {
                "typeId": typeId,
                "pageCode": pageCode
            },
            success: function (products) {
                var $goods_list = $(".goods_list");
                $goods_list.empty();
                for (var index in products) {
                    var product = products[index];
                    var $goods_li = $("<li></li>");
                    var $goods_li_a = $("<a href='detailLoad?productId="+product['id']+"'><img src='"+product['image']+"' alt=''></a>");
                    var $goods_li_h4 = $("<h4><a href='detailLoad?productId="+product['id']+"'>"+product['name']+"</a></h4>");
                    var $goods_li_div = $("<div class='price'>￥"+product['price']+"</div>");

                    $goods_li_a.appendTo($goods_li);
                    $goods_li_h4.appendTo($goods_li);
                    $goods_li_div.appendTo($goods_li);
                    $goods_li.appendTo($goods_list);
                }
            }
        });
    })
});

function showMore(typeId) {
    location.href = "productShow?typeId=" + typeId;
}
function searchProduct() {
    var keyword = $("#search_keyword").val();
    window.location.href = "searchProduct?keyword=" + keyword;
}
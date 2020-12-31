$(function () {
    //计算商品总价
    var $orderList = $(".order_list");
    $orderList.each(function () {
        var total = 0;  //商品总价
        var $totalShow = $(this).children(".cart_list_th").children(".col02");  //商品总价显示
        var $listItem = $(this).children(".order_list_td"); //每一件商品
        $listItem.each(function () {
            total += parseFloat($(this).children(".order_total_price").text().slice(1));
        });
        $totalShow.text("总价：￥" + total);
    });


    //显示付款功能
    $(".pay_a").click(function () {
        $(this).parent().parent().nextAll(".pay_con").eq(0).toggle(function () {
            $(this).addClass("active");
            $(this).removeClass("active");
        })
    });
    //确认收货功能
    $(".confire_a").click(function () {
        $(this).parent().parent().nextAll(".confire_con").eq(0).toggle(function () {
            $(this).addClass("active");
            $(this).removeClass("active");
        })
    });
    //显示评价功能
    $(".comment_a").click(function () {
        $(this).parent().parent().nextAll(".comment_con").eq(0).toggle(function () {
            $(this).addClass("active");
            $(this).removeClass("active");
        })
    });

});

/**
 * 支付、确认收货、评价
 */
$(function () {
    var $payBtn = $(".pay_btn");  //支付
    var $commentBtn = $(".comment_btn");  //订单评价
    var $confireBtn = $(".confire_btn"); //确定收货

    $payBtn.click(function () {
        var orderId = $(this).parent().siblings(".cart_list_th").children(".col01").text().slice(5);
        var productId = $(this).attr("productId");
        $.ajax({
            url: "payOrderItem",
            dataType: "JSON",
            type: "GET",
            data: {
                "oid": orderId,
                "pid": productId
            },
            success: function (success) {
                if (success) {
                    alert("支付成功！");
                    window.location.reload();
                }
            }
        })
    });

    //确认收货
    $confireBtn.click(function () {
        var orderId = $(this).parent().siblings(".cart_list_th").children(".col01").text().slice(5);
        var productId = $(this).attr("productId");
        $.ajax({
            url: "confireReceipt",
            type: "GET",
            dataType:"json",
            data: {
                "oid": orderId,
                "pid": productId
            },
            success: function (success) {
                if(success){
                    alert("收货成功！");
                    window.location.reload();
                }
            }
        })
    });

    //订单评价
    $commentBtn.click(function () {

        var content = $(this).next().val(); //评价的内容
        var pid = $(this).attr("productId");  //评价的商品
        var orderId = $(this).parent().siblings(".cart_list_th").children(".col01").text().slice(5);

        if (content.length === 0) {
            alert("请先填入您对该商品的评价！");
        } else {
            $.ajax({
                url: "commentOrder",
                type: "GET",
                dataType: "JSON",
                data: {
                    "pid": pid,
                    "content": content,
                    "orderId": orderId
                },
                success: function (success) {
                    if (success) {
                        alert("评价成功！");
                        window.location.reload();
                    }
                }
            })
        }
    })
});
function searchProduct() {
    var keyword = $("#search_keyword").val();
    window.location.href = "searchProduct?keyword=" + keyword;
}
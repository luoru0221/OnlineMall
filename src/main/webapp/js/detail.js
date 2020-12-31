//导航切换
$(function () {
    var $detail_tab = $(".goods_detail_tab li");
    var $tab_content = $(".tab_content");
    $detail_tab.click(function () {
        $(this).addClass('active').siblings().removeClass('active');
        $tab_content.eq($(this).index()).addClass('checked').siblings().removeClass('checked');
    });

});

/**
 * 商品添加至购物车
 * 参数为当前登录的用户账号和商品id
 */
function addToCart(uid, pid) {
    if (uid === null || uid === "") {
        alert("您还没有登录，请先登录！");
        return;
    }
    var number = parseInt($(".num_show").val());
    $.ajax({
        url: 'addToCart',
        dataType: 'json',
        type: 'Get',
        data: {
            userId: uid,
            productId: pid,
            number: number
        },
        success: function (data) {
            alert("加入购物车成功!");
            if (data === true) {
                var $count = $('#show_count');
                $count[0].innerHTML = parseInt($count[0].innerHTML) + 1;
            }
        }
    })
}

$(function () {
    var $addBtn = $(".add");
    var $minusBtn = $(".minus");
    var $numShow = $(".num_show");
    $addBtn.click(function () {
        $numShow.val(parseInt($numShow.val()) + 1);
    });
    $minusBtn.click(function () {
        if ($numShow.val() > 1)
            $numShow.val(parseInt($numShow.val()) - 1);
    })
});

/**
 * 立即购买
 */
function rightBuy(uid, productId) {
    if (uid === null || uid === '') {
        alert("您还没有登录，请先登录");
    } else {
        $.ajax({
            url: "refreshCart",
            type: "GET",
            success: function (success) {
                if (success) {
                    $.ajax({
                        url: "rightBuy",
                        type: "GET",
                        dataType: "JSON",
                        data: {
                            "productId": productId
                        },
                        success: function (success) {
                            if (success) {
                                window.location.href = "orderLoad";
                            } else {
                                alert("系统繁忙，请稍后重试！");
                            }
                        }
                    })
                } else {
                    alert("系统繁忙，请稍后重试！");
                }
            }
        })
    }
}
function searchProduct() {
    var keyword = $("#search_keyword").val();
    window.location.href = "searchProduct?keyword=" + keyword;
}

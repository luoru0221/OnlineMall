$(function () {
    $(".send_btn").click(function () {
        $(this).parent().parent().nextAll(".send_con").eq(0).toggle(function () {
            $(this).addClass("con_active");
            $(this).removeClass("con_active");
        })
    });

    /**
     * 发货
     */
    $(".send_product_btn").click(function () {
        var orderId = $(this).parent().siblings(".order_list_th").children(".col01").text().slice(4);
        var productId = $(this).attr("productId");
        $.ajax({
            url:"sendProduct",
            type:"GET",
            dataType:"JSON",
            data:{
                "orderId":orderId,
                "productId":productId
            },
            success:function (success) {
                if(success){
                    alert("已发货");
                    window.location.reload();
                }else{
                    alert("系统繁忙，请稍后重试！");
                }
            }
        })
    });
});
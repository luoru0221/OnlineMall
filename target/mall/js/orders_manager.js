$(function () {
    var $deteleOrderBtn = $(".delete_order_btn");
    $deteleOrderBtn.click(function () {
        var $father = $(this).parents(".content_con");
        var orderId = $(this).parent().siblings(".col01").text().slice(4);
        var confirmDeleteOrder = confirm("确定删除该订单：\n订单编号:" + orderId);
        if (confirmDeleteOrder) {
            $.ajax({
                url: "deleteOrder",
                type: "GET",
                dataType: "JSON",
                data: {
                    "orderId": orderId
                },
                success: function (success) {
                    if (success) {
                        alert("已删除！");
                        $father.remove();
                    } else {
                        alert("系统繁忙，请稍后重试！");
                    }
                }
            })
        }
    })
});
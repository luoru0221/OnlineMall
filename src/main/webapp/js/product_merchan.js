$(function () {
    var $saveChange = $(".save_change");  //修改商品
    var $delateProduct = $(".delate_product");  //删除商品

    $saveChange.click(function () {
        var $productInfo = $(this).parents(".product_information");
        var $productImg = $productInfo.next();
        var $imageInput = $productImg.children(".p_image").children(".productImage_input");

        var productId = $productInfo.children(".con_input").eq(0).children(".productId_input").val();
        var productName = $productInfo.children(".con_input").eq(1).children(".productName_input").val();
        var productDescription = $productInfo.children(".con_area").children(".productDescription_input").val();
        var productPrice = $productInfo.children(".con_input").eq(2).children(".productPrice_input").val();
        var productType = $productInfo.children(".select_con").children(".thirdType").val();
        var productImage = $productImg.children(".productImage_show").attr("src");

        if ($imageInput.val()) {
            var fileData = new FormData();
            var productImageFile = $imageInput[0].files[0];
            fileData.append("pImage", productImageFile);
            $.ajax({
                url: 'updateProduct',
                type: 'POST',
                data: fileData,
                processData: false,
                contentType: false,
                success: function (data) {
                    productImage = data;//返回的图片地址
                    $.ajax({
                        url: "updateProduct",
                        type: "GET",
                        dataType: "JSON",
                        data: {
                            "productId": productId,
                            "productName": productName,
                            "productDescription": productDescription,
                            "productPrice": productPrice,
                            "productType":productType,
                            "productImage": productImage
                        },
                        success: function (success) {
                            if (success) {
                                alert("修改成功！");
                            } else {
                                alert("系统繁忙，请稍后重试");
                            }
                        }
                    })
                }
            })
        } else {
            $.ajax({
                url: "updateProduct",
                type: "GET",
                dataType: "JSON",
                data: {
                    "productId": productId,
                    "productName": productName,
                    "productDescription": productDescription,
                    "productPrice": productPrice,
                    "productType":productType,
                    "productImage": productImage
                },
                success: function (success) {
                    if (success) {
                        alert("修改成功！");
                    } else {
                        alert("系统繁忙，请稍后重试");
                    }
                }
            })
        }
    });

    /**
     * 删除商品
     */
    $delateProduct.click(function () {
        var conFirm = window.confirm("确认删除该商品？");
        if (conFirm) {
            var $child_one = $(this).parents(".operation_con");
            var $child_two = $child_one.prev();
            var pId = $child_one.children(".product_information").children(".con_input").children(".productId_input").val();
            $.ajax({
                url: "deleteProduct",
                type: "GET",
                dataType: "JSON",
                data: {
                    "productId": pId
                },
                success: function (success) {
                    if (success) {
                        $child_one.remove();
                        $child_two.remove();
                        alert("删除成功！");
                    } else {
                        alert("系统繁忙，请稍后重试！");
                    }
                }
            });
        }
    });

    var $productImage_input = $(".productImage_input");
    $productImage_input.change(function () {
        var $now = $(this);
        var $productImage_show = $(this).parent().next();
        $productImage_show.attr("src", URL.createObjectURL($now[0].files[0]));
    });
});
$(function () {
    var $operation = $(".operation");
    $operation.click(function () {
        var $operation_div = $(this).parents("ul").next();
        $operation_div.toggle(function () {
            $operation_div.addClass("con_active");
            $operation_div.removeClass("con_active");
        })
    });
});

/**
 * 商品分类
 */
$(function () {

    $(".select_con").each(function () {
        var typeId = $(this).children("label").attr("typeId");
        var $firstType = $(this).children(".firstType");
        var $secondType = $(this).children(".secondType");
        var $thirdType = $(this).children(".thirdType");
        $.ajax({
            url: "typeInit",
            async:false,
            type: "GET",
            dataType: "JSON",
            data: {
                "typeId": typeId
            },
            success: function (allTypes) {
                console.log(allTypes);
                for (var index1 in allTypes[0]) {
                    var type1 = allTypes[0][index1];
                    $firstType.append("<option value=" + type1['id'] + ">" + type1['name'] + "</option>")
                }
                for (var index2 in allTypes[1]) {
                    var type2 = allTypes[1][index2];
                    $secondType.append("<option value=" + type2['id'] + ">" + type2['name'] + "</option>")
                }
                for (var index3 in allTypes[2]) {
                    var type3 = allTypes[2][index3];
                    $thirdType.append("<option value=" + type3['id'] + ">" + type3['name'] + "</option>")
                }
            }
        })
    });
});

/**
 * 三级联动
 */
$(function () {
    var $firstType = $(".firstType");
    var $secondType = $(".secondType");
    $secondType.change(function () {
        var $thirdType = $(this).siblings(".thirdType");
        var secondType = $(this).val();
        $.ajax({
            url: "selectType",
            type: "GET",
            dataType: "JSON",
            data: {
                "fId": secondType
            },
            success: function (thirdTypes) {
                $thirdType.empty();
                for (var index in thirdTypes) {
                    var thirdType = thirdTypes[index];
                    $thirdType.append("<option value=" + thirdType['id'] + ">" + thirdType['name'] + "</option>")
                }
            }
        })
    });
    $firstType.change(function () {
        $secondType = $(this).siblings(".secondType");
        var $thirdType = $(this).siblings(".thirdType");
        var firstType = $(this).val();
        $.ajax({
            url: "selectType",
            type: "GET",
            dataType: "JSON",
            data: {
                "fId": firstType
            },
            success: function (secondTypes) {
                $secondType.empty();
                for (var index in secondTypes) {
                    var secondType = secondTypes[index];
                    $secondType.append("<option value=" + secondType['id'] + ">" + secondType['name'] + "</option>")
                }
                secondType = $secondType.val();
                if (secondType == null) {
                    $thirdType.empty();
                } else {
                    $.ajax({
                        url: "selectType",
                        type: "GET",
                        dataType: "JSON",
                        data: {
                            "fId": secondType
                        },
                        success: function (thirdTypes) {
                            $thirdType.empty();
                            for (var index in thirdTypes) {
                                var thirdType = thirdTypes[index];
                                $thirdType.append("<option value=" + thirdType['id'] + ">" + thirdType['name'] + "</option>")
                            }
                        }
                    })
                }
            }
        })
    })
});
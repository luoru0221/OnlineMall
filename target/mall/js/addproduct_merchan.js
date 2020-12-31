//添加商品请求
function addProduct() {

    var dom = $("#confirmAddBtm");
    dom.attr("disable", true);
    var tips = [];
    var datas = new FormData();
    var pName = $('#pName').val();  //商品名称
    var pDescription = $('#pDescription').val();    //商品描述
    var pPrice = $('#pPrice').val();    //商品价格
    var pImage = $('#pImage')[0].files[0];     //商品图片
    var pImageAddress = null;
    var pType = $('#thirdType').val(); //商品三级分类
    datas.append("pImage", pImage);

    $.ajax({
        url: 'addProduct',
        type: 'POST',
        async: false,
        data: datas,
        processData: false,
        contentType: false,
        success: function (data) {
            pImageAddress = data;//返回的图片地址
        }
    });
    $.ajax({
        url: 'addProduct',
        type: 'GET',
        async: false,
        dataType: 'json',
        data: {
            'pName': pName,
            'pDescription': pDescription,
            'pPrice': pPrice,
            'pImage': pImageAddress,
            'pType': pType,
            'tips': JSON.stringify(tips)
        }
    });
    alert("添加成功");
    $("input").val("");
    $("textarea").val("");
    $("#pImageShow").attr("src","");
    dom.attr("disable", true);
}

/*选择图片后预览*/
function showImg() {
    $("#pImageShow").attr("src", URL.createObjectURL($("#pImage")[0].files[0]));
}

$(function () {
    var $firstType = $("#firstType");
    var $secondType = $("#secondType");
    var $thirdType = $("#thirdType");

    $.ajax({
        url: "initAllTypes",
        type: "GET",
        dataType: "JSON",
        success: function (allTypes) {
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
    });

    /**
     * 三级联动
     */
    $secondType.change(function () {
        var secondType = $secondType.val();
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
        var firstType = $firstType.val();
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

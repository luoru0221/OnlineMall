/**
 * 加载分类信息以及联动
 */
$(function () {

    var $first_select = $("#first_select");
    var $second_select = $("#second_select");
    var $third_select = $("#third_select");

    var $updateThirdTypeFirst = $("#update_thirdType_first");
    var $updateThirdTypeSecond = $("#update_thirdType_second");
    var $updateThirdTypeThird = $("#update_thirdType_third");
    var $updateSecondTypeFirst = $("#update_secondType_first");
    var $updateSecondTypeSecond = $("#update_secondType_second");
    var $updateFirstTypeFirst = $("#update_firstType_first");

    $.ajax({
        url: "selectInitTypes",
        type: "GET",
        typeData: "JSON",
        success: function (jsonString) {
            var jsonArray = JSON.parse(jsonString);
            for (var index in jsonArray[0]) {
                var type = jsonArray[0][index];
                $first_select.append("<option value=" + type['id'] + ">" + type['name'] + "</option>");
                $second_select.append("<option value=" + type['id'] + ">" + type['name'] + "</option>");
                $updateThirdTypeFirst.append("<option value=" + type['id'] + ">" + type['name'] + "</option>");
                $updateSecondTypeFirst.append("<option value=" + type['id'] + ">" + type['name'] + "</option>");
                $updateFirstTypeFirst.append("<option value=" + type['id'] + ">" + type['name'] + "</option>");
            }
            for (var Index in jsonArray[1]) {
                var Type = jsonArray[1][Index];
                $third_select.append("<option value=" + Type['id'] + ">" + Type['name'] + "</option>");
                $updateThirdTypeSecond.append("<option value=" + Type['id'] + ">" + Type['name'] + "</option>");
                $updateSecondTypeSecond.append("<option value=" + Type['id'] + ">" + Type['name'] + "</option>");
            }
            for (var In in jsonArray[2]) {
                var Ty = jsonArray[2][In];
                $updateThirdTypeThird.append("<option value=" + Ty['id'] + ">" + Ty['name'] + "</option>");
            }
        }
    });

    $second_select.change(function () {
        var fId = $(this).val();
        $.ajax({
            url: "selectType",
            type: "GET",
            dataType: "JSON",
            data: {
                "fId": fId
            },
            success: function (jsonString) {
                $third_select.empty();
                for (var index in jsonString) {
                    var type = jsonString[index];
                    $third_select.append("<option value=" + type['id'] + ">" + type['name'] + "</option>");
                }
            }
        })
    });

    $updateSecondTypeFirst.change(function () {
        var fId = $(this).val();
        $.ajax({
            url: "selectType",
            type: "GET",
            dataType: "JSON",
            data: {
                "fId": fId
            },
            success: function (jsonString) {
                $updateSecondTypeSecond.empty();
                for (var index in jsonString) {
                    var type = jsonString[index];
                    $updateSecondTypeSecond.append("<option value=" + type['id'] + ">" + type['name'] + "</option>");
                }
            }
        })
    });

    $updateThirdTypeSecond.change(function () {
        var fId = $(this).val();
        $.ajax({
            url: "selectType",
            type: "GET",
            dataType: "JSON",
            data: {
                "fId": fId
            },
            success: function (jsonString) {
                $updateThirdTypeThird.empty();
                for (var index in jsonString) {
                    var type = jsonString[index];
                    $updateThirdTypeThird.append("<option value=" + type['id'] + ">" + type['name'] + "</option>");
                }
            }
        })
    });

    $updateThirdTypeFirst.change(function () {
        var fId = $(this).val();
        $.ajax({
            url: "selectType",
            type: "GET",
            dataType: "JSON",
            data: {
                "fId": fId
            },
            success: function (jsonString) {
                $updateThirdTypeSecond.empty();
                for (var index in jsonString) {
                    var type = jsonString[index];
                    $updateThirdTypeSecond.append("<option value=" + type['id'] + ">" + type['name'] + "</option>");
                }
                var fId = $updateThirdTypeSecond.val();
                $.ajax({
                    url: "selectType",
                    type: "GET",
                    dataType: "JSON",
                    data: {
                        "fId": fId
                    },
                    success: function (jsonString) {
                        $updateThirdTypeThird.empty();
                        for (var index in jsonString) {
                            var type = jsonString[index];
                            $updateThirdTypeThird.append("<option value=" + type['id'] + ">" + type['name'] + "</option>");
                        }
                    }
                })
            }
        })
    });
});


/**
 * 添加分类
 */
$(function () {
    //添加一级分类
    $("#first_add_btn").click(function () {
        var $firstInput = $(this).prev();  //一级分类输入框
        var firstTypeName = $firstInput.val();
        if (firstTypeName.length === 0) {
            alert("分类名称不能为空");
        } else {
            $.ajax({
                url: "addFirstType",
                type: "GET",
                dataType: "JSON",
                data: {
                    "name": firstTypeName
                },
                success: function (success) {
                    if (success) {
                        alert("添加成功！");
                        $firstInput.val("");
                    } else {
                        alert("系统繁忙，请稍后重试！");
                    }
                }
            })
        }
    });

    //添加二级分类
    $("#second_add_btn").click(function () {
        var $secondInput = $(this).prev();  //二级分类输入框
        var firstTypeId = $(this).siblings("select").val();  //一级分类选择框
        var secondTypeName = $secondInput.val();   //二级分类
        if (secondTypeName.length === 0) {
            alert("分类名称不能为空！");
        } else {
            $.ajax({
                url: "addType",
                type: "GET",
                dataType: "JSON",
                data: {
                    "fid": firstTypeId,
                    "name": secondTypeName
                },
                success: function (success) {
                    if (success) {
                        alert("添加成功!");
                        $secondInput.val("");
                    } else {
                        alert("系统繁忙，请稍后重试！");
                    }
                }
            })
        }
    });

    //添加三级分类
    $("#third_add_btn").click(function () {
        var $thirdInput = $(this).prev();  //三级分类输入框
        var secondTypeId = $thirdInput.prev().val();
        var thirdTypeName = $thirdInput.val();
        if (thirdTypeName.length === 0) {
            alert("分类名不能为空！");
        } else {
            $.ajax({
                url: "addType",
                type: "GET",
                dataType: "JSON",
                data: {
                    "fid": secondTypeId,
                    "name": thirdTypeName
                },
                success: function (success) {
                    if (success) {
                        alert("添加成功！");
                        $thirdInput.val("");
                    } else {
                        alert("系统繁忙，请稍后重试！");
                    }
                }
            })
        }
    });
});

/**
 * 修改分类信息
 */
$(function () {
    var $updateThirdTypeBtn = $("#update_thirdType_btn");  //修改三级分类按钮
    var $updateSecondTypeBtn = $("#update_secondType_btn");  //修改二级分类按钮
    var $updateFirstTypeBtn = $("#update_firstType_btn");   //修改一级分类按钮

    $updateFirstTypeBtn.click(function () {
        var $firstTypeInput = $(this).prev();
        var firstTypeId = $firstTypeInput.prev().val();
        var newFirstTypeName = $firstTypeInput.val();
        if(newFirstTypeName.length===0){
            alert("分类名不能为空");
        }else{
            $.ajax({
                url:"updateType",
                type:"GET",
                dataType:"JSON",
                data:{
                    "typeId":firstTypeId,
                    "typeName":newFirstTypeName
                },
                success:function (success) {
                    if(success){
                        $firstTypeInput.prev().find("option:selected").text(newFirstTypeName);
                        $firstTypeInput.val("");
                        alert("修改成功!");
                    }
                }
            })
        }
    });

    $updateSecondTypeBtn.click(function () {
        var $secondTypeInput = $(this).prev();
        var secondTypeId = $secondTypeInput.prev().val();
        var newSecondTypeName = $secondTypeInput.val();
        if(newSecondTypeName.length===0){
            alert("分类名不能为空");
        }else{
            $.ajax({
                url:"updateType",
                type:"GET",
                dataType:"JSON",
                data:{
                    "typeId":secondTypeId,
                    "typeName":newSecondTypeName
                },
                success:function (success) {
                    if(success){
                        $secondTypeInput.prev().find("option:selected").text(newSecondTypeName);
                        $secondTypeInput.val("");
                        alert("修改成功!");
                    }
                }
            })
        }
    });

    $updateThirdTypeBtn.click(function () {
        var $thirdTypeInput = $(this).prev();
        var thirdTypeId = $thirdTypeInput.prev().val();
        var newThirdTypeName = $thirdTypeInput.val();
        if(newThirdTypeName.length===0){
            alert("分类名不能为空");
        }else{
            $.ajax({
                url:"updateType",
                type:"GET",
                dataType:"JSON",
                data:{
                    "typeId":thirdTypeId,
                    "typeName":newThirdTypeName
                },
                success:function (success) {
                    if(success){
                        $thirdTypeInput.prev().find("option:selected").text(newThirdTypeName);
                        $thirdTypeInput.val("");
                        alert("修改成功!");
                    }
                }
            })
        }
    });

});
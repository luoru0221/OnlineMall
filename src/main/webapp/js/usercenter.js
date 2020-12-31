$(function () {
    /*导航栏切换效果*/
    var $nav = $("#menu li");
    var $content = $(".content");
    $nav.click(function () {
        $(this).addClass('active').siblings().removeClass('active');
        $content.eq($(this).index()).addClass('con_active').siblings().removeClass('con_active');
    });
});
$(function () {
    //填充数据
    $.ajax({
        url: "userCenter",
        dataType: "json",
        type: "POST",
        success: function (user) {
            //请求到user对象
            $("#uId").text(user["id"].slice(0,6));
            $("#uName").text(user["name"]);
            $("#uEmail").text(user["email"]);
            $("#recName").text(user["recName"]);
            $("#uAddress").text(user["address"]);
            $("#recipient").val(user["recName"]);
            $("#address").text(user["address"]);
        }
    })
});
/**
 * 修改密码
 */
$(function () {
    var pwdTrue = false;  //原始密码是否正确
    var newPwdTrue = false;  //新密码是否合法
    var conPwdTrue = false;  //确认密码是否正确

    var $oldPwd = $("#old_pwd"); //原始密码框
    var $newPwd = $("#new_pwd");  //新密码框
    var $conPwd = $("#con_pwd");  //确认密码框
    var $saveEdit = $("#saveEdit"); //确认修改密码


    //判断原始密码是否正确
    $oldPwd.blur(function () {
        $.ajax({
            url: "judgePwd",
            async: false,
            type: "POST",
            dataType: "json",
            data: {
                oldPwd: $(this).val()
            },
            success: function (isTrue) {
                pwdTrue = isTrue;
            }
        });
        if (!pwdTrue) {
            $(this).siblings("span").show();
        } else {
            $(this).siblings("span").hide();
        }
    });
    $newPwd.blur(function () {
        if ($(this).val().length >= 8 && $(this).val().length <= 20) {
            newPwdTrue = true;
            $(this).siblings("span").hide();
        } else {
            newPwdTrue = false;
            $(this).siblings("span").show()
        }

    });
    $conPwd.blur(function () {
        if ($(this).val() === $newPwd.val()) {
            conPwdTrue = true;
            $(this).siblings("span").hide();
        } else {
            conPwdTrue = false;
            $(this).siblings("span").show();
        }
    });
    $saveEdit.click(function () {
        if (pwdTrue && newPwdTrue && conPwdTrue) {
            $.ajax({
                url: "updatePwd",
                type: "POST",
                dataType: "json",
                data: {"password": $newPwd.val()},
                success: function (success) {
                    if (success) {
                        $oldPwd.val("");
                        $newPwd.val("");
                        $conPwd.val("");
                        alert("修改成功");
                    } else {
                        alert("系统异常，请稍后重试！");
                    }
                }
            })
        } else {
            alert("请规范输入");
        }
    })
});

$(function () {
    var $recipient = $("#recipient");
    var $address = $("#address");

    var recipient;
    var address;

    var $saveAddress = $("#saveAddress");
    $saveAddress.click(function () {
        recipient = $recipient.val();
        address = $address.val();
        if(recipient.length===0){
            alert("收件人姓名不能为空");
        }else{
            $.ajax({
                url:"updateAddress",
                type:"POST",
                dataType:"json",
                data:{
                    "recName":recipient,
                    "address":address
                },
                success:function (success) {
                    if(success){
                        alert("保存成功！");
                    }else{
                        alert("系统异常！请稍后重试");
                    }
                }
            })
        }
    });
});


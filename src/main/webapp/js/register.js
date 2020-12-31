$(function () {

    var error_name = true; //用户名是否错误
    var error_pwd = true;  //密码是否错误
    var error_cpwd = true; //确认密码是否错误
    var error_email = true; //邮箱是否错误
    var error_mcode = true; //验证码是否错误
    var error_check = true; //许可协议

    //验证用户名
    $('#user_name').blur(function () {
        checkUserName();
    });

    //验证密码
    $('#pwd').blur(function () {
        checkPwd();
    });

    //验证确定密码
    $('#cpwd').blur(function () {
        checkCpwd();
    });

    //验证邮箱
    $('#email').blur(function () {
        checkEmail();
    });


    //验证邮箱验证码
    $('#msg_code').blur(function () {
        checkMcode();
    });

    //验证是否勾选许可协议
    $('#allow').click(function () {
        if ($(this).is(':checked')) {
            error_check = false;
            $(this).siblings('span').hide();
        } else {
            error_check = true;
            $(this).siblings('span').show();
        }
    });

    function checkUserName() {
        var len = $('#user_name').val().length;
        if (len < 1 || len > 20) {
            $('#user_name').next().show();
            error_name = true;
        } else {
            $('#user_name').next().hide();
            error_name = false;
        }
    }

    function checkPwd() {
        var len = $('#pwd').val().length;
        if (len < 8 || len > 20) {
            $('#pwd').next().show();
            error_pwd = true;
        } else {
            $('#pwd').next().hide();
            error_pwd = false;
        }
    }

    function checkCpwd() {
        var pwd = $('#pwd').val();
        var cpwd = $('#cpwd').val();
        if (pwd !== cpwd) {
            $('#cpwd').next().show();
            error_cpwd = true;
        } else {
            $('#cpwd').next().hide();
            error_cpwd = false;
        }
    }

    //验证邮箱是否合法
    function checkEmail() {
        var reg = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/;
        if (reg.test($('#email').val())) {
            $('#email').next().hide();
            error_email = false;
        } else {
            $('#email').next().show();
            error_email = true;
        }
    }

    //验证邮箱验证码是否是4位
    function checkMcode() {
        var len = $('#msg_code').val().length;
        if (len === 4) {
            $('#msg_code').next().next().hide();
            error_mcode = false;
        } else {
            $('#msg_code').next().next().show();
            error_mcode = true;
        }
    }


    $('#reg_from').submit(function () {
        checkUserName();
        checkPwd();
        checkCpwd();
        checkEmail();
        checkMcode();
        return error_name === false && error_pwd === false && error_cpwd === false && error_mcode === false && error_email === false && error_check === false;
    })

});

function sendMCode() {

    var request = ajaxFunction(); //创建xmlHttpRequest对象
    var address = $('#email').val(); //用户输入的邮箱地址
    var myButton = $("#get_msg_code"); //获取验证码按钮

    myButton.attr("disabled", true); //使按钮失效
    myButton.css("background-color", "#EAEAEA"); //改变按钮颜色

    //按钮失效倒计时
    var count = 60;
    countTimes();
    function countTimes() {
        myButton.html("重新发送(" + count + "s)");
        count--;
        if (count > 0) {
            setTimeout(countTimes, 1000);
        } else if (count === 0) {
            myButton.html("重新发送");
            myButton.attr("disabled", false); //重新激活按钮
            myButton.css("background-color", "#00FFFF");
        }
    }

    //发送请求，参数分别为：发送方式   发送地址   是否异步传输
    request.open("GET", "sendEmailCode?address=" + address, true);
    request.send();

}

//创建xmlHttpRequest对象
function ajaxFunction() {
    var xmlHttp;
    try {
        xmlHttp = new XMLHttpRequest();
    } catch (e) {
        try {
            xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
    }
    return xmlHttp;
}

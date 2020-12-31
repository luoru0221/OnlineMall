/**
 * 用户管理
 */
$(function () {
    var $delete_btn = $(".user_operation_a");
    $delete_btn.click(function () {
        var $father = $(this).parents(".user_list_td");
        var userId = $(this).parent().siblings(".user_id_show").text();
        var confirmDelete = confirm("确认删除该用户：\n账号：" + userId);
        if (confirmDelete) {
            $.ajax({
                url: "deleteUser",
                type: "GET",
                dataType: "JSON",
                data: {
                    "userId": userId
                },
                success: function (success) {
                    if (success) {
                        alert("删除成功！");
                        $father.remove();
                    } else {
                        alert("系统繁忙，请稍后重试！");
                    }
                }
            })
        }
    })
});
function searchUser() {
    var keyword = $("#search_user").val();
    window.location.href = "searchUsers?keyword="+keyword;
}
$(function () {
    var userId = $("#userId").attr("userid").slice(0,6);
    var $userId = $("input[name='username']");
    $userId.val(userId);
});
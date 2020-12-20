$(document).ready(function () {
    alert(123);
    $("#login_btn").click(function(){
        alert(456);
        $.ajax({
            url:"login/validate",
            type:"post",
            dataType:"json",
            contentType:"application/json;charset=utf-8",
            data:{
                username: $("#username").val(),
                password: $("#password").val()
            },
            success:function(data){
                alert(data);
            },
            error:function(){
            }
        });
    });
});
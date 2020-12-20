<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery-3.5.1.js"></script>
<%--<script src="${pageContext.request.contextPath}/static/js/util.js"></script>--%>
<script>
    $(document).ready(function () {
        $("#login_btn").click(function(){
            //ajax去服务器端校验
            $.post(
                'login/validate',
                {
                    username: $('#username').val(),
                    password: $('#password').val()
                },
                function(result) {
                    if(result == 'true') {
                        window.location.href = "books/queryAll";
                    }
                }
            );
        });
    });
</script>
<html>
<head>
    <style type="text/css">
        body {
            background-size: cover;
            font-size: 16px;
        }

        .form {
            background: rgba(255, 255, 255, 0.2);
            width: 400px;
            margin: 100px auto;
        }
        #login_form {
            display: block;
        }
        #register_form {
            display: none;
        }
        .fa {
            display: inline-block;
            top: 27px;
            left: 6px;
            position: relative;
            color: #ccc;
        }
        input[type="text"], input[type="password"] {
            padding-left: 26px;
        }
        .checkbox {
            padding-left: 21px;
        }
    </style>
    <title>首页</title>
</head>
<body>
<div class="container">
    <div class="form row">
        <div class="col-md-12 column-header">
            <form class="form-horizontal col-sm-offset-3 col-md-offset-3" id="login_form">
                <h3 class="form-title">登录</h3>
                <div class="col-sm-9 col-md-9">
                    <div class="form-group">
                        <i class="fa fa-user fa-lg"></i>
                        <input class="form-control required" id="username" type="text" placeholder="Username" name="username"
                               autofocus="autofocus" maxlength="20"/>
                    </div>
                    <div class="form-group">
                        <i class="fa fa-lock fa-lg"></i>
                        <input class="form-control required" id="password" type="password" placeholder="Password" name="password"
                               maxlength="8"/>
                    </div>
                    <div class="form-group">
                        <input type="button" id="login_btn" value="登录" class="btn btn-primary"/>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>

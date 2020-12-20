<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html>
<head>
    <title>首页</title>
</head>
<body>
<div class="container">
    <div class="form row">
        ${msg}
        <a href="${pageContext.request.contextPath}/books/queryAll">首页</a>
        <a href="${pageContext.request.contextPath}/file/download?filename=${filename}">下载</a>
    </div>
</div>
</body>
</html>

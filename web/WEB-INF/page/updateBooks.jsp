<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

<html>
<head>
    <title>修改书籍</title>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column-header">
            <div class="page-header">
                <h1>
                    <small>
                        新增书籍
                    </small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form class="container container-small" action="${pageContext.request.contextPath}/books/updateBooks" method="post">
                <div class="form-group">
                    <lable>书籍名称</lable>
                    <input type="text" name="bookName" value="${bInfo.bookName}" class="form-control">
                </div>
                <div>
                    <lable>书籍数量</lable>
                    <input type="text" name="bookCounts" value="${bInfo.bookCounts}" class="form-control">
                </div>
                <div class="form-group">
                    <lable>书籍详情</lable>
                    <input type="text" name="detail" value="${bInfo.detail}" class="form-control">
                </div>
                <div>
                    <input type="hidden" name="bookId" value="${bInfo.bookId}">
                </div>
                <div class="form-group">
                    <input type="submit" class="button">
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>

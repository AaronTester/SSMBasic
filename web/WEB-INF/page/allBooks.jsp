<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery-3.5.1.js"></script>
<script>
    $(document).ready(function () {
        $("#logOut").click(function () {
            $.post(
                '${pageContext.request.contextPath}/login/logOut',
                {},
                function (result) {
                    if (result == 'true') {
                        window.location.href = "${pageContext.request.contextPath}/";
                    }
                }
            );
        });
    });
</script>
<html>
<head>
    <title>书籍展示</title>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-10 column-header">
            <div class="page-header">
                <h1>
                    <small>
                        书籍列表-----显示所有书籍
                    </small>
                </h1>
            </div>
        </div>
        <div>
            <div class="page-header">
                <input type="button" id="logOut" value="注销" class="btn btn-primary"/>
            </div>
        </div>
    </div>
    <div>
        <div class="col-md-4 column">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/books/toAddPages">新增书籍</a>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/books/queryAll">显示所有书籍</a>
        </div>
        <div class="col-md-4 column"></div>
        <div class="col-sm-4 column">
            <form class="form-inline" action="${pageContext.request.contextPath}/books/queryBookByName" method="post">
                <p class="text-danger">${errMsg}</p>
                <input type="text" class="form-control" name="bkName"/>
                <input type="submit" class="btn btn-primary">
            </form>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>书籍编号</th>
                    <th>书籍名称</th>
                    <th>书籍数量</th>
                    <th>书籍详情</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${bookList}" var="book">
                    <tr>
                        <td>${book.bookId}</td>
                        <td>${book.bookName}</td>
                        <td>${book.bookCounts}</td>
                        <td>${book.detail}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/books/toUpdatePage/${book.bookId}">修改</a>|
                            <a href="${pageContext.request.contextPath}/books/deleteBooks/${book.bookId}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<div class="container">
    <div class="row clearfix">
        <form class="form-inline" action="${pageContext.request.contextPath}/file/upload" enctype="multipart/form-data" method="post">
            <table>
                <tr>
                    <td>请选择文件：</td>
                    <td><input type="file" name="file"></td>
                </tr>
                <tr>
                    <td>开始上传</td>
                    <td><input type="submit" value="上传"></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>

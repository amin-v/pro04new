<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="fa">
    <meta charset="UTF-8">
    <head>
        <title> home</title>
        <link rel="stylesheet" href="/style/bootstrap.css"/>
        <link rel="stylesheet" href="/style/bootstrap.min.css"/>
        <link rel="stylesheet" href="/style/bootstrap-theme.css"/>
        <link rel="stylesheet" href="/style/bootstrap-theme.min.css"/>
        <script src="/style/bootstrap.js"></script>
        <script src="/style/bootstrap.min.js.js"></script>
    </head>


<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">WebSiteName</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#">Page 1</a></li>
            <li><a href="#">Page 2</a></li>
            <li><a href="#">Page 3</a></li>
        </ul>
    </div>
</nav>
    <title><%=request.getAttribute("title")%></title>
</head>

<div class="pageHeader">
</div>
<div><h6>ا home</h6></div>
<div class="content">
    <p><b><%=request.getAttribute("header")%></b></p>
    <br>
    <br>
    <a href="/index.jsp" class="button">بازگشت به صفحه اول</a>

</div>
</body>
</html>

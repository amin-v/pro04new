<%--
  Created by IntelliJ IDEA.
  User: Amin
  Date: 9/12/2020
  Time: 3:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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

<div class="container">
    <div class="panel panel-info">
        <div class="panel-heading text-center">
            <h2>لطفا انتخاب کنید‌</h2>
        </div>
        ‌
        <div class="panel-body">
            <div class="row">
                <div class="col-lg-6">
                    <form action="/realPerson/">
                        <input type="submit" class="btn btn-info" value="شخص حقیقی"/>
                    </form>
                </div>
                <div class="col-lg-6">
                    <form action="/legalPerson/">
                        <input type="submit" class="btn btn-info" value="شخص حقوقی"/>
                    </form>
                </div>
                <br>
                <br>
                <br>
                <div class="col-lg-6">
                    <form action="/loan/FacilityProfile.jsp">
                <input type="submit" class="btn btn-info" value="ایجاد تسهیلات جدید"/>
                    </form>
                </div>
                <br/>
                <div class="col-lg-6">
                    <form action="/loan/FacilityAccount.jsp">
                        <input type="submit" class="btn btn-info" value="تشکیل پرونده تسهیلاتی"/>
                    </form>
                </div>
                <br/>
            </div>
        </div>
    </div>

</div>

</body>
</html>

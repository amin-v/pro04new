<%--
  Created by IntelliJ IDEA.
  User: Amin
  Date: 9/28/2020
  Time: 10:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>loan Type home</title>
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
    <h1 style="color: saddlebrown">لطفا اطلاعات زیر را وارد نمایید:</h1>
    <br><br/>
    <div class="jumbotron jumbotron-fluid">
        <form action="/facilityProfile/signUp.do" >
            <div class="form-group">
                <label for="loanName">loanName</label>
                <input type="text" class="form-control" id="loanName" name="loanName">
            </div>
            <div class="form-group">
                <label for="interestRate">interestRate</label>
                <input type="text" class="form-control" id="interestRate" name="interestRate">
            </div>
            <input type="submit" value="REGISTER" class="btn btn-primary"/>
        </form>
        <p>${param.state}</p>
    </div>
</div>
</body>
</html>

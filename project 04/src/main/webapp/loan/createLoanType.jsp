<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Amin
  Date: 9/30/2020
  Time: 8:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> home</title>
    <link rel="stylesheet" href="/style/bootstrap.css"/>
    <link rel="stylesheet" href="/style/bootstrap.min.css"/>
    <link rel="stylesheet" href="/style/bootstrap-theme.css"/>
    <link rel="stylesheet" href="/style/bootstrap-theme.min.css"/>
    <script src="/style/bootstrap.js"></script>
    <script src="/style/bootstrap.min.js.js"></script>
    <script src="x.js"></script>
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

<div class="panel panel-info">
    <div class="panel panel-heading">
        <form >
            <input type="text" id="loanName1" name="loanName1" placeholder="loanName"/>
            <input type="text" id="minDuration1" name="minDuration1" placeholder="minDuration"/>
            <input type="text" id="maxDuration1" name="maxDuration1" placeholder="maxDuration"/>
            <input type="text" id="minAmount1" name="minAmount1" placeholder="minAmount"/>
            <input type="text" id="maxAmount1" name="maxAmount1" placeholder="maxAmount"/>
            <input type="text" id="interestRate1" name="interestRate1" placeholder="interestRate"/>
            <input type="submit" value="create" onclick="createLoan()">
        </form>
        <p>${param.state}</p>
        <p>${requestScope.errorMessage}</p>
    </div>
    <div id="resultCreate"></div>

</div>
</body>
</html>

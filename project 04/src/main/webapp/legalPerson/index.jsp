<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Amin
  Date: 9/12/2020
  Time: 3:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>legal person home</title>
    <link rel="stylesheet" href="/style/bootstrap.css" />
    <link rel="stylesheet" href="/style/bootstrap.min.css" />
    <link rel="stylesheet" href="/style/bootstrap-theme.css" />
    <link rel="stylesheet" href="/style/bootstrap-theme.min.css" />
    <script src="/style/bootstrap.js" ></script>
    <script src="/style/bootstrap.min.js.js" ></script>
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
    <br/><br/>
    <div class="jumbotron jumbotron-fluid">
        <form action="/legalPerson/signUp.do">
            <div class="form-group">
                <label for="company">company</label>
                <input type="text" class="form-control" id="company" name="company">
            </div>
            <div class="form-group">
                <label for="registerDate">RegisterDate</label>
                <input type="date" class="form-control" id="registerDate" name="registerDate">
            </div>
            <div class="form-group">
                <label for="economicCode">economicCode</label>
                <input type="text" class="form-control" id="economicCode" name="economicCode">
            </div>

            <input type="submit" value="REGISTER" class="btn btn-primary"/>

        </form>
        <p>${param.state}</p>
    </div>
    <br/><br/>
    <div class="panel panel-info">
        <div class="panel-heading">

            <form class="form-group" action="/legalPerson/findById.do">
                <input class="form-group" name="id" placeholder="customerNumber" type="text">
                <input class="btn btn-info" type="submit" value="SEARCH">
            </form>
            <br/>
            <form class="form-group" action="/legalPerson/findByEconomicCode.do">
                <input class="form-group" name="economicCode" placeholder="economicCode" type="number">
                <input class="btn btn-info" type="submit" value="SEARCH">
            </form>
            <br/>

                <form class="form-group" action="/legalPerson/findByCompany.do">
                    <input class="form-group" name="company" placeholder="company" type="text"/>
                    <input type="submit" class="btn btn-info" value="SEARCH"/>
                </form>
            <p>${requestScope.errorMessage}</p>

        </div>
        <div class="panel-body">
            <table class="table-hover">
                <tr>
                    <th><input class="form-control" type="text" readonly value="customer number"></th>
                    <th><input class="form-control" type="text" readonly value="company"></th>
                    <th><input class="form-control" type="text" readonly value="economicCode"></th>
                    <th><input class="form-control" type="text" readonly value="RegisterDate"></th>
                </tr>
                <c:forEach items="${requestScope.legalPersons}" var="legalPerson">
                    <form class="form-group" action="/legalPersonPerson/update.do">
                        <tr>
                            <td><input type="number" name="id" id="id" class="form-control" value="${legalPerson.id}" readonly/></td>
                            <td><input type="text" name="company" class="form-control" value="${legalPerson.company}"/></td>
                            <td><input type="text" name="economicCode" class="form-control" value="${legalPerson.economicCode}"/></td>
                            <td><input type="date" name="RegisterDate" class="form-control" value="${legalPerson.registerDate}"/></td>
                            <td><input type="submit" class="btn btn-info" value="UPDATE"/></td>
                            <td><input type="button" class="btn btn-danger" value="DELETE" onclick="deletePerson(${legalPerson.id})"/></td>
                        </tr>
                    </form>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<script>
    function deletePerson(id) {
        if (confirm("are you sure?")) {
            window.location = "/legalPerson/delete.do?id=" + id;
        }
    }
</script>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
</body>
</html>

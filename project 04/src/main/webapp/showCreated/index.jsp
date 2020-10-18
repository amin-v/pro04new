<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <div class="panel-heading">your operation was successfully done</div>
        <div class="panel-body">
            <c:choose>
                <c:when test="${requestScope.legalPerson.legalPersonId!=null}">
                    <table class="table-hover">

                        <tr>
                        <tr>
                            <th><input class="form-control" type="text" readonly value="customer number"></th>
                            <th><input class="form-control" type="text" readonly value="company"></th>
                            <th><input class="form-control" type="text" readonly value="register date"></th>
                            <th><input class="form-control" type="text" readonly value="economic code"></th>
                        </tr>
                        </tr>
                        <form class="form-group" action="/legalPerson/update.do">
                            <tr>
                                <td> <input type="number" name="id" id="id" class="form-control" value="${requestScope.legalPerson.legalPersonId}" readonly /> </td>
                                <td> <input type="text" name="company" class="form-control" value="${requestScope.legalPerson.company}" /> </td>
                                <td> <input type="date" name="registerDate" class="form-control" value="${requestScope.legalPerson.registerDate}"  /> </td>
                                <td> <input type="text" name="economicCode" class="form-control" value="${requestScope.legalPerson.economicCode}"  /> </td>
                                <td> <input type="submit" class="btn btn-info" value="UPDATE" /> </td>
                                <td> <input type="button" class="btn btn-danger"  value="DELETE" onclick="deleteLegalPerson(${requestScope.legalPerson.legalPersonId})" /> </td>
                            </tr>
                        </form>
                    </table>
                </c:when>

                <c:when test="${requestScope.realPerson.realPersonId!=null}">
                <table class="table-hover">
                    <tr>
                        <th><input class="form-control" type="text" readonly value="customer number"></th>
                        <th><input class="form-control" type="text" readonly value="name"></th>
                        <th><input class="form-control" type="text" readonly value="family"></th>
                        <th><input class="form-control" type="text" readonly value="father name"></th>
                        <th><input class="form-control" type="text" readonly value="birth date"></th>
                        <th><input class="form-control" type="text" readonly value="national code"></th>
                    </tr>
                    <form class="form-group" action="/realPerson/update.do">

                        <tr>
                            <td><input type="number" name="id" id="id" class="form-control" value="${requestScope.realPerson.realPersonId}" readonly /></td>
                            <td><input type="text" name="name" class="form-control" value="${requestScope.realPerson.name}"  /></td>
                            <td><input type="text" name="family" class="form-control" value="${requestScope.realPerson.family}"  /></td>
                            <td><input type="text" name="fatherName" class="form-control" value="${requestScope.realPerson.fatherName}"  /></td>
                            <td><input type="date" name="birthDate" class="form-control" value="${requestScope.realPerson.birthDate}"  /></td>
                            <td><input type="number" name="nationalCode" class="form-control" value="${requestScope.realPerson.nationalCode}"  /></td>
                            <td> <input type="submit" class="btn btn-info" value="UPDATE" /> </td>
                            <td> <input type="button" class="btn btn-danger" value="DELETE" onclick="deleteRealPerson(${requestScope.realPerson.realPersonId})" /> </td>
                        </tr>
                    </form>
                </table>
                </c:when>
            </c:choose>
        </div>
    </div>
</div>
<script>
    function deleteRealPerson(id) {
        if(confirm("are you sure?")){
            window.location= "/realPerson/delete.do?id="+id;
        }
    }

    function deleteLegalPerson(id) {
        if(confirm("are you sure?")){
            window.location= "/legalPerson/delete.do?id="+id;
        }
    }
</script>
</body>
</html>

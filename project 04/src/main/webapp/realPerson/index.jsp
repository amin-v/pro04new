<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>real person home</title>
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
    <br/><br/>
    <div class="jumbotron jumbotron-fluid">
        <form name="myForm" action="/realPerson/signUp.do" onsubmit="return validate()" method="post">
            <div class="form-group">
                <label for="name">name</label>
                <input type="text" class="form-control" id="name" name="name">
            </div>
            <div class="form-group">
                <label for="family">family</label>
                <input type="text" class="form-control" id="family" name="family">
            </div>
            <div class="form-group">
                <label for="fatherName">name of father</label>
                <input type="text" class="form-control" id="fatherName" name="fatherName">
            </div>
            <div class="form-group">
                <label for="birthDate">birth date</label>
                <input type="date" class="form-control" id="birthDate" name="birthDate">
            </div>
            <div class="form-group">
                <label for="nationalCode">national code</label>
                <input type="number" class="form-control" id="nationalCode" name="nationalCode">
            </div>

            <input type="submit" value="REGISTER" class="btn btn-primary"/>

        </form>
        <p>${param.state}</p>
    </div>
    <br/><br/>
    <div class="panel panel-info">
        <div class="panel-heading">
            <form class="form-group" action="/realPerson/conditionalFind">
                <input class="form-group" name="name" placeholder="name" type="text">
                <input class="form-group" name="family" placeholder="family" type="text">
                <input class="form-group" name="fatherName" placeholder="father name" type="text">
                <input class="btn btn-info" type="submit" value="SEARCH">
            </form>
            <br/>
            <form class="form-group" action="/realPerson/findByCustomerNumber.do">
                <input class="form-group" name="customerNumber" placeholder="customerNumber" type="text">
                <input class="btn btn-info" type="submit" value="SEARCH">
            </form>
            <br/>
            <form class="form-group" action="/realPerson/findByNationalCode.do">
                <input class="form-group" name="nationalCode" placeholder="nationalCode" type="text">
                <input class="btn btn-info" type="submit" value="SEARCH">
            </form>
            <p>${requestScope.errorMessage}</p>
        </div>
        <div class="panel-body">
            <table class="table-hover">
                <tr>
                    <th><input class="form-control" type="text" readonly value="customer number"></th>
                    <th><input class="form-control" type="text" readonly value="name"></th>
                    <th><input class="form-control" type="text" readonly value="family"></th>
                    <th><input class="form-control" type="text" readonly value="father name"></th>
                    <th><input class="form-control" type="text" readonly value="birth date"></th>
                    <th><input class="form-control" type="text" readonly value="national code"></th>
                </tr>
                <c:forEach items="${requestScope.realPersons}" var="realPerson">
                    <form class="form-group" action="/realPerson/update.do">
                        <tr>
                            <td><input type="number" name="id" id="id" class="form-control" value="${realPerson.realPersonId}" readonly/></td>
                            <td><input type="text" name="name" class="form-control" value="${realPerson.name}" /></td>
                            <td><input type="text" name="family" class="form-control" value="${realPerson.family}"/></td>
                            <td><input type="text" name="fatherName" class="form-control" value="${realPerson.fatherName}"/></td>
                            <td><input type="date" name="birthDate" class="form-control" value="${realPerson.birthDate}"/></td>
                            <td><input type="number" name="nationalCode" class="form-control" value="${realPerson.nationalCode}"/></td>
                            <td><input type="submit" class="btn btn-info" value="UPDATE"/></td>
                            <td><input type="button" class="btn btn-danger" value="DELETE" onclick="deletePerson(${realPerson.realPersonId})"/></td>
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
            window.location = "/realPerson/delete.do?id=" + id;
        }
    }
</script>

<script>

        function validate() {
        var code = document.forms["myForm"]["nationalCode"].value;
        if (code.length == 10) {
        var rightMostNumber = parseInt(code.charAt(9));
        var sum = parseInt(code.charAt(0)) * 10 +
        parseInt(code.charAt(1)) * 9 +
        parseInt(code.charAt(2)) * 8 +
        parseInt(code.charAt(3)) * 7 +
        parseInt(code.charAt(4)) * 6 +
        parseInt(code.charAt(5)) * 5 +
        parseInt(code.charAt(6)) * 4 +
        parseInt(code.charAt(7)) * 3 +
        parseInt(code.charAt(8)) * 2;

        var result = sum % 11 ;
        if (result == rightMostNumber || result == 11 - rightMostNumber){
        return true
        }else {
        alert("کد ملی صحیح نمی باشد.");
        return false;
        }
        } else {
        alert("کد ملی باید ده رقمی باشد. ");
        return false;
        }
        }
</script>

<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
</body>
</html>

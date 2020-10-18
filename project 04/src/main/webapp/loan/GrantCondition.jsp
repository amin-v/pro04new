<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.entity.FacilityProfile" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% FacilityProfile facilityProfile = (FacilityProfile) request.getAttribute("facilityProfile");
%>

<html>
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
<script type="text/javascript" src="/loan/create-table.js"></script>
<title>تعریف شروط اعطا تسهیلات</title>
</head>

<div class="container">
    <div class="panel panel-info">
        <div class="panel-heading text-center">
            <h2> تسهیلات <%=facilityProfile.getLoanName()%> با نرخ سود <%=facilityProfile.getInterestRate()%> درصد</h2>
        </div>
    </div>
    <div class="panel-heading text-right">
        <h3 style="color: saddlebrown">:لطفا شرایط اعطا را وارد نمایید</h3>
    </div>
    <br>
    <div class="jumbotron jumbotron-fluid">
    <form action="/facilityProfile/CreateGrantCondition.do" method="post">
            <div class="form-group">
                <label for="grantName">نام</label>
              <input name="grantName"   id="grantName" type="text" placeholder="نام">
            </div>

        <div class="form-group">
            <label for="minDuration">حداقل مدت </label>
               <input name="minDuration" id="minDuration" type="number" placeholder="  حداقل مدت قرارداد">
        </div>

        <div class="form-group">
            <label for="maxDuration">حداکثر مدت </label>
                <input name="maxDuration" id="maxDuration" type="number" placeholder="  حداکثر مدت قرارداد">
        </div>

        <div class="form-group">
            <label for="minAmount">حداقل مبلغ  </label>
                <input name="minAmount" id="minAmount" type="number" placeholder="  حداقل مبلغ قرارداد">
        </div>

        <div class="form-group">
            <label for="minAmount">حداکثر مبلغ </label>
           <input name="maxAmount" id="maxAmount" type="number" placeholder="  حداکثر مبلغ قرارداد">
        </div>


        <input type="text" name="loanName" value="<%=request.getParameter("loanName")%>">
        <input type="text" name="interestRate" value="<%=request.getParameter("interestRate")%>">
        <input type="number" name="rowNumber" id="rowNumber">
        <input type="submit" class="button" value="ثبت اطلاعات">

        <div class="searchTable">
            <table align="center" id="grantTableId">
            </table>
        </div>

        <button class="button" onclick="showTable()">نمایش</button>

    </form>
</div>

    <div class="panel-body">
        <table class="table-hover">
            <tr>
                <th><input class="form-control" type="text" readonly value="rowNumber"></th>
                <th><input class="form-control" type="text" readonly value="loanName"></th>
                <th><input class="form-control" type="text" readonly value="minDuration"></th>
                <th><input class="form-control" type="text" readonly value="maxDuration"></th>
                <th><input class="form-control" type="text" readonly value="minAmount"></th>
                <th><input class="form-control" type="text" readonly value="maxAmount"></th>
            </tr>

            <c:forEach items="${requestScope.grantConditons}" var="grantCondition">
                <form class="form-group" action="/grantCondition/find.do">
                    <tr>
                        <td><input type="number" name="id" id="id" class="form-control" value="${grantCondition.GrantConditionId}" readonly/></td>
                        <td><input type="text" name="name" class="form-control" value="${grantCondition.name}" /></td>
                        <td><input type="text" name="minDuration" class="form-control" value="${grantCondition.minDuration}"/></td>
                        <td><input type="text" name="maxDuration" class="form-control" value="${grantCondition.maxDuration}"/></td>
                        <td><input type="date" name="minAmount" class="form-control" value="${grantCondition.minAmount}"/></td>
                        <td><input type="number" name="maxAmount" class="form-control" value="${grantCondition.maxAmount}"/></td>
                        <td><input type="submit" class="btn btn-info" value="Find"/></td>
                        <td><input type="button" class="btn btn-danger" value="نمایش" onclick="showTable()"/></td>
                    </tr>
                </form>
            </c:forEach>
        </table>

    </div>
</div>
</body>
</html>
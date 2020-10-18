<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table class="table-hover">
    <tr>
        <th><input class="form-control" type="text" readonly value="loanTypeId"></th>
        <th><input class="form-control" type="text" readonly value="loanName"></th>
        <th><input class="form-control" type="text" readonly value="minDuration"></th>
        <th><input class="form-control" type="text" readonly value="maxDuration"></th>
        <th><input class="form-control" type="text" readonly value="minAmount"></th>
        <th><input class="form-control" type="text" readonly value="maxAmount"></th>
        <th><input class="form-control" type="text" readonly value="interestRate"></th>
    </tr>
    <c:forEach items="${requestScope.listLoan}" var="loanType">
    <form class="form-group" action="loanType/find.do">

        <tr>
            <td><input type="text" name="loanTypeId" id="id" class="form-control" value="${loanType.loanTypeId}" readonly></td>
            <td><input type="text" name="loanName" id="loanName" class="form-control" value="${loanType.loanName}" readonly></td>
            <td><input type="text" name="minDuration" id="minDuration" class="form-control" value="${loanType.minDuration}" readonly></td>
            <td><input type="text" name="maxDuration" id="maxDuration" class="form-control" value="${loanType.maxDuration}" readonly></td>
            <td><input type="text" name="minAmount" id="minAmount" class="form-control" value="${loanType.minAmount}" readonly></td>
            <td><input type="text" name="maxAmount" id="maxAmount" class="form-control" value="${loanType.maxAmount}" readonly></td>
            <td><input type="text" name="minAmount" id="interestRate" class="form-control" value="${loanType.interestRate}" readonly></td>
            <td><input type="submit" class="btn btn-info" value="UPDATE"/></td>
        </tr>
    </form>
    </c:forEach>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Save Travels</h1>
	<table>
		<tr>
			<th>Expense</th>
			<th>Vendor</th>
			<th>Amount</th>
			<th>Actions</th>
		</tr>
		<c:forEach items = "${allExpenses}" var= "oneExpense">
			<tr>
				<td><c:out value = "${oneExpense.expenseName }"/></td>
				<td><c:out value = "${oneExpense.vendor }"/></td>
				<td><c:out value = "${oneExpense.amount }"/></td>
				<td><a href="/edit/${oneExpense.id}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>


	<h2>Add an expense:</h2>
	<form:form action="/expense/create" method = "post" modelAttribute="expense">
		<div>
			<form:label path= "expenseName">Expense Name:</form:label>
			<form:errors path="expenseName" class="text-danger"/>
			<form:input type="text" path="expenseName"/>
		</div>
		<div>
			<form:label path="vendor">Vendor:</form:label>
			<form:errors path="vendor" class="text-danger"/>
			<form:input type="text" path="vendor"/>
		</div>
		<div>
			<form:label path="amount">Amount</form:label>
			<form:errors path="amount" class="text-danger"/>
			<form:input type="number" path="amount"/>
		</div>
		<div>
			<form:label path="description">Description</form:label>
			<form:errors path="description" class="text-danger"/>
			<form:textarea path="description" cols="30" rows="10"></form:textarea>
		</div>
		<button>Submit</button>
	</form:form>
</body>
</html>
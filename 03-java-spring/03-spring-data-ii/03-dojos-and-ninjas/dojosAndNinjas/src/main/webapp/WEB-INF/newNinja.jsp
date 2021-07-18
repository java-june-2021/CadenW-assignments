<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add A Ninja</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Add A Ninja</h1>
		<form:form method="POST" action="/ninja/add" modelAttribute="ninja">
			<form:label path="dojo">Dojo</form:label>
			<form:errors path="dojo"/>
			<form:select path="dojo">
				<c:forEach items="${dojos}" var="dojo">
					<option value="${dojo.id}">${dojo.name}</option>
				</c:forEach>
				</form:select>
			<div class="form-group">
				<form:label path="firstName">First Name:</form:label>
				<form:errors path="firstName"/>
				<form:input path="firstName"/>
			</div>
			<div class="form-group">
				<form:label path="lastName">Last Name:</form:label>
				<form:errors path="lastName"/>
				<form:input path="lastName"/>
			</div>
					<div class="form-group">
				<form:label path="age">Age:</form:label>
				<form:errors path="age"/>
				<form:input path="age"/>
			</div>
			<button>Add Ninja</button>
		</form:form>
	</div>
</body>
</html>
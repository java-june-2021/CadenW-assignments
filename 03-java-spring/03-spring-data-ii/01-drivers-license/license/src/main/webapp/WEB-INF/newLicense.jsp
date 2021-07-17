<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Create A New license</h1>
		<form:form action="/newLicense" mewthod="POST" modelAttribute="license">
		<form:label path="user">Select User</form:label>
		<form:errors path="user"/>
		<form:select path="user">
		<c:forEach items="${user}" var="user">
			<option value="${user.id}">${user.firstName} ${user.lastName}</option>
		</c:forEach>
		</form:select>
		<form:label path="expiration">Expiration Date:</form:label>
		<form:errors path="expiration"/>
		<form:input type="date" path="expiration"/>
		<form:label path="state">State:</form:label>
		<form:errors path="state"/>
		<form:input path="state"/>
		<button>Add License</button>
		
		</form:form>
	</div>

</body>
</html>
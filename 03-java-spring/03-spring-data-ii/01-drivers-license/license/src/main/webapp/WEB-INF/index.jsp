<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Welcome To The DMV</h1>
		<a href="/user/new">Create A New User</a>
		<a href="/license/new">Create A New License</a>
		<c:forEach items="${users}" var="user">
		<ul>
			<li><a href="/show/${user.id}">${user.firstName}</a></li>
			<li>${user.lastName}</li>
			<li>${user.license.returnLicenseNumber()}</li>
		</ul>
		</c:forEach>
	</div>
</body>
</html>
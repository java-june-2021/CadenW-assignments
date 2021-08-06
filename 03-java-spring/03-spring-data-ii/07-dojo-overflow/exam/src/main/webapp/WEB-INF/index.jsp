<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exam</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Welcome</h1>
		<div class="row">
			<div class="col">
				<h2>Login</h2>
				<p>${loginError}</p>
				<form method="POST" action="/login">
					<div class="form-group">
						<label class="form-label">Email:</label>
						<input class="form-control" type="email" name="lemail">
					</div>
					<div class="form-group">
						<label class="form-label">Password:</label>
						<input class="form-control" type="password" name="lpassword">
					</div>
					<button class="btn btn-primary mt-3">Login</button>
				</form>
			</div>
		</div>
			<div class="col">
				<h2>Register</h2>
				<form:form action="/register" memthod="POST" modelAttribute="user">
					<div class="form-group">
						<form:label path="firstName">First Name:</form:label>
						<form:errors path="firstName"/>
						<form:input class="form-control" path="firstName"/>
					</div>
					<div class="form-group">
						<form:label path="lastName">Last Name:</form:label>
						<form:errors path="lastName"/>
						<form:input class="form-control" path="lastName"/>
					</div>
					<div class="form-group">
						<form:label path="email">Email:</form:label>
						<form:errors path="email"/>
						<form:input type="email" class="form-control" path="email"/>
					</div>
					<div class="form-group">
						<form:label path="password">Password:</form:label>
						<form:errors path="password"/>
						<form:input type="password" class="form-control" path="password"/>
					</div>
					<div class="form-group">
						<form:label path="confirmPassword">Confirm Password:</form:label>
						<form:errors path="confirmPassword"/>
						<form:input type="password" class="form-control" path="confirmPassword"/>
					</div>
					<button class="btn btn-primary mt-3">Register</button>
				</form:form>
			</div>
	</div>
</body>
</html>
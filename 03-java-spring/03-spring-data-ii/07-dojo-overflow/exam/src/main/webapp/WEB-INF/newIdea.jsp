<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Idea</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Create A New Idea ${thisUser.firstName} ${thisUser.lastName}</h1>
		<a href="/logout">Logout</a>
		<form:form method="POST" action="/createIdea" modelAttribute="idea">
		<form:label path="content">Content:</form:label>
		<form:errors path="content"/>
		<form:input path="content"/>
		<form:hidden path="user" value="${thisUser.id}"/>
		<button>Create</button>
		</form:form>
		
	</div>

</body>
</html>
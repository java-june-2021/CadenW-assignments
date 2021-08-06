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
		<h1>${idea.content}</h1>
		<p>Created By:  ${idea.user.getFirstName()} ${idea.user.getLastName()}</p>
		<h1>Users Who Liked This Idea:</h1>
		<c:forEach items="${idea.likers}" var="user">
		<ul>
			<li>${user.firstName} ${user.lastName}</li>
		</ul>
		</c:forEach>
			<a href="/edit/${idea.id}">Edit</a>
	</div>
</body>
</html>
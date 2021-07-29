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
		<h1>Welcome To Blogs.com</h1>
		<h3>Hello ${user.firstName}</h3>
		<hr>
		<form:form method="POST" action="/dashboard/newThought" modelAttribute="thought">
		<div class="form-control">
			<form:label path="post">Post A Great Thought</form:label>
			<form:errors path="post"/>
			<form:input path="post"/>
		</div>
		<form:input type="hidden" value="${user.id}" path="user"/>
		<button>Post</button>
		</form:form>
		<c:forEach items="${allThoughts}" var="thought">
		<p>${thought.user.firstName} says: ${thought.post}</p>
		<p><a href="/dashboard/${thought.id}/delete">Delete</a> 
		<p><a href="/dashboard/${thought.id}">Details</a> | <c:out value="${thought.usersWhoLiked.size()}"/> People like this</p>
		</c:forEach>
	</div>
</body>
</html>
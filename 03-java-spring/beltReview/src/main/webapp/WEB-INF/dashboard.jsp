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
		<h1 class="text-center">Hello ${user.firstName} Welcome To Blogs.com</h1>
		<a href="/logout" class="btn btn-secondary">Logout</a>
		<a href="/dashboard/${user.id}/profile" class="btn btn-secondary">Profile</a>
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
		<p>${thought.user.firstName}:</p>
		<p>${thought.post}</p>
		<c:choose>
			<c:when test="${thought.usersWhoLiked.size() == 1}">
				<p><c:out value="${thought.usersWhoLiked.size()}"/> Like</p>
			</c:when> 
			<c:otherwise>
				<p><c:out value="${thought.usersWhoLiked.size()}"/> Likes</p>
			</c:otherwise>
		</c:choose> 
		<c:choose>
			<c:when test="${thought.user.id == user.id}">
				<p><a href="/dashboard/${thought.id}/delete">Delete</a></p>
			</c:when> 
		</c:choose> 
		<p><a href="/dashboard/${thought.user.id}/profile">${thought.user.firstName}'s Profile</a></p>
		<c:choose>
	<c:when test="${thought.usersWhoLiked.contains(user)}">
		<a href="/dashboard/unlike/${thought.id}" class="btn btn-primary">Unlike</a>
	</c:when>
	<c:otherwise>
		<a href="/dashboard/like/${thought.id}" class="btn 	btn-primary">like</a>
	</c:otherwise>
	</c:choose>
	<hr>
		</c:forEach>
		<hr>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${user.firstName}'s Profile</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1 class="text-center">Welcome to ${user.firstName}'s Profile</h1>
		<a href="/dashboard">Home</a>
		<h2>Name: ${user.firstName} ${user.lastName}</h2>
		<img alt="Profile Pic" src="/main/resources/img/profile.jpg">
		<h4>Email: ${user.email}</h4>
		<hr>
		<c:forEach items="${user.thoughts}" var="thought">
		<p>${user.firstName} says: ${thought.post} </p>
		<c:choose>
			<c:when test="${thought.user.id == loggedInUser.id}">
				<p><a href="/dashboard/${thought.id}/delete">Delete</a></p>
			</c:when> 
		</c:choose> 
		<c:choose>
			<c:when test="${thought.usersWhoLiked.size() == 1}">
				<p><c:out value="${thought.usersWhoLiked.size()}"/> Like</p>
			</c:when> 
			<c:otherwise>
				<p><c:out value="${thought.usersWhoLiked.size()}"/> Likes</p>
			</c:otherwise>
		</c:choose> 
		<c:choose>
			<c:when test="${thought.usersWhoLiked.contains(user)}">
				<a href="/dashboard/unlike/${thought.id}" class="btn btn-primary">Unlike</a>
			</c:when>
			<c:otherwise>
			<a href="/dashboard/like/${thought.id}" class="btn 	btn-primary">like</a>
			</c:otherwise>
		</c:choose>
		<h5>Comments:</h5>
		<c:forEach items="${thought.comments}" var="comment">
		<p>${comment.user.firstName} Said: ${comment.tComment}</p>	
		<hr>
		</c:forEach>
		</c:forEach>
	</div>
</body>
</html>
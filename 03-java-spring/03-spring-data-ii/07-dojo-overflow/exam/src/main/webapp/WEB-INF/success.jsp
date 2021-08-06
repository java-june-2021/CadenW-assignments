<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Logged In</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Welcome, ${thisUser.firstName} ${thisUser.lastName}</h1>
		<a href="/logout">Logout</a>
		<h3>Ideas</h3>
				<table class="table table-dark">
		<thead>
		<tr>
		<th>Idea</th>
		<th>Created By</th>
		<th>Likes</th>
		<th>Action</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${allIdeas}" var="idea">
		<tr>
		<td><a href="/show/${idea.id}">${idea.content}</a></td>
		<td>${idea.getUser().firstName} ${idea.getUser().lastName}</td>
		<td>${idea.likers.size()}</td>
		<td>
		<c:choose>
		<c:when test="${idea.likers.contains(thisUser)}">
		<a href ="/unlike/${idea.id}">Remove Like</a>
		</c:when>
		<c:otherwise>
		<a href="/like/${idea.id}">Like</a>
		</c:otherwise>
		</c:choose>
		</td>
		</tr>
		</c:forEach>
		</tbody>
		</table>
		<a href="/newIdea" class="btn btn-secondary">Add An Idea</a>
	</div>
</body>
</html>
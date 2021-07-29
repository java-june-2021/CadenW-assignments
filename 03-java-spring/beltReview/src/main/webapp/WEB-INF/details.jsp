<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Thought Details</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
	<c:out value="${thought.user.firstName}"/> Says: <p>${thought.post}</p>
	<c:choose>
	<c:when test="${thought.usersWhoLiked.contains(user)}">
		<a href="/dashboard/unlike/${thought.id}" class="btn btn-primary">Unlike</a>
	</c:when>
	<c:otherwise>
		<a href="/dashboard/like/${thought.id}" class="btn 	btn-primary">like</a>
	</c:otherwise>
	</c:choose>
	<hr>
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
		</tr>
		<c:forEach items="${thought.usersWhoLiked}" var="user">
		<tr>
			<td>${user.firstName}</td>
			<td>${user.lastName}</td>
		</tr>
		</c:forEach>
	</table>
</div>
</body>

</html>
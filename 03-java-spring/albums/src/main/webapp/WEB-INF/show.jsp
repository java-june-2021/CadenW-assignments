<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "t" tagdir="/WEB-INF/tags" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<t:nav>
		<h1>Album details</h1>
		<i>Added By: <a href="/profile/${album.user.id}">${album.user.firstName} ${album.user.lastName}</a></i>
		<hr>
		<p>Band Name: ${album.bandName}</p>
		<p>Album Name: ${album.albumName}</p>
		<p>Release Year: ${album.releaseYear}</p>
		<h2>Songs</h2>
		<c:forEach items="${album.songs}" var="song">
		<p>${song.name} - <i>${song.length}</i> ${song.genre}</p>
		</c:forEach>
		<c:choose>
		<c:when test="${album.label != null}">
		<h1>Label Information</h1>
		<p>Label Name: ${album.label.name}</p>
		<p>Label Location: ${album.label.city}</p>
		</c:when>
		<c:otherwise>
		<h3>Put In label Information</h3>
		<form:form method="POST" action="/${album.id}/addLabel" modelAttribute="label">
					<div class="form-group">
				<form:label path="name">Label Name</form:label>
				<form:errors path="name"/>
				<form:input path="name"/>
			</div>
			<div class="form-group">
				<form:label path="city">Label Location</form:label>
				<form:errors path="city"/>
				<form:input path="city"/>
			</div>
			<button>Add Label</button>
		</form:form>
		</c:otherwise>
		</c:choose>
		
		<c:if test="${album.user.id == userThatsLoggedIn}">
		<a href="/${album.id}/edit" class="btn btn-primary">Edit Album</a>
		<a href="/${album.id}/delete" class="btn btn-danger">Delete Album</a>
		</c:if>
	</t:nav>
</body>
</html>
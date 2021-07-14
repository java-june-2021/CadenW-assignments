<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add A Song</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<a href="/dashboard">Dash Board</a>
		<h1>Add A New Song</h1>
		<form:form action="/addSong" method="POST" modelAttribute="song">
			<div class="form-group">
				<form:label path="title">Title</form:label>
				<form:errors path="title"/>
				<form:input path="title"/>
			</div>
			<div class="form-group">
				<form:label path="artist">Artist</form:label>
				<form:errors path="artist"/>
				<form:input path="artist"/>
			</div>
			<div class="form-group">
				<form:label path="rating">Rating</form:label>
				<form:errors path="rating"/>
				<form:input path="rating"/>
			</div>
				<button>Add Song</button>
		</form:form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lookify</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<a href="/new">Add A Song!</a>
		<a href="/topTen">Top Ten Songs</a>
		<div class="navbar navbar-expand-lg navbar-light bg-light">
		    <form class="d-flex" action="/search" method="GET">
        		<input class="form-control me-2" type="text" name="artist">
        		<button class="btn btn-outline-success" type="submit">Search</button>
		    </form>
    	</div>
		<h1>Welcome To Lookify!</h1>
		<table class="table table-light">
			<thead>
				<tr>
					<th>Title</th>
					<th>Artist</th>
					<th>Rating</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${allSongs}" var="song">
				<tr>
					<td><a href="/song/${song.id}">${song.title}</a></td>
					<td>${song.artist}</td>
					<td>${song.rating}</td>
					<td><a href="/delete/${song.id}">Delete</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
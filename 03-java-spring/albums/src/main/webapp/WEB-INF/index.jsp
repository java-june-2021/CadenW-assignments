<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Albums</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<t:nav>
	<a class="btn btn-light" href="/profile/${user.id}">Profile</a>
	<table class="table table-light" style="background-color: #e3f2fd;">
		<thead>
			<tr>
				<th>Action</th>
				<th>Band Name</th>
				<th>Album Name</th>
				<th>Release Date</th>
				<th>Likes</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allAlbums}" var="album">
				<tr>
					<td>
					<c:choose>
					<c:when test="${album.likers.contains(user)}">
					<a href ="/unLike/${album.id}">Remove Like</a>
					</c:when>
					<c:otherwise>
					<a href="/like/${album.id}">Like</a>
					</c:otherwise>
					</c:choose>
					</td>
					<td><a href="/album/${album.id}">${album.bandName}</a></td>
					<td>${album.albumName}</td>
					<td>${album.releaseYear}</td>
					<td>${album.likers.size()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</t:nav>

</body>
</html>
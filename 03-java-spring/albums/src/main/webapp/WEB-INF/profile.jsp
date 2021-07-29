<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${userToDisplay.firstName}'s profile</title>
</head>
<body>
	<t:nav>
		<p>Profile For: ${userToDisplay.firstName} ${userToDisplay.lastName}</p>
		<hr>
		<h2>${userToDisplay.firstName}'s Albums</h2>
		<ul>
		<c:forEach items="${userToDisplay.albums}" var="album">
		<li><a href="/album/${album.id}">${album.bandName} - ${album.albumName}</a> - ${album.releaseYear}</li>
		</c:forEach>
		</ul>
	</t:nav>
</body>
</html>
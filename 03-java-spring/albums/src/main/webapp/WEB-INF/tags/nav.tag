<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enter Title</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<body>
	<div class="container">
		<h1 class="text-center">Top Music</h1>
		<nav>
			<a class="btn btn-light" href="/logout">Logout</a>
			<a class="btn btn-light" href="/albums">Dashboard</a>
			<a class="btn btn-light" href="/new">Add A New Album!</a>
			<a class="btn btn-light" href="/song/new">Add A Song To An Album!</a>
		</nav>
		<hr>
		<jsp:doBody/>
	</div>
</body>
</head>
</html>
s
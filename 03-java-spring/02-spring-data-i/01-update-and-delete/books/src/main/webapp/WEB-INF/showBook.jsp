<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${book.title}</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Book Details</h1>	
		<p>Book Title: ${book.title}</p>
		<p>Book Description: ${book.description}</p>
		<p>Book Language: ${book.language}</p>
		<p>Book Number Of Pages: ${book.numberOfPages}</p>
		<a href="/${book.id}/edit" class="btn btn-primary">Edit</a>
		<a href="/${book.id}/delete" class="btn btn-danger">Delete</a>
	</div>
</body>
</html>
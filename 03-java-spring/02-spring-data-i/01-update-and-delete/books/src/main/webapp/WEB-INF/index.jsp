<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books Books Books</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>All The Books</h1>
		<table class="table table-dark">
    		<thead>
	       		<tr>
		            <th>Title</th>
		            <th>Description</th>
		            <th>Language</th>
		            <th>Number of Pages</th>
		        </tr>
    		</thead>
    	<tbody>
        <c:forEach items="${allBooks}" var="book">
        <tr>
            <td><a href="/book/${book.id}">${book.title}</a></td>
            <td>${book.description}</td>
            <td>${book.language}</td>
            <td>${book.numberOfPages}</td>
        </tr>
        </c:forEach>
    	</tbody>
		</table>
		<a href="/new/book">New Book</a>
	</div>
</body>
</html>
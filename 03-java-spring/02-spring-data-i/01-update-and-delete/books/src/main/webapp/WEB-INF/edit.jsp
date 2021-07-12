<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit ${book.title}</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container"> 
		<h1>Edit ${book.title}</h1>
		<form:form action="/${book.id}/edit" method="POST" modelAttribute="book">
			<div class="form-group">
				<form:label path="title">Title:</form:label>
				<form:errors path="title"/>
				<form:input path="title"/>
			</div>
			<div class="form-group">
				<form:label path="description">Description:</form:label>
				<form:errors path="description"/>
				<form:input path="description"/>
			</div>
			<div class="form-group">
				<form:label path="language">Language</form:label>
				<form:errors path="language"/>
				<form:input path="language"/>
			</div>
			<div class="form-group">
				<form:label path="numberOfPages">Number Of Pages:</form:label>
				<form:errors path="numberOfPages"/>
				<form:input path="numberOfPages"/>
			</div>
		<button>Edit</button>
		</form:form>
	</div>
</body>
</html>
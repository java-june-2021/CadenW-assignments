<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Languages</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Languages!</h1>
		<table class="table table-dark">
			<thead>
				<tr>
					<th>Name</th>
					<th>Creator</th>
					<th>Version</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${allLanguages}" var="lang">
				<tr>
					<td><a href="/languages/${lang.id}">${lang.name}</a></td>
					<td>${lang.creator}</td>
					<td>${lang.version}</td>
					<td><a href="/languages/${lang.id}/edit">Edit</a>|<a href="languages/${lang.id}/delete">Delete</a></td>
				</tr>
			</c:forEach>
			</tbody>
			</table>
			<form:form action="/languages" method="POST" modelAttribute="language">
			<div class="form-group">
				<form:label path="name">Name</form:label>
				<form:errors path="name"/>
				<form:input path="name"/>
			</div>
			<div class="form-group">
				<form:label path="creator">Creator</form:label>
				<form:errors path="creator"/>
				<form:input path="creator"/>
			</div>
			<div class="form-group">
				<form:label path="version">Version</form:label>
				<form:errors path="version"/>
				<form:input path="version"/>
			</div>
		<button>Submit</button>
		</form:form>
	</div>
</body>
</html>
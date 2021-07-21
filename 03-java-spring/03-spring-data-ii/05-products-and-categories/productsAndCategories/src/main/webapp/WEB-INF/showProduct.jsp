<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Product</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1><c:out value="${product.name}"/></h1>
		<h1><c:out value="${product.description}"/></h1>
		<h1><c:out value="${product.price}"/></h1>
		
		<h2>Categories</h2>
		<ul>
			<c:forEach items="${product.categories}" var="cat">
			<li>${cat.name}</li>
			</c:forEach>
		</ul>
		<form method="POST" action="/addCatToProd/${product.id}">
			<select name="cats">
				<c:forEach items="${notInProd}" var="cat">
					<option value="${cat.id}">${cat.name}</option>
				</c:forEach>
			</select>
			<button>Add Category</button>
		</form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1><c:out value="${category.name}"/></h1>
		<h2>Products</h2>
		<ul>
			<c:forEach items="${category.products}" var="prod">
			<li>${prod.name}  |  ${prod.description}  |  $${prod.price}</li>
			</c:forEach>
		</ul>
		<form method="POST" action="/addProdToCat/${category.id}">
			<select name="prod">
				<c:forEach items="${notInCat}" var="prod">
					<option value="${prod.id}">${prod.name}</option>
				</c:forEach>
			</select>
			<button>Add Product</button>
		</form>
	</div>
</body>
</html>
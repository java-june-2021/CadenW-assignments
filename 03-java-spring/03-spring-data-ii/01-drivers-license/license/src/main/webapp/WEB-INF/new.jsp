<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
	<h1>New Person</h1>
		<form:form action="/new" method="POST" modelAttribute="user">
		
		<form:label path="firstName">First Name</form:label>
		<form:errors path="firstName"/>
		<form:input path="firstName"/>
		<form:label path="lastName">Last Name</form:label>
		<form:errors path="lastName"/>
		<form:input path="lastName"/>
		<button>Create</button>
		</form:form>
	</div>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>The Code</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
	<h1>Can You Guess The Code?</h1>
	
	<p class="error">${error}</p>
	<form action="/guess" method=POST>
	<label for="guess">Guess:</label>
	<input type="text" name="guess">
	<button>Submit Guess</button>
	</form>
</div>
</body>
</html>
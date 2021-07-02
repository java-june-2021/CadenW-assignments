<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Survey</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
	<h1>Dojo Survey</h1>
	<form class="form-control" action="/surveyResults" method=POST>
	<label class="form-label" for="name">Your Name:</label>
	<input class="form-control" type="text" name="name">
	<label class="form-label" for="location">Dojo Location</label>
	<select class="form-select" name="location">
		<option value="San Jose">San Jose</option>
		<option value="Seattle">Seattle</option>
		<option value="Las Vegas">Las Vegas</option>
	</select>
	<label class="form-label" for="lang">Favorite Language?</label>
	<select class="form-select" name="lang">
		<option value="Python">Python</option>
		<option value="Java">Java</option>
		<option value="MERN">MERN</option>
	</select>
	<label class="form-label" for="desc">Description:</label>
	<textarea class="form-control" name="desc" rows="10" cols="40"></textarea>
	<button type="submit" class="btn btn-primary mt-3">Submit</button>
	</form>
</div>
</body>
</html>
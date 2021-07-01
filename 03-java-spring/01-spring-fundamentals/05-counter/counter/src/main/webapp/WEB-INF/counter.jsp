<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Counter</title>
</head>
<body>
<h1>You have visited localhost:8080 <c:out value="${current}"/> times</h1>
<h2><a href="/">take another visit!</a> <a href="/reset">Reset number of visits!</a></h2>
</body>
</html>
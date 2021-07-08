<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit <c:out value="${book.title}"/></title>
</head>
<body>
<form action="/books/{id}/update" method=POST>
<label for="title">Title</label>
<input type="text" name="title" value=<c:out value="${book.title}"/>>
<label for="description">Description</label>
<input type="text" name="description" value=<c:out value="${book.description}"/>>
<label for="language">Language</label>
<input type="text" name="language" value=<c:out value="${book.language}"/>>
<label for="pages">Number Of Pages</label>
<input type="text" name="pages" value=<c:out value="${book.numberOfPages}"/>>
<button>Edit</button>
</form>
</body>
</html>
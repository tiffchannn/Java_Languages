<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${language.name}"/></title>
</head>
<body>
	<header>
		<h1><c:out value="${language.name}"/></h1>
		<a href="http://localhost:8080/languages">Dashboard</a>
	</header>
	
	<h2><c:out value="${language.creator}"/></h2>
	<h2><c:out value="${language.currentVersion}"/></h2>
	<a href="/languages/${language.id}/edit"><button>Edit</button></a>
	<form action="/languages/${language.id}" method="post">
	    <input type="hidden" name="_method" value="delete">
	    <input type="submit" value="Delete">
	</form>
</body>
</html>
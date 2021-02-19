<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${language.name}"/></title>
</head>
<body>
	<header>
		<form action="/languages/${language.id}" method="post">
		    <input type="hidden" name="_method" value="delete">
		    <input type="submit" value="Delete">
		</form>
		<a href="http://localhost:8080/languages">Dashboard</a>
	</header>
	<form:form action="/languages/${language.id}" method="post" modelAttribute="language">
		<input type="hidden" name="_method" value="put">
	    <p>
	        <form:label path="name">Name</form:label>
	        <form:errors path="name"/>
	        <form:input path="name"/>
	    </p>
	    <p>
	        <form:label path="creator">Creator</form:label>
	        <form:errors path="creator"/>
	        <form:input path="creator"/>
	    </p>  
	    <p>
	        <form:label path="currentVersion">Version</form:label>
	        <form:errors path="currentVersion"/>
	        <form:textarea path="currentVersion"/>
	    </p>
	    <input type="submit" value="Submit"/>
	</form:form> 

</body>
</html>
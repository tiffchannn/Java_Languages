<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Languages</title>
</head>
<body>
	<h1>All Languages</h1>
	<div>
	<!-- DISPLAY ALL LANGUAGES TABLE  -->
		<table>
		    <thead>
		        <tr>
		            <th>Name</th>
		            <th>Creator</th>
		            <th>Version</th>
		            <th>Action</th>
		        </tr>
		    </thead>
		    <tbody>
			    <c:forEach items="${languages}" var="language">
		        <tr>
		            <td><a href="/languages/${language.id}"><c:out value="${language.name}"/></a></td> 
		            <td><c:out value="${language.creator}"/></td>
		            <td><c:out value="${language.currentVersion}"/></td>
		            <td>
		            	<form action="/languages/${language.id}" method="post" >
		            		<input type="hidden" name="_method" value="delete">
		            		<input type="submit" class="btn btn-outline-light btn-sm" value="Delete">
		            	</form> 
		            	<a href="languages/<c:out value="${language.id}"/>/edit">
		            		<button type="button">Edit</button>
		            	</a>
		            </td>
		        </tr>
		        </c:forEach>
		    </tbody>
		</table>
		
	</div>
	
	<div>
	<!-- CREATION FORM  -->
		<form:form action="/languages" method="post" modelAttribute="language">
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
		   
	</div>

</body>
</html>
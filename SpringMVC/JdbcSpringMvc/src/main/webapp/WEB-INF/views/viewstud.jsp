<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Students</title>
</head>
<body>
	<h1>Students List</h1>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Branch</th>
			<th>College</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="stud" items="${list}">
			<tr>
				<td>${stud.id}</td>
				<td>${stud.name}</td>
				<td>${stud.branch}</td>
				<td>${stud.college}</td>
				<td><a href="editstud/${stud.id}">Edit</a></td>
				<td><a href="deletestud/${stud.id}" data-method="delete">Delete</a></td>
			</tr>
		</c:forEach>
	</table>

	<br>
	<a href="studform">Add New Student</a>
</body>
</html>
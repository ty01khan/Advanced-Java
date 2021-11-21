<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Form</title>
</head>
<body>
	<h1>Add New Student</h1>
	<form:form method="POST" action="save">
		<table>
			<tr>
				<td>Name:</td>
				<td><form:input path="name"/></td>
			</tr>
			<tr>
				<td>Branch:</td>
				<td><form:input path="branch"/></td>
			</tr>
			<tr>
				<td>College:</td>
				<td><form:input path="college"/></td>
			</tr>
			
			<tr>
				<td> </td>
				<td><input type="submit" value="Save"/></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
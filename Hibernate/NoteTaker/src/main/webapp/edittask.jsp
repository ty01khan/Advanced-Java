<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.entities.Note"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="com.helper.SessionProvider"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="js_bootstrap_helper.jsp"%>
<title>Edit Task</title>
</head>
<body>
	<div class="container">
		<%@include file="navbar.jsp"%>
		<br>
		<h2>Edit Task</h2>

		<%
		int id = Integer.parseInt(request.getParameter("id").trim());
		Session s = SessionProvider.getSession();
		Transaction txn = s.beginTransaction();
		Note note = (Note) s.get(Note.class, id);
		%>
		<!-- add notes form -->
		<form action="UpdateServlet" method="POST">
			<input value=<%=note.getId()%> name="id" type="hidden">
			<div class="form-group">
				<label for="title">Title</label> <input name="title" type="text"
					class="form-control" id="title" placeholder="Enter title here"
					value="<%=note.getTitle()%>" required>
			</div>
			<div class="form-group">
				<label for="content">Note</label>
				<textarea name="content" rows="7" id="content"
					placeholder="Enter your content here" class="form-control" required><%=note.getContent()%></textarea>
			</div>
			<div class="container text-center mt-2 p-3">
				<button type="submit" class="btn btn-primary">Save Task</button>
			</div>
		</form>
	</div>
</body>
</html>
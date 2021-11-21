<%@page import="com.entities.Note"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.helper.SessionProvider"%>
<%@page import="com.helper.FactoryProvider"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="js_bootstrap_helper.jsp"%>
<title>View all notes</title>
</head>
<body>
	<div class="container mb-5">
		<%@include file="navbar.jsp"%>
		<br>
		<h4 class="text-uppercase mb-0 mt-2">All Notes:</h4>

		<div class="row">
			<div class="col-12">
				<%
				Session s = SessionProvider.getSession();
				Query q = s.createQuery("from Note");
				List<Note> list = q.list();
				for (Note note : list) {
				%>
				<div class="card mt-3">
					<a href="DeleteServlet?task_id=<%=note.getId()%>"> <img
						class="card-img-top mr-2 mt-2 float-right" src="img/close.png"
						alt="Card image cap" style="max-width: 15px">
					</a> <img class="card-img-top ml-2 float-left" src="img/task.png"
						alt="Card image cap" style="max-width: 40px">
					<div class="card-body">
						<h6 class="float-right"><%=note.getCreatedDate()%></h6>
						<h5 class="card-title"><%=note.getTitle()%></h5>
						<p class="card-text"><%=note.getContent()%></p>
						<a href="edittask.jsp?id=<%=note.getId()%>"
							class="btn btn-primary">Update Task</a>
					</div>
				</div>
				<%
				}
				s.close();
				%>
			</div>
		</div>
	</div>
</body>
</html>
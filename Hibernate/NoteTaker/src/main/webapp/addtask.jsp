<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="js_bootstrap_helper.jsp"%>
<title>Add Note</title>
</head>
<body>
	<div class="container">
		<%@include file="navbar.jsp"%>
		<br>
		<h2>This is add notes page</h2>

		<!-- add notes form -->
		<form action="SaveNoteServlet" method="POST">
			<div class="form-group">
				<label for="title">Title</label> 
				<input name="title" type="text" class="form-control" 
				id="title" placeholder="Enter title here" required>
			</div>
			<div class="form-group">
				<label for="content">Note</label>
				<textarea name="content" rows="7" id="content"
					placeholder="Enter your content here" 
					class="form-control" required></textarea>
			</div>
			<div class="container text-center mt-2 p-3">
				<button type="submit" class="btn btn-primary">Add Task</button>
			</div>
		</form>
	</div>
</body>
</html>
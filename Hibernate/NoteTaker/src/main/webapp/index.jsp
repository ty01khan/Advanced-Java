<!doctype html>
<html lang="en">
<head>
<%@include file="js_bootstrap_helper.jsp"%>
<title>Note Taker : Home Page</title>
</head>
<body>
	<div class="container-fluid">
		<%@include file="navbar.jsp"%>
		<br>

		<div class="card py-3 border-0">
			<img alt="" class="img-fluid mx-auto bg-light"
				style="max-width: 400px;" src="img/logo.jpg">
			<h2 class="text-primary text-center text-uppercase mt-3">Start
				Creating New Tasks</h2>

			<form class="container text-center" action="addtask.jsp">
				<button class="btn btn-outline-primary my-3">Start here</button>
			</form>
		</div>
	</div>
</body>
</html>
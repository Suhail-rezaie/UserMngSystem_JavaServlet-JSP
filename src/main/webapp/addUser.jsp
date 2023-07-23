<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="component/all.jsp"%>
</head>
<body style="background-color: #f0f1f2">
	<%@include file="component/navbar.jsp"%>
	
	<%
	if (session.getAttribute("name") == null) {
		String message = "Please login first";
		request.getSession().setAttribute("err", message);
		response.sendRedirect("index.jsp");
	}
	if (session.getAttribute("message") != null) {
		out.print("<script>");
		out.print("alert('Message:" + session.getAttribute("message") + "')");
		out.print("</script>");

		session.removeAttribute("message");
	}
	%>
	
	
	<div class="container">
		<div class="row p-5">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center text-success">Add User</h3>
						<form action="Add" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">UserId:</label> <input name="id"
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter UserId">

							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">UserName:</label> <input
									name="username" type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									placeholder="Enter UserName">

							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Email:</label> <input
									name="email" type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									placeholder="Enter email">

							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password:</label> <input
									name="password" type="password" class="form-control"
									id="exampleInputPassword1" placeholder="Password">
							</div>

							<div class="text-right">
								<button type="submit" class="btn btn-primary">Add User</button>

							</div>
						</form>
						
						

					</div>
				</div>


			</div>

		</div>
	</div>


</body>
</html>
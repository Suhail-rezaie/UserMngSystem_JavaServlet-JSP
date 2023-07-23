<%@page import="com.entity.Entity"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="component/all.jsp"%>
</head>
<body>
	<%@include file="component/navbar.jsp"%>




	<h1 class="text-center text-success">User Management System</h1>

	<div style="margin-left: 550px;">
		<form action="search" method="post" class="form-inline my-2 my-lg-0">
			<input class="form-control mr-sm-2" type="search" name="id"
				placeholder="Search" aria-label="Search">
			<button class="btn  btn-success my-2 my-sm-0" type="submit">Search</button>
		</form>
	</div>


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

	<%
	String msg = (String) session.getAttribute("msg");
	if (msg != null) {
	%>
	<div class="alert alert-success" role="alert">
		<%=msg%>
	</div>
	<%
	session.removeAttribute("msg");
	}
	%>

	<%
	String fail = (String) session.getAttribute("fail");
	if (fail != null) {
	%>
	<div class="alert alert-danger" role="alert">
		<%=fail%>
	</div>
	<%
	session.removeAttribute("fail");
	}
	%>

	<div class="container">
		<table class="table table-striped" border="1px">
			<thead class="bg-success text-white">
				<tr>
					<th scope="col">UserID</th>
					<th scope="col">UserName</th>
					<th scope="col">Email</th>
					<th scope="col">Password</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<%
				UserDAO dao = new UserDAO(DBConnect.getCon());
				List<Entity> user = dao.getUser();
				for (Entity t : user) {
				%>

				<tr>
					<th scope="row"><%=request.getParameter("id")%></th>

					<td><%=request.getAttribute("username")%></td>
					<td><%=request.getAttribute("email")%></td>
					<td><%=request.getAttribute("password")%></td>
					<td>
					
					<a href="edit.jsp?id=<%=t.getId()%>"
						class="btn btn-sm btn-success text-white">Edit</a> <a
						href="delete?id=<%=t.getId()%>"
						class="btn btn-sm btn-danger text-white">Delete</a></td>

				</tr>
				<%
				}
				%>



			</tbody>
		</table>


	</div>


</body>
</html>
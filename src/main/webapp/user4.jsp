<!-- user.jsp -->

<html>
<head>
<title>User Info</title>
</head>
<body>
	<h1>User Info</h1>
	<table>
		<tr>
			<td>ID:</td>
			<td><%=request.getParameter("id")%></td>
		</tr>
		<tr>
			<td>Username:</td>
			<td><%=request.getAttribute("username")%></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><%=request.getAttribute("email")%></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><%=request.getAttribute("password")%></td>
		</tr>
	</table>
	<p>
		<a href="search.jsp">Search for another user</a>
	</p>
</body>
</html>

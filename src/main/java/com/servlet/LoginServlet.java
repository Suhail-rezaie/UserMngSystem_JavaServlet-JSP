package com.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	// Process the HTTP Get request
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String pass = request.getParameter("password");

		out.println("<html>");
		out.println("<head><title>Response</title></head>");
		out.println("<body bgcolor=\"#ffffff\">");

		try {

			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost/user";

			Connection con = DriverManager.getConnection(url, "root", "PFH#23kgrw9");

			Statement st = con.createStatement();

			String query = "Select username,password from admin where username='" + username + "' and password = '"
					+ pass + "'";

			ResultSet rs = st.executeQuery(query);

			HttpSession session = request.getSession();
			if (rs.next()) {

				// out.println("<h1>Record found</h1>");
				// request.setAttribute("admin", username);

				session.setAttribute("name", username);
				response.sendRedirect("home.jsp");

			}

			else {
				// out.println("<h1>No record found</h1>");
				session.setAttribute("fail", "Wrong Credential Try Again!");
				response.sendRedirect("index.jsp");
			}

			out.println("</body></html>");
			st.close();
			con.close();

		} catch (Exception e) {

			out.println(e);
		}

	}

}

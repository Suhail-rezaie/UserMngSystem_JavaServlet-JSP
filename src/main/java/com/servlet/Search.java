package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class Search extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final String DB_URL = "jdbc:mysql://localhost/user";
  private static final String DB_USER = "root";
  private static final String DB_PASSWORD = "PFH#23kgrw9";

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String idString = request.getParameter("id");
    int id = Integer.parseInt(idString);

    try{
      Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
      String sql = "SELECT * FROM users WHERE id = ?";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setInt(1, id);
      ResultSet rs = stmt.executeQuery();

      if (rs.next()) {
        String username = rs.getString("username");
        String email = rs.getString("email");
        String password = rs.getString("password");

        request.setAttribute("username", username);
        request.setAttribute("email", email);
        request.setAttribute("password", password);

        request.getRequestDispatcher("user.jsp").forward(request, response);
      } else {
        request.setAttribute("error", "User not found");
        request.getRequestDispatcher("search.jsp").forward(request, response);
      }
    } catch (SQLException e) {
      throw new ServletException(e);
    }
  }
}

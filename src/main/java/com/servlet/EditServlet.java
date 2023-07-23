package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.DB.DBConnect;
import com.entity.Entity;

@WebServlet("/Edit")
public class EditServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		UserDAO dao = new UserDAO(DBConnect.getCon());

		Entity e = new Entity();
		e.setId(id);
		e.setUsername(username);
		e.setEmail(email);
		e.setPassword(password);

		boolean f = dao.EditUser(e);
		HttpSession session = req.getSession();
		if (f) {
			session.setAttribute("msg", "User Updated Successfully!");
			resp.sendRedirect("home.jsp");
		} else {
			session.setAttribute("fail", "Sorry Something Went Wrong!");
			resp.sendRedirect("home.jsp");

		}

	}

}

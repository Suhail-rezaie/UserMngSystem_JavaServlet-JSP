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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		HttpSession session = req.getSession();
		
		UserDAO dao = new UserDAO(DBConnect.getCon());

		boolean f = dao.Register(username, email, password);

		if (f) {
			session.setAttribute("msg", "Registered Successfully");
			resp.sendRedirect("index.jsp");
		} else {
			session.setAttribute("fail", "Sorry Something Went Wrong!");
			resp.sendRedirect("index.jsp");
		}

	}

}

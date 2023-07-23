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

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");

		UserDAO dao = new UserDAO(DBConnect.getCon());

		boolean f = dao.DeleteUser(id);

		HttpSession session = req.getSession();
		if (f) {
			session.setAttribute("msg", "User Deleted Successfully!");
			resp.sendRedirect("home.jsp");
		} else {
			session.setAttribute("fail", "Sorry Something Went Wrong!");
			resp.sendRedirect("home.jsp");

		}

	}

}

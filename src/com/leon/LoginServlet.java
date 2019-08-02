package com.leon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// we are 'receiving' a POST request; only forms submissions are post requests
		String receivedUsername = request.getParameter("userName");
		String receivedPassword = request.getParameter("password");
		String actualUsername = "admin";
		String actualPassword = "123";

		if (receivedUsername.equalsIgnoreCase(actualUsername) && receivedPassword.equalsIgnoreCase(actualPassword)) {

			// here we are 'sending' GET request thus we can use query strings
			response.sendRedirect("SuccessServlet?user=" + receivedUsername);
		} else {
			PrintWriter out = response.getWriter();
			out.print("<html><head>");
			out.print("<title>My First Servlet</title>");
			out.print("</head>");
			out.print("<body>");
			out.print("The username or password entered is incorrect.");
			out.print("<a href='login.html'>Go back</a>");
			out.print("</body>");
			out.print("</head>");
		}

	}

}

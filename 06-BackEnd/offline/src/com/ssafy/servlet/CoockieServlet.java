package com.ssafy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CoockieServlet
 */
@WebServlet("/cookie")
public class CoockieServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie c = new Cookie("new", "singernewj");
//		c.setMaxAge(60*60);
		response.addCookie(c);

		request.getRequestDispatcher("/cookie-info.jsp").forward(request, response);

	}

}

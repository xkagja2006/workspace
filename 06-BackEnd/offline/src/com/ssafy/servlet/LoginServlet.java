package com.ssafy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		// 로그인 성공
		if ("ssafy".equals(id) && "1111".equals(password)) {
			User user = new User();
			user.setId(id);
			user.setPassword(password);
			user.setName("싸피");
			HttpSession se = request.getSession();
			se.setAttribute("user", user);
			response.sendRedirect(request.getContextPath() + "/main");
		} else { // 로그인 실패
			response.sendRedirect(request.getContextPath() + "/main");

		}
	}
}

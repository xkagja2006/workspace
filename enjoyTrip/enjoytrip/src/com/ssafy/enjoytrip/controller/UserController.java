package com.ssafy.enjoytrip.controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ssafy.enjoytrip.dto.User;
import com.ssafy.enjoytrip.service.UserService;
import com.ssafy.enjoytrip.service.UserServiceImpl;

@WebServlet("/user")
public class UserController extends HttpServlet {
	UserService userService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		userService = UserServiceImpl.getInstance();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		// 로그인 login
		// 아이디 중복확인

		// 회원가입 signUp
		// 로그아웃 logout

		switch (action) {
		case "login":
			login(request, response);
			break;

		default:
			break;
		}

	}

	private void login(HttpServletRequest request, HttpServletResponse response) {
		User u = new User();
		String id = request.getParameter("userId");
		String pw = request.getParameter("userPassword");
		u.setId(id);
		u.setPassword(pw);
		try {
			u = userService.login(u);
			String result = "{result:true}";
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(result);
			out.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

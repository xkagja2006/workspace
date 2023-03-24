package com.ssafy.sample.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.sample.dto.Member;
import com.ssafy.sample.model.service.MemberService;
import com.ssafy.sample.model.service.MemberServiceImpl;

@WebServlet("/member")
public class MemberController extends HttpServlet {

	private MemberService memberService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		memberService = MemberServiceImpl.getInstance();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) action = "";
		
		switch (action) {
		case "index":
			response.sendRedirect(
				request.getContextPath() + "/index.jsp"
			);
			break;
		case "login":
			response.sendRedirect(
					request.getContextPath() + login(request, response)
					);
			break;
		case "logout":
			response.sendRedirect(
				request.getContextPath() + logout(request, response)
			);
			break;
		default:
			break;
		}

	}

	private String logout(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getSession().invalidate();
		} catch (Exception e) {
			e.printStackTrace();
			return "/error/error.jsp";
		}
		return "/member?action=index";
	}

	private String login(HttpServletRequest request, HttpServletResponse response) {
		try {
			Member member = new Member();
			member.setId(request.getParameter("id"));
			member.setPassword(request.getParameter("password"));
			member = memberService.login(member);
			if (member != null) {
				request.getSession().setAttribute("userInfo", member);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "/error/error.jsp";
		}
		return "/member?action=index";
	}
}








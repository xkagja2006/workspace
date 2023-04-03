package com.ssafy.sample.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.sample.dto.MemberDto;
import com.ssafy.sample.dto.ProductDto;
import com.ssafy.sample.model.service.ProductService;
import com.ssafy.sample.model.service.ProductServiceImpl;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/product")
public class ProductController extends HttpServlet {
	ProductService productService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		productService = ProductServiceImpl.getInstance();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null)
			action = "list";

		String path = "";
		switch (action) {
		case "list":
			path = list(request, response);
			request.getRequestDispatcher(path).forward(request, response);
			break;
		case "detail":
			path = detail(request, response);
			request.getRequestDispatcher(path).forward(request, response);
			break;
		case "regist":
			path = regist(request, response);
			response.sendRedirect(request.getContextPath() + path);
			break;
		case "registForm":
			path = "/product/regist.jsp";
			request.getRequestDispatcher(path).forward(request, response);
			break;
		case "delete":
			path = delete(request, response);
			response.sendRedirect(request.getContextPath() + path);
			break;
		case "login":
			path = login(request, response);
			response.sendRedirect(request.getContextPath() + path);
			break;
		case "logout":
			path = logout(request, response);
			response.sendRedirect(request.getContextPath() + path);
			break;
		case "index":
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			break;

		default:
			break;
		}
	}

	private String logout(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		return  "/index.jsp";
	}

	private String login(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		MemberDto member = new MemberDto();
		member.setId(id);
		member.setPassword(password);
		try {
			member = productService.login(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (member != null) {
			request.getSession().setAttribute("userInfo", member);
			return "/index.jsp";
		}
		return "/product?action=index";
	}

	private String delete(HttpServletRequest request, HttpServletResponse response) {
		try {
			productService.delete(request.getParameter("code"));
			return "/product?action=list";
		} catch (Exception e) {
			e.printStackTrace();
			return "/error/error.jsp";
		}
	}

	private String regist(HttpServletRequest request, HttpServletResponse response) {
		try {
			ProductDto p = new ProductDto();
			p.setCode(request.getParameter("code"));
			p.setModel(request.getParameter("model"));
			p.setPrice(Integer.parseInt(request.getParameter("price")));
			productService.regist(p);
			return "/product?action=list";
		} catch (Exception e) {
			e.printStackTrace();
			return "/error/error.jsp";
		}
	}

	private String detail(HttpServletRequest request, HttpServletResponse response) {
		ProductDto product;
		try {
			product = productService.detail(request.getParameter("code"));
			request.setAttribute("product", product);
		} catch (Exception e) {
			e.printStackTrace();
			return "/error/error.jsp";
		}
		return "/product/detail.jsp";
	}

	private String list(HttpServletRequest request, HttpServletResponse response) {
		List<ProductDto> list;
		try {
			list = productService.list();
			request.setAttribute("products", list);
		} catch (Exception e) {
			e.printStackTrace();
			return "/error/error.jsp";
		}
		return "/product/list.jsp";
	}

}

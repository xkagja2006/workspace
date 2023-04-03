package com.ssafy.sample.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.sample.dto.Product;
import com.ssafy.sample.model.service.ProductService;
import com.ssafy.sample.model.service.ProductServiceImpl;

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
		case "registForm":
			request.getRequestDispatcher("/product/regist.jsp").forward(request, response);
			break;
		case "regist":
			path = regist(request, response);
			response.sendRedirect(request.getContextPath() + path);
			break;

		default:
			break;
		}
	}

	private String regist(HttpServletRequest request, HttpServletResponse response) {
		try {
			Product p = new Product();
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

	private String list(HttpServletRequest request, HttpServletResponse response) {
		List<Product> list = new ArrayList<>();
		try {
			list = productService.list();
			request.setAttribute("products", list);
			return "/product/list.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			return "/error/error.jsp";
		}
	}

}

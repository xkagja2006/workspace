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
		case "regist":
			path = regist(request, response);
			response.sendRedirect(path);
			break;
		case "registForm":
			request.getRequestDispatcher("/product/regist.jsp").forward(request, response);
			break;
		case "list":
			request.getRequestDispatcher(list(request,response)).forward(request, response);
			break;
		case "detail":
			request.getRequestDispatcher(detail(request,response)).forward(request, response);
			break;
		case "delete":
			path = delete(request, response);
			response.sendRedirect(request.getContextPath() + path);
			break;
		default:
			break;
		}
	}
	
	private String delete(HttpServletRequest request, HttpServletResponse response) {
		try {
			productService.delete(request.getParameter("code"));
		} catch (Exception e) {
			e.printStackTrace();
			return "/error/error.jsp";
		}
		return "/product?action=list";
	}

	private String detail(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setAttribute("product", productService.detail(request.getParameter("code")));
		} catch (Exception e) {
			e.printStackTrace();
			return "/error/error.jsp";
		}
		return "/product/detail.jsp";
	}

	private String list(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setAttribute("product", productService.list());
		} catch (Exception e) {
			e.printStackTrace();
			return "/error/error.jsp";
		}
		return "/product/list.jsp";
	}

	private String regist(HttpServletRequest request, HttpServletResponse response) {
		Product product = new Product();
		product.setCode(request.getParameter("code"));
		product.setModel(request.getParameter("model"));
		product.setPrice(Integer.parseInt(request.getParameter("price")));
		try {
			productService.regist(product);
		} catch (Exception e) {
			e.printStackTrace();
			return request.getContextPath() + "/error/error.jsp";
		}
		return request.getContextPath() + "/product?action=list";
	}

}

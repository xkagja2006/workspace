package com.ssafy.self.food.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.self.food.model.service.FoodService;
import com.ssafy.self.food.model.service.FoodServiceImpl;

/**
 * Servlet implementation class FoodController
 */
@WebServlet("/food")
public class FoodController extends HttpServlet {
	FoodService foodService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		foodService = FoodServiceImpl.getInstance();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case "list":

			break;
		}
	}

}

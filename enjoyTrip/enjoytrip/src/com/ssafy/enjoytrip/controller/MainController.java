package com.ssafy.enjoytrip.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.enjoytrip.service.MainService;
import com.ssafy.enjoytrip.service.MainServiceImpl;

@WebServlet("/main")
public class MainController extends HttpServlet {
	
	private static MainService service;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		service = MainServiceImpl.getInstance();
	}
	
	//메인 페이지 이동
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(service.mainPage(req, resp))
		   .forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}

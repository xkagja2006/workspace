package com.ssafy.enjoytrip.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServiceImpl implements MainService {
	
	private static MainService instance = new MainServiceImpl();
	
	private MainServiceImpl() {
		
	}
	
	public static MainService getInstance() {
		return instance;
	}
	
	@Override
	public String mainPage(HttpServletRequest req, HttpServletResponse resp) {
		return "/page/main/main.jsp";
	}

}

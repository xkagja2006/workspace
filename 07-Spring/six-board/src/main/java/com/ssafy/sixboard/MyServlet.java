package com.ssafy.sixboard;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
	public MyServlet() {
		System.out.println("MyServlet 생성됨....");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		String location = config.getInitParameter("contextConfigLocation");
		System.out.println(location);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("호출!!!!!!!!!!!!");
	}
	
}

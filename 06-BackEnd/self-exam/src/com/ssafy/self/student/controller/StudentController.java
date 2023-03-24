package com.ssafy.self.student.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.self.student.model.service.StudentService;
import com.ssafy.self.student.model.service.StudentServiceImpl;

@WebServlet("/student")
public class StudentController extends HttpServlet {
	
	// 서비스 참조하기
	private StudentService studentService;
	

	@Override
	public void init(ServletConfig config) throws ServletException {
		studentService = StudentServiceImpl.getInstance();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		super.doPost(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action == null) action = "list";
		/*
		 * list : 학생 목록
		 * push : 학생 등록
		 * fire : 학생 탈퇴
		 * view : 학생 조회
		 * kill : 학생 여러명 탈퇴
		 */
		switch(action) {
		case "list":
			
			break;
		
		}
	}

}

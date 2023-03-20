package com.ssafy.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/exam05")
public class Exam05 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 응답하는 문서의 타입 설정 및 인코딩
		 * 응답 객체 얻기
		 * 응답 내용 작성 후 전송
		 * 
		 * MINE 타입
		 * 	main/sub
		 * 
		 */
//		response.setContentType("text/plain"); // 서버에서 전송하는 내용이 어떤건지 클라이언트 브라우저에게 알려준다. MINE타입 사용
//		response.setCharacterEncoding("utf-8");	// 응답으로 보내는 내용에 한글이 있다.
//		response.setContentType("text/plain;charest=utf-8");	// 위의 두 줄을 합친것과 같은 기능
//		response.setContentType("text/html;charest=utf-8");	
		response.setContentType("text/xml;charest=utf-8");	
		
		// 응답객체는 둘중에 하나를 사용해서 얻을 수 있다.
//		OutputStream out =  response.getOutputStream();		// 바이트 단위로 받을 때
		PrintWriter out = response.getWriter();		// 스트링 단위로 받을 때
		
//		out.print("success");
//		out.print("<h2>success</h2>");
		out.print("<family><me>success</me></family>");
		out.close();
	}
}

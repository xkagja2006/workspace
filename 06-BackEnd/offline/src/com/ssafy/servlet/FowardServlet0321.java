package com.ssafy.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/forward")
public class FowardServlet0321 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 화면 데이터를 구해서 공유
		// 문자열메세지
		// 시간 정보 - 현재 요청한 시간

		req.setAttribute("msg", "데이터 공유 설정 테스트");
		req.setAttribute("time", new Date());

		// 데이터를 사용할 화면 페이지로 이동 : forwad -> 자기 프로젝트 안에서만 이동할 수 있음
		// 경로가 / 로 시작하는 경우 프로젝트 패스 다음부터 적용 (localhost:8080/프로젝트경로/servlet/forward.jsp)
		// WebContent 아래에 servlet이라는 폴더를 만든다 -> 경로는 WebContent 기준
		RequestDispatcher rd = req.getRequestDispatcher("/servlet/forward.jsp");
		rd.forward(req, res);

	}

}

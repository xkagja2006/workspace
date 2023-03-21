package com.ssafy.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.board.dao.BoardDao;
import com.ssafy.board.dao.BoardDaoImpl;
import com.ssafy.board.model.BoardDto;

/**
 * Servlet implementation class ViewBoardController
 */
@WebServlet("/board/view")
public class ViewBoardController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1. 사용자 요청시 보내준 파라미터 꺼내기
		 * 2. 화면에 필요한 데이터 구하기
		 * 3. 데이터를 화면에서 사용할 수 있게 공유영역에 등록
		 * 4. 화면 페이지로 이동하기
		 * 
		 * 각각의 단계는 필요에 따라서 진행
		 * 
		 */
		
		int articleNo = Integer.parseInt(request.getParameter("articleNo"));
		BoardDao dao = BoardDaoImpl.getBoardDao();
		dao.updateHit(articleNo);
		
		BoardDto board = dao.viewArticle(articleNo);
		request.setAttribute("board", dao.viewArticle(articleNo));
		request.getRequestDispatcher("/board/view.jsp")
			   .forward(request, response);
	}

}

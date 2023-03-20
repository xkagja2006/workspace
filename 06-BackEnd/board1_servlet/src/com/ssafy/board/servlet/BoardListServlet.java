package com.ssafy.board.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1. DB에서 글목록을 Dao의 listArticle()메소드를 이용하여 select하여 List로 얻어오세요.
		
//		2. 1에서 얻어온 List의 갯수만큼 <tr>을 이용하여 출력하세요.
		
	}

}

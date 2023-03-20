package com.ssafy.board.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/view")
public class BoardViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1. 글번호를 얻으세요.
		
//		2. 1의 글번호를 이용하여 Dao의 viewArticle()메소드에 전달하고 DB에서 select 하세요.
		
//		3. 2에서 얻어온 글정보를 출력하세요.
	}

}

package com.ssafy.paging.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.paging.model.Board;
import com.ssafy.paging.model.Page;
import com.ssafy.paging.model.service.Board2ServiceImpl;
import com.ssafy.paging.model.service.BoardService;

@WebServlet("/board/list3")
public class List3Controller extends HttpServlet {
	private BoardService service;
	public List3Controller() {
		service = Board2ServiceImpl.getInstance();
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 목록 페이지를 구성하기 위해서 목록 출력될 데이터와 하단 페이지 번호 관련
			Page page = new Page();
			try {
				page.setPageNo(Integer.parseInt(request.getParameter("pageNo")));
			} catch (Exception e) {
			}
			
			request.setAttribute("result", service.listBoard(page));
			request.getRequestDispatcher("/jsp/board/list3.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}











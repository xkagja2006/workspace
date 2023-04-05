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
import com.ssafy.paging.model.service.Board1ServiceImpl;
import com.ssafy.paging.model.service.BoardService;

@WebServlet("/board/list1")
public class List1Controller extends HttpServlet {
	private BoardService service;

	public List1Controller() {
		service = Board1ServiceImpl.getInstance();
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 목록 페이지를 구성하기 위해서 목록 출력될 데이터와 하단 페이지 번호 관련
			Page page = new Page();
			try {
				page.setPageNo(Integer.parseInt(request.getParameter("pageNo")));
			} catch (Exception e) {
			}
			Map<String, Object> result = service.listBoard(page);
			List<Board> list = (List<Board>) result.get("list");
			request.setAttribute("list", list);

			// 페이징 관련 추가내용
			// 전체 게시물 갯수를 얻어와서 페이징 관련 처리 필요
			int count = (Integer) result.get("count");
			int lastPage = (int) Math.ceil(count / 10d);
			request.setAttribute("count", count);
			request.setAttribute("lastPage", lastPage);
			request.setAttribute("pageNo", page.getPageNo());

			request.getRequestDispatcher("/jsp/board/list1.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

	public static void main(String[] args) {
		for (int count = 0; count < 100; count++) {
			// 마지막 페이지 구하기
			int p1 = (count % 10 == 0) ? count / 10 : count / 10 + 1;

			// 77 / 10d -> ceil(7.7) : 8.0
			int p2 = (int) Math.ceil(count / 10d);
			System.out.println(p1 + "-" + p2);
		}
	}
}

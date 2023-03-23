package com.ssafy.todo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.todo.model.Todo;
import com.ssafy.todo.model.dao.TodoDao;
import com.ssafy.todo.model.dao.TodoDaoImpl;

@WebServlet("/todo")
public class TodoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TodoDao todoDao;

	public void init() {
		todoDao = TodoDaoImpl.getInstance();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null || action.equals(""))
			action = "list";

		String path = "";
		if ("list".equals(action)) { // 목록
			path = list(request, response);
			forward(request, response, path);
		} else if ("regist".equals(action)) { // 등록
			path = regist(request, response);
			redirect(request, response, path);	// forward로 하면 action=regist로 남아있다. 
		} else if ("delete".equals(action)) { // 선택삭제
			path = delete(request, response);
			redirect(request, response, path);
		} else if ("clear".equals(action)) { // 전체삭제
			path = clear(request, response);
			redirect(request, response, path);
		}
	}

	private String list(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 목록 데이터 가져오기
			List<Todo> list = todoDao.selectTodo();
			request.setAttribute("todoList", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/todo/index.jsp";
	}

	private String regist(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 등록 처리하기
			Todo todo = new Todo();
			todo.setContent(request.getParameter("content"));
			todoDao.insertTodo(todo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/todo?action=list";
	}

	private String delete(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 삭제 처리하기
			todoDao.deleteTodo(Integer.parseInt(request.getParameter("no")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/todo?action=list";
	}

	private String clear(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 전체 삭제하기
			todoDao.clearTodo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/todo?action=list";
	}

	private void forward(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	private void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
		response.sendRedirect(request.getContextPath() + path);
	}
}

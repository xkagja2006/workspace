package com.ssafy.todomvc.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.todomvc.model.Todo;

public interface TodoService {
	void deleteTodo(int no) throws SQLException;
	void registTodo(Todo todo) throws SQLException;
	List<Todo> listTodo() throws SQLException;
	void clearTodo() throws SQLException;
}

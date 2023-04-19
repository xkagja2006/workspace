package com.ssafy.todomvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.todomvc.model.Todo;

public interface TodoDao {
	void deleteTodo(int no) throws SQLException;
	void insertTodo(Todo todo) throws SQLException;
	List<Todo> selectTodo() throws SQLException;
	void deleteAllTodo() throws SQLException;
}

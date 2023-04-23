package com.ssafy.sample.model.service;

import java.util.List;

import com.ssafy.sample.model.Board;

public interface BoardService {

	List<Board> list() throws Exception;

	Board detail(int no) throws Exception;

	void delete(int no) throws Exception;

	void write(Board board) throws Exception;

	void multiDelete(List<Integer> noList) throws Exception;

}

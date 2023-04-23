package com.ssafy.sample.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.sample.model.Board;

public interface BoardDao {

	List<Board> selectBoard() throws SQLException;

	Board selectBoardByPK(int no) throws SQLException;

	void deleteBoard(int no) throws SQLException;

	void insertBoard(Board board) throws SQLException;

}

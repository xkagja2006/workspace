package com.ssafy.paging.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.ssafy.paging.model.Board;
import com.ssafy.paging.model.Page;
import com.ssafy.paging.util.DBUtil;

public class BoardDaoImpl implements BoardDao {

	private static BoardDao boardDao = new BoardDaoImpl();

	private BoardDaoImpl() {
	}

	public static BoardDao getInstance() {
		return boardDao;
	}

	@Override
	public List<Board> selectBoard(Page page) throws SQLException, NamingException {
		List<Board> list = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
				/*
				 * 1page -> 0 2page -> 10 3page -> 20
				 */
				PreparedStatement pstmt = conn
						.prepareStatement("select * from tb_paging_board order by no desc limit ?, ?");) {
			pstmt.setInt(1, page.getBegin());
			pstmt.setInt(2, page.getListSize());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Board board = new Board();
				board.setNo(rs.getInt("no"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setRegDate(rs.getDate("reg_date"));
				list.add(board);
			}
			return list;
		}
	}

	@Override
	public int selectBoardCount() throws SQLException, NamingException {
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("select count(*) from tb_paging_board");) {
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt(1); // 결과가 하나일때는 이렇게 해도 된다!
		}
	}
}

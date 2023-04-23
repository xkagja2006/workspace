package com.ssafy.sample.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.ssafy.sample.model.Board;

@Repository
public class BoardDaoImpl implements BoardDao {
	private DataSource dataSource;

	public BoardDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Board> selectBoard() throws SQLException {
		List<Board> list = new ArrayList<>();
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(
						"select b.no, b.title, b.writer, u.name from board b join user u on b.writer=u.id order by no desc");) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Board b = new Board();
				b.setNo(rs.getInt("no"));
				b.setTitle(rs.getString("title"));
				b.setWriter(rs.getString("writer"));
				b.setName(rs.getString("name"));
				list.add(b);
			}
		}
		return list;
	}

	@Override
	public Board selectBoardByPK(int no) throws SQLException {
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(
						"select b.no, b.title, b.writer, b.content, u.name from board b join user u on b.writer=u.id where no=?");) {
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Board b = new Board();
				b.setNo(rs.getInt("no"));
				b.setTitle(rs.getString("title"));
				b.setWriter(rs.getString("writer"));
				b.setName(rs.getString("name"));
				b.setContent(rs.getString("content"));
				return b;
			}
		}
		return null;
	}

	@Override
	public void deleteBoard(int no) throws SQLException {
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("delete from board where no = ?");) {
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		}
	}

	@Override
	public void insertBoard(Board board) throws SQLException {
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("insert into board(title, writer, content) values(?,?,?)");) {
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			pstmt.executeUpdate();
		}
	}
}

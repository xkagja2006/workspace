package com.ssafy.sixboard.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.ssafy.sixboard.model.BoardDto;


@Repository
public class BoardDaoImpl implements BoardDao {

	private DataSource dataSource;
	public BoardDaoImpl(DataSource dataSource) {
		System.out.println("DAO 객체 생성");
		this.dataSource = dataSource;
	}

	@Override
	public int writeArticle(BoardDto boardDto) throws SQLException {
		System.out.println("BoardDao writeArticle method call!!!!!");
		int cnt = 0;
		StringBuilder sql = new StringBuilder();
		sql.append("insert into board (user_id, subject, content, hit, register_time) \n");
		sql.append("values (?, ?, ?, 0, now())");
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, boardDto.getUserId());
			pstmt.setString(2, boardDto.getSubject());
			pstmt.setString(3, boardDto.getContent());
			cnt = pstmt.executeUpdate();
		}
		return cnt;
	}

	@Override
	public List<BoardDto> listArticle(Map<String, String> map) throws SQLException {
		System.out.println("BoardDao listArticle method call!!!!!");
		List<BoardDto> list = new ArrayList<BoardDto>();
		
		String key = map.get("key");
		String word = map.get("word");
		int start = Integer.parseInt(map.get("start"));
		int end = Integer.parseInt(map.get("end"));
		
		StringBuilder listArticle = new StringBuilder();
		listArticle.append("select b.article_no, b.user_id, b.subject, b.content, b.hit, b.register_time, m.user_name \n");
		listArticle.append("from board b, members m \n");
		listArticle.append("where b.user_id = m.user_id \n");
		if(!word.isEmpty()) {
			if(key.equals("userid"))
				listArticle.append("and b.user_id = ? \n");
			else if(key.equals("subject"))
				listArticle.append("and b.subject like ? \n");
		}
		listArticle.append("order by b.article_no desc limit ?, ? \n");
		
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(listArticle.toString());
				
		) {
			int idx = 0;
			if(!word.isEmpty()) {
				if(key.equals("userid"))
					pstmt.setString(++idx, word);
				else if(key.equals("subject"))
					pstmt.setString(++idx, "%" + word + "%");
			}
			pstmt.setInt(++idx, start);
			pstmt.setInt(++idx, end);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setArticleNo(rs.getInt("article_no"));
				boardDto.setUserId(rs.getString("user_id"));
				boardDto.setUserName(rs.getString("user_name"));
				boardDto.setSubject(rs.getString("subject").replace("<", "&lt;"));
				boardDto.setContent(rs.getString("content").replace("\n", "<br/>"));
				boardDto.setHit(rs.getInt("hit"));
				boardDto.setRegisterTime(rs.getString("register_time"));
				
				list.add(boardDto);
			}
		}
		return list;
	}

	@Override
	public int totalArticleCount(Map<String, String> map) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardDto getArticle(int articleNo) throws SQLException {
		BoardDto boardDto = null;
		ResultSet rs = null;
		StringBuilder listArticle = new StringBuilder();
		listArticle.append("select b.article_no, b.user_id, b.subject, b.content, b.hit, b.register_time, m.user_name \n");
		listArticle.append("from board b, members m \n");
		listArticle.append("where b.user_id = m.user_id \n");
		listArticle.append("and b.article_no = ? \n");
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(listArticle.toString());
		) {
			pstmt.setInt(1, articleNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				boardDto = new BoardDto();
				boardDto.setArticleNo(rs.getInt("article_no"));
				boardDto.setUserId(rs.getString("user_id"));
				boardDto.setUserName(rs.getString("user_name"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setHit(rs.getInt("hit"));
				boardDto.setRegisterTime(rs.getString("register_time"));
			}
		}
		return boardDto;
	}

	@Override
	public void updateHit(int articleNo) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("update board \n");
		sql.append("set hit = hit + 1 \n");
		sql.append("where article_no = ?");
		try (
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setInt(1, articleNo);
			pstmt.executeUpdate();
		}
	}

	@Override
	public void modifyArticle(BoardDto boardDto) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("update board \n");
		sql.append("set subject = ?, content = ? \n");
		sql.append("where article_no = ?");
		try (
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, boardDto.getSubject());
			pstmt.setString(2, boardDto.getContent());
			pstmt.setInt(3, boardDto.getArticleNo());
			pstmt.executeUpdate();
		}
	}

	@Override
	public void deleteArticle(int articleNo) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from board \n");
		sql.append("where article_no = ?");
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setInt(1, articleNo);
			pstmt.executeUpdate();
		}
	}
}
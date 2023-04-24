package com.ssafy.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.ssafy.board.model.AttendanceDto;
import com.ssafy.board.model.ProductDto;
import com.ssafy.member.model.MemberDto;
@Repository
public class BoardDaoImpl implements BoardDao {
	private DataSource dataSource;

	public BoardDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<AttendanceDto> selectProduct() throws SQLException {
		List<AttendanceDto> list = new ArrayList<>();
		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("select ano, userid, issuedate, issue from attendance");
				){
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				AttendanceDto a = new AttendanceDto();
				a.setAno(rs.getString("ano"));
				a.setUserid(rs.getString("userid"));
				a.setIssuedate(rs.getString("issuedate"));
				a.setIssue(rs.getString("issue"));
				list.add(a);
			}
			return list;
		}
	}

	@Override
	public void insertProduct(AttendanceDto attendance) throws SQLException {
		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("insert into attendance(ano, userid, issuedate, issue) values(?,?,?,?)");
				){
			pstmt.setString(1, attendance.getAno());
			pstmt.setString(2, attendance.getUserid());
			pstmt.setString(3, attendance.getIssuedate());
			pstmt.setString(4, attendance.getIssue());
			pstmt.executeUpdate();
		}
	}

	@Override
	public AttendanceDto selectProductByAno(String ano) throws SQLException {
		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("select ano, userid, issuedate, issue from attendance where ano=?");
				){
			pstmt.setString(1, ano);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				AttendanceDto a = new AttendanceDto();
				a.setAno(rs.getString("ano"));
				a.setUserid(rs.getString("userid"));
				a.setIssuedate(rs.getString("issuedate"));
				a.setIssue(rs.getString("issue"));
				return a;
			}
			return null;
		}
	}

	@Override
	public MemberDto selectMember(String userid) throws SQLException {
		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("select * from userinfo where userid=?");
				){
			pstmt.setString(1, userid);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				MemberDto m = new MemberDto();
				m.setName(rs.getString("name"));
				m.setPosition(rs.getString("position"));
				m.setRclass(rs.getInt("rclass"));
				m.setUserid(userid);
				return m;
			}
			return null;
		}
	}
	
	

}

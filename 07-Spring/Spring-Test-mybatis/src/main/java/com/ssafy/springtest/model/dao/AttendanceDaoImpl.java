package com.ssafy.springtest.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.ssafy.springtest.model.Attendance;
import com.ssafy.springtest.model.User;

@Repository
public class AttendanceDaoImpl implements AttendanceDao {
	private DataSource dataSource;
	public AttendanceDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Override
	public List<Attendance> selectAttendance(User user) throws SQLException {
		List<Attendance> list = new ArrayList<>();
		StringBuffer sql = new StringBuffer();
		sql.append("select ano, userid, issuedate, issue ");
		sql.append("  from attendance ");
		if (user.getPosition().equals("교육생")) {
			sql.append(" where userid = '" + user.getUserid()+ "'");
		}
		try (
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
		) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Attendance attendance = new Attendance();
				attendance.setAno(rs.getString("ano"));
				attendance.setUserid(rs.getString("userid"));
				attendance.setIssuedate(rs.getString("issuedate"));
				attendance.setIssue(rs.getString("issue"));
				list.add(attendance);
			}
		}
		return list;
	}
	@Override
	public void deleteAttendance(String ano) throws SQLException {
		try (
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
				"delete from attendance where ano = ? "
			);
		) {
			pstmt.setString(1, ano);
			pstmt.executeUpdate();
		}					
	}
	@Override
	public void insertAttendance(Attendance attendance) throws SQLException {
		try (
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
				"insert into attendance(ano, issuedate, issue, userid) values(?, ?, ?, ?)"
			);
		) {
			pstmt.setString(1, attendance.getAno());
			pstmt.setString(2, attendance.getIssuedate());
			pstmt.setString(3, attendance.getIssue());
			pstmt.setString(4, attendance.getUserid());
			pstmt.executeUpdate();
		}	
	}
	@Override
	public Attendance selectAttendanceByPK(String ano) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("select a.ano, a.userid, a.issuedate, a.issue, u.name, u.rname, u.rclass ");
		sql.append("  from attendance a ");
		sql.append("  join userinfo u ");
		sql.append("    on a.userid = u.userid ");
		sql.append(" where a.ano = ? ");
		try (
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, ano); 
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Attendance attendance = new Attendance();
				attendance.setAno(rs.getString("ano"));
				attendance.setUserid(rs.getString("userid"));
				attendance.setIssuedate(rs.getString("issuedate"));
				attendance.setIssue(rs.getString("issue"));
				
				User user = new User();
				user.setName(rs.getString("name"));
				user.setRname(rs.getString("rname"));
				user.setRclass(rs.getInt("rclass"));
				
				attendance.setUser(user);
				return attendance;
			}
		}
		return null;
	}
}







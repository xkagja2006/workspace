package com.ssafy.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.ssafy.member.model.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{
	private DataSource dataSource;

	public MemberDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public MemberDto selectMember(String userId, String userPassword) throws SQLException {
		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("select name, position from userinfo where userid=? and userpw=?");
				){
			pstmt.setString(1, userId);
			pstmt.setString(2, userPassword);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				MemberDto m = new MemberDto();
				m.setUserid(userId);
				m.setUserpw(userPassword);
				m.setName(rs.getString("name"));
				m.setPosition(rs.getString("position"));
				return m;
			}
		}
		return null;
	};
	
}

package com.ssafy.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.ssafy.member.model.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {

	private DataSource dataSource;

	public MemberDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public MemberDto loginMember(String userId, String userPwd) throws SQLException {
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn
						.prepareStatement("select user_name from members where user_id=? and user_password=?");) {
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				MemberDto m = new MemberDto();
				m.setUserName(rs.getString("user_name"));
				return m;
			}
		}
		return null;
	}

	@Override
	public int idCheck(String userId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int joinMember(MemberDto memberDto) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}

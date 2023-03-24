package com.ssafy.sample.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.sample.dto.Member;
import com.ssafy.sample.dto.Product;
import com.ssafy.sample.util.DBUtil;

import sun.security.jca.GetInstance;

public class MemberDaoImpl implements MemberDao {
	
	private DBUtil db;
	private static MemberDao instance = new MemberDaoImpl(); 
	private MemberDaoImpl() {
		db = DBUtil.getInstance();
	}
	public static MemberDao getInstance() {
		return instance;
	}
	
	@Override
	public Member selectMember(Member member) throws SQLException {
		try (
			Connection con = db.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
				"select id, name, password from member where id = ? and password = ? "
			);
		) {
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Member m = new Member();
				m.setId(rs.getString("id"));
				m.setPassword(rs.getString("password"));
				m.setName(rs.getString("name"));
				return m;
			}
			return null;
		}	
	}
}

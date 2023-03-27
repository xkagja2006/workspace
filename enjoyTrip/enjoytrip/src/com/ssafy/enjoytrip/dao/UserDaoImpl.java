package com.ssafy.enjoytrip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.enjoytrip.dto.User;
import com.ssafy.enjoytrip.util.DBUtil;

public class UserDaoImpl implements UserDao {
	DBUtil db;
	private static UserDao instance = new UserDaoImpl();

	private UserDaoImpl() {
		db = DBUtil.getInstance();
	}

	public static UserDao getInstance() {
		return instance;
	}

	@Override
	public User selectUser(User u) throws SQLException {
		try (Connection con = db.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("select id, password, name, email from user where id=? and password=?");) {
			int index = 0;
			pstmt.setString(++index, u.getId());
			pstmt.setString(++index, u.getPassword());
			ResultSet rs = pstmt.executeQuery();
			User user = new User();
			if (rs.next()) {
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
			}
			return user;
		}
	}
}

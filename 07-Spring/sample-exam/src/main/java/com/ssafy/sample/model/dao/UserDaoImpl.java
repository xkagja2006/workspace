package com.ssafy.sample.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.ssafy.sample.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	private DataSource dataSource;

	public UserDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public User selectLogin(User user) throws Exception {
		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(
						"select id, name, password from user where id = ? and password = ?"
						);
				){
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPassword());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				User userInfo = new User();
				userInfo.setId(rs.getString("id"));
				userInfo.setPassword(rs.getString("password"));
				userInfo.setName(rs.getString("name"));
				return userInfo;
			}
		}
		return null;
	}

}

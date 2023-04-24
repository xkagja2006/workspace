package com.ssafy.springtest.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.stereotype.Repository;
import com.ssafy.springtest.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	private DataSource dataSource;
	public UserDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public User selectLogin(User user) throws SQLException {
		try (
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
				"  select userid, userpw, position, name, rname, rclass "
				+ "  from userinfo "
				+ " where userid = ? and userpw = ?"
			);
		) {
			pstmt.setString(1, user.getUserid());
			pstmt.setString(2, user.getUserpw());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				User userInfo = new User();
				userInfo.setUserid(rs.getString("userid"));
				userInfo.setUserpw(rs.getString("userpw"));
				userInfo.setName(rs.getString("name"));
				userInfo.setPosition(rs.getString("position"));
				userInfo.setRname(rs.getString("rname"));
				userInfo.setRclass(rs.getInt("rclass"));
				return userInfo;
			}
		}
		return null;
	}
	
}










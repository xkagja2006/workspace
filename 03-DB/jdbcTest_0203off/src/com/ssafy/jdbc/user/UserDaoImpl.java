package com.ssafy.jdbc.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import com.ssafy.jdbc.util.SqlSession;

public class UserDaoImpl implements UserDao {
	
	private static UserDao instance = new UserDaoImpl();
	private UserDaoImpl() {//여기서 드라이버 로드할 필요 없다.
	}
	public static UserDao getInstance() {
		return instance;
	}
	
	@Override
	public void insertUser(UserDto user) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into user( ");
		sql.append("	id, name, password, addr ");
		sql.append(") values ( ");
		sql.append("	?, ?, ?, ? ");
		sql.append(") ");
		SqlSession.insert(
				sql.toString(), 
				user.getId(), user.getName(), user.getPassword(), user.getAddr()
		);
	}

	@Override
	public void updateUser(UserDto user) throws Exception {
		SqlSession.update(
				"update user set addr = ? where id = ? ", user.getAddr(), user.getId());
	}

	@Override
	public void deleteUser(String id) throws Exception {
		SqlSession.delete("delete user where id = ?", id);
	}

	@Override
	public List<UserDto> selectUser() {
		return null;
	}

	@Override
	public UserDto selectUserById(String id) {
		return null;
	}

}

package com.ssafy.springtest.model.dao;

import java.sql.SQLException;

import com.ssafy.springtest.model.User;

public interface UserDao {

	User selectLogin(User user) throws SQLException;
	
}

package com.ssafy.enjoytrip.dao;

import java.sql.SQLException;

import com.ssafy.enjoytrip.dto.User;

public interface UserDao {

	User selectUser(User u) throws SQLException;

}

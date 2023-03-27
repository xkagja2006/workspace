package com.ssafy.enjoytrip.service;

import com.ssafy.enjoytrip.dao.UserDao;
import com.ssafy.enjoytrip.dao.UserDaoImpl;
import com.ssafy.enjoytrip.dto.User;

public class UserServiceImpl implements UserService {
	UserDao userDao;
	private static UserService instance = new UserServiceImpl();

	private UserServiceImpl() {
		userDao = UserDaoImpl.getInstance();
	}

	public static UserService getInstance() {
		return instance;
	}

	@Override
	public User login(User u) throws Exception {
		return userDao.selectUser(u);
	}
}

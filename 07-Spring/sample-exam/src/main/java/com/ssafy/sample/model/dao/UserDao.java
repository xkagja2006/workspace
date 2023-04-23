package com.ssafy.sample.model.dao;

import org.springframework.stereotype.Repository;

import com.ssafy.sample.model.User;

public interface UserDao {

	User selectLogin(User user) throws Exception;

}

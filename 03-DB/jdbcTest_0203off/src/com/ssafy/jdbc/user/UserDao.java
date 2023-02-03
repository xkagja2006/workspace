/*
 * C : insertUser
 * R : selectUser, selectUserById 
 * U : updateUser
 * D : deleteUser
 */
package com.ssafy.jdbc.user;

import java.util.List;

public interface UserDao {
	void insertUser(UserDto user) throws Exception;
	void updateUser(UserDto user) throws Exception;
	void deleteUser(String id) throws Exception;
	List<UserDto> selectUser() throws Exception;
	UserDto selectUserById(String id) throws Exception;
}














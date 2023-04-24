package com.ssafy.member.model.dao;

import java.sql.SQLException;

import com.ssafy.member.model.MemberDto;

public interface MemberDao {

	MemberDto selectMember(String userId, String userPassword) throws SQLException;

}

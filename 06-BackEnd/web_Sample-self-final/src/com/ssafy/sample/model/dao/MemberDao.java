package com.ssafy.sample.model.dao;

import java.sql.SQLException;

import com.ssafy.sample.dto.Member;

public interface MemberDao {
	Member selectMember(Member member) throws SQLException;
}

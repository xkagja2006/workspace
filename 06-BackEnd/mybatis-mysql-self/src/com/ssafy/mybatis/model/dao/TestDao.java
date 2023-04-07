package com.ssafy.mybatis.model.dao;

import java.util.List;

import com.ssafy.mybatis.model.Member;

public interface TestDao {
	List<Member> selectMember();

	void insertMember(Member member);

	void updateMember(Member member);

	void deleteMember(String id);
}

package com.ssafy.member.model.service;

import org.springframework.stereotype.Service;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.dao.MemberDao;

@Service
public class MemberServiceImpl implements MemberService {
	private final MemberDao memberDao;

	public MemberServiceImpl(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Override
	public MemberDto login(String userId, String userPassword) throws Exception {
		return memberDao.selectMember(userId, userPassword);
	}

}

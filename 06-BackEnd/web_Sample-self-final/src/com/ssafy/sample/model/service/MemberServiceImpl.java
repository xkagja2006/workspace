package com.ssafy.sample.model.service;

import com.ssafy.sample.dto.Member;
import com.ssafy.sample.model.dao.MemberDao;
import com.ssafy.sample.model.dao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService {
	private MemberDao memberDao;
	private static MemberService instance = new MemberServiceImpl();
	private MemberServiceImpl() {
		memberDao = MemberDaoImpl.getInstance();
	}
	public static MemberService getInstance() {
		return instance;
	}
	@Override
	public Member login(Member member) throws Exception {
		return memberDao.selectMember(member);
	}
}








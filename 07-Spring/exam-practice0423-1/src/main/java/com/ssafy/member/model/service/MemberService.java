package com.ssafy.member.model.service;

import com.ssafy.member.model.MemberDto;

public interface MemberService {

	MemberDto login(String userId, String userPassword) throws Exception;

}

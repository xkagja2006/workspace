package com.ssafy.sample.model.service;

import java.sql.SQLException;

import com.ssafy.sample.dto.Member;

public interface MemberService {
	Member login(Member member) throws Exception;
}

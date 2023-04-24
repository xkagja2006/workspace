package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.AttendanceDto;
import com.ssafy.board.model.ProductDto;
import com.ssafy.member.model.MemberDto;

public interface BoardService {

	List<AttendanceDto> list() throws Exception;

	void regist(AttendanceDto attendance) throws Exception;

	AttendanceDto detail(String ano) throws Exception;

	MemberDto findMember(String userid) throws Exception;


}

package com.ssafy.board.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.board.model.AttendanceDto;
import com.ssafy.board.model.ProductDto;
import com.ssafy.member.model.MemberDto;

public interface BoardDao {

	List<AttendanceDto> selectProduct() throws SQLException;

	void insertProduct(AttendanceDto attendance) throws SQLException;

	AttendanceDto selectProductByAno(String ano) throws SQLException;

	MemberDto selectMember(String userid)  throws SQLException;

}

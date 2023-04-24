package com.ssafy.mybatis.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ssafy.mybatis.MemberDto;
import com.ssafy.mybatis.config.SqlMapConfig;

public class MemberDaoImpl implements MemberDao {
	
	private final String NAMESPACE = "";

	@Override
	public void joinMember(MemberDto memberDto) throws SQLException {
		
	}

	@Override
	public List<MemberDto> listMember() throws SQLException {
		return null;
	}

}

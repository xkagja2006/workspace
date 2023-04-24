package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.board.model.AttendanceDto;
import com.ssafy.board.model.ProductDto;
import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.member.model.MemberDto;

@Service
public class BoardServiceImpl implements BoardService {
	private final BoardDao boardDao;

	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public List<AttendanceDto> list() throws Exception {
		return boardDao.selectProduct();
	}

	@Override
	public void regist(AttendanceDto attendance) throws Exception {
		boardDao.insertProduct(attendance);
		
	}

	@Override
	public AttendanceDto detail(String ano) throws Exception {
		return boardDao.selectProductByAno(ano);
	}

	@Override
	public MemberDto findMember(String userid) throws Exception {
		return boardDao.selectMember(userid);
	}


}

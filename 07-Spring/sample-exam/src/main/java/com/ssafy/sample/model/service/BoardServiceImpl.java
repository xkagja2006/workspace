package com.ssafy.sample.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.sample.model.Board;
import com.ssafy.sample.model.dao.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {
	private BoardDao boardDao;

	public BoardServiceImpl(BoardDao boardDao) {
		super();
		this.boardDao = boardDao;
	}

	@Override
	public List<Board> list() throws Exception {
		return boardDao.selectBoard();
	}

	@Override
	public Board detail(int no) throws Exception {
		return boardDao.selectBoardByPK(no);
	}

	@Override
	public void delete(int no) throws Exception {
		boardDao.deleteBoard(no);
	}

	@Override
	public void write(Board board) throws Exception {
		boardDao.insertBoard(board);
	}

	@Override
	public void multiDelete(List<Integer> noList) throws Exception {
		for(int no : noList) {
			boardDao.deleteBoard(no);
		}
	}

}

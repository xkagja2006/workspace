package com.ssafy.board.model.service;

import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {
	private BoardDao boardDao;

	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
}

package com.ssafy.paging.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.paging.model.Board;
import com.ssafy.paging.model.Page;
import com.ssafy.paging.model.dao.BoardDao;
import com.ssafy.paging.model.dao.BoardDaoImpl;

public class Board1ServiceImpl implements BoardService {
	private static BoardService boardService = new Board1ServiceImpl();
	private BoardDao dao;

	private Board1ServiceImpl() {
		dao = BoardDaoImpl.getInstance();
	}

	public static BoardService getInstance() {
		return boardService;
	}

	@Override
	public Map<String, Object> listBoard(Page page) throws Exception {
		Map<String, Object> result = new HashMap<>();
		List<Board> list = dao.selectBoard(page);
		int count = dao.selectBoardCount();
		result.put("list", list);
		result.put("count", count);
		return result;
	}
}

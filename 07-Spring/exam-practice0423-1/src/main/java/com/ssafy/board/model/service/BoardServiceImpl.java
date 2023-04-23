package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.board.model.ProductDto;
import com.ssafy.board.model.dao.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {
	private final BoardDao boardDao;

	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public List<ProductDto> list() throws Exception {
		return boardDao.selectProduct();
	}

	@Override
	public void regist(ProductDto product) throws Exception {
		boardDao.insertProduct(product);
		
	}

}

package com.ssafy.board.dao;

import java.util.List;

import com.ssafy.board.model.BoardDto;

// 아래의 메소드를 구현하는 구현체 (BoardDaoImpl)을 만드세요.
public interface BoardDao {
	int writeArticle(BoardDto boardDto);
	List<BoardDto> listArticle();
	BoardDto viewArticle(int articleNo);
}

package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.ProductDto;

public interface BoardService {

	List<ProductDto> list() throws Exception;

	void regist(ProductDto product) throws Exception;

}

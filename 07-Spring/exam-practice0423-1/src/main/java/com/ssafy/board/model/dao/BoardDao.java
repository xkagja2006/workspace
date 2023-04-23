package com.ssafy.board.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.board.model.ProductDto;

public interface BoardDao {

	List<ProductDto> selectProduct() throws SQLException;

	void insertProduct(ProductDto product) throws SQLException;

}

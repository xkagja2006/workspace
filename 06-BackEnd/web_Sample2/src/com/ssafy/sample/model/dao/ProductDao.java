package com.ssafy.sample.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.sample.dto.Product;

public interface ProductDao {
	List<Product> selectProducts() throws SQLException;

	void insertProducts(Product p) throws SQLException;
}

package com.ssafy.sample.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.sample.dto.Product;

public interface ProductDao {
	List<Product> list();

	void insertProduct(Product product) throws SQLException;

	List<Product> selectProduct() throws SQLException;

	Product detailProduct(String code) throws SQLException;

	void deleteProduct(String parameter) throws SQLException;
}
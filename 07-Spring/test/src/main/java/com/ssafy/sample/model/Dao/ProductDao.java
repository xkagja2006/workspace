package com.ssafy.sample.model.Dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.sample.model.Product;

public interface ProductDao {
	List<Product>select() throws SQLException;

	void write(Product product) throws SQLException;

	Product get(Product product) throws SQLException;

}

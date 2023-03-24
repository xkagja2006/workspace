package com.ssafy.sample.model.service;

import java.util.List;

import com.ssafy.sample.dto.Product;

public interface ProductService {
	void regist(Product product) throws Exception;

	List<Product> list() throws Exception;

	Product detail(String parameter) throws Exception;

	void delete(String parameter) throws Exception;
}

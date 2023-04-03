package com.ssafy.sample.model.service;

import java.util.List;

import com.ssafy.sample.dto.Product;

public interface ProductService {
	List<Product> list() throws Exception;

	void regist(Product p) throws Exception;
}

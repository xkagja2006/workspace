package com.ssafy.sample.model.service;

import java.util.List;

import com.ssafy.sample.model.Product;

public interface ProductService {
	List<Product>list() throws Exception;

	void write(Product product) throws Exception;

	Product get(Product product) throws Exception;
}

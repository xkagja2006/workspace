package com.ssafy.sample.model.service;

import java.util.List;

import com.ssafy.sample.dto.Product;
import com.ssafy.sample.model.dao.ProductDao;
import com.ssafy.sample.model.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {
	ProductDao productDao;
	private static ProductService instance = new ProductServiceImpl();

	private ProductServiceImpl() {
		productDao = ProductDaoImpl.getInstance();
	}

	public static ProductService getInstance() {
		return instance;
	}

	@Override
	public List<Product> list() throws Exception {
		return productDao.selectProducts();
	}

	@Override
	public void regist(Product p) throws Exception {
		productDao.insertProducts(p);

	}

}

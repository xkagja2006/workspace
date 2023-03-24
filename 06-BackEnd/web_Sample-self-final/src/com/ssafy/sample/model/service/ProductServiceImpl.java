package com.ssafy.sample.model.service;

import java.util.List;

import com.ssafy.sample.dto.Product;
import com.ssafy.sample.model.dao.ProductDao;
import com.ssafy.sample.model.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {
	private ProductDao productDao;
	private static ProductService instance = new ProductServiceImpl();
	private ProductServiceImpl() {
		productDao = ProductDaoImpl.getInstance();
	}
	public static ProductService getInstance() {
		return instance;
	}
	@Override
	public void regist(Product product) throws Exception {
		productDao.insertProduct(product);
	}
	@Override
	public List<Product> list() throws Exception {
		return productDao.selectProduct();
	}
	@Override
	public Product detail(String code) throws Exception {
		return productDao.selectProductByCode(code);
	}
	@Override
	public void delete(String code) throws Exception {
		productDao.deleteProduct(code);
	}
}   







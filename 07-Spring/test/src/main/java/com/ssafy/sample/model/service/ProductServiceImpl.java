package com.ssafy.sample.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.sample.model.Product;
import com.ssafy.sample.model.Dao.ProductDao;


@Service
public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;
	
	
	public ProductServiceImpl(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public List<Product> list() throws Exception {
		return productDao.select();
	}



	@Override
	public void write(Product product) throws Exception {
		productDao.write(product);
		
	}

	@Override
	public Product get(Product product) throws Exception {
		
		return productDao.get(product);
	}



}
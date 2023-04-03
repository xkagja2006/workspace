package com.ssafy.sample.model.service;

import java.util.List;

import com.ssafy.sample.dto.MemberDto;
import com.ssafy.sample.dto.ProductDto;
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
	public List<ProductDto> list() throws Exception {
		return productDao.getList();
	}

	@Override
	public ProductDto detail(String code) throws Exception {
		return productDao.getDetail(code);
	}

	@Override
	public void regist(ProductDto p) throws Exception {
		productDao.insertProduct(p);
	}

	@Override
	public void delete(String code) throws Exception {
		productDao.deleteProduct(code);
	}

	@Override
	public MemberDto login(MemberDto member) throws Exception {
		return productDao.selectMember(member);
	}

}

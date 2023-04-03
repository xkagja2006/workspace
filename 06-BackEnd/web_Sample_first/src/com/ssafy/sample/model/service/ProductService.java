package com.ssafy.sample.model.service;

import java.util.List;

import com.ssafy.sample.dto.MemberDto;
import com.ssafy.sample.dto.ProductDto;

public interface ProductService {
	List<ProductDto> list() throws Exception;

	ProductDto detail(String code) throws Exception;

	void regist(ProductDto p) throws Exception;

	void delete(String code) throws Exception;

	MemberDto login(MemberDto member) throws Exception;
}

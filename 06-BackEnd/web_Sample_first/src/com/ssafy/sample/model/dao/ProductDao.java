package com.ssafy.sample.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.sample.dto.MemberDto;
import com.ssafy.sample.dto.ProductDto;

public interface ProductDao {
	List<ProductDto> getList() throws SQLException;

	ProductDto getDetail(String code) throws SQLException;

	void insertProduct(ProductDto p) throws SQLException;

	void deleteProduct(String code) throws SQLException;

	MemberDto selectMember(MemberDto member) throws SQLException;
}

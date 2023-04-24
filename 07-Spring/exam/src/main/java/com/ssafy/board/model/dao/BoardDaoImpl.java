package com.ssafy.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.ssafy.board.model.ProductDto;
@Repository
public class BoardDaoImpl implements BoardDao {
	private DataSource dataSource;

	public BoardDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<ProductDto> selectProduct() throws SQLException {
		List<ProductDto> list = new ArrayList<>();
		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("select code, model, price from product");
				){
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductDto p = new ProductDto();
				p.setCode(rs.getString("code"));
				p.setModel(rs.getString("model"));
				p.setPrice(rs.getString("price"));
				list.add(p);
			}
			return list;
		}
	}

	@Override
	public void insertProduct(ProductDto product) throws SQLException {
		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("insert into product(code, model, price) values(?,?,?)");
				){
			pstmt.setString(1, product.getCode());
			pstmt.setString(2, product.getModel());
			pstmt.setString(3, product.getPrice());
			pstmt.executeUpdate();
		}
	}
	
	

}

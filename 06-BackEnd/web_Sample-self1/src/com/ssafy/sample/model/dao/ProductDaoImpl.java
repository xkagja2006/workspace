package com.ssafy.sample.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.sample.dto.Product;
import com.ssafy.sample.util.DBUtil;

public class ProductDaoImpl implements ProductDao {
	DBUtil db;
	private static ProductDao instance = new ProductDaoImpl();

	private ProductDaoImpl() {
		db = DBUtil.getInstance();
	}

	public static ProductDao getInstance() {
		return instance;
	}

	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertProduct(Product product) throws SQLException {
		try (Connection con = db.getConnection();
				PreparedStatement pstmt = con.prepareStatement("insert into product(code, model, price) values(?,?,?)");

		) {
			int index = 0;
			pstmt.setString(++index, product.getCode());
			pstmt.setString(++index, product.getModel());
			pstmt.setInt(++index, product.getPrice());
			pstmt.executeUpdate();
		}
	}

	@Override
	public List<Product> selectProduct() throws SQLException {
		try(
				Connection con = db.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select code, model, price from product order by code");
				){
			List<Product> list = new ArrayList<Product>();
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Product p = new Product();
				p.setCode(rs.getString("code"));
				p.setModel(rs.getString("model"));
				p.setPrice(rs.getInt("price"));
				list.add(p);
			}
			return list;
		}
	}

	@Override
	public Product detailProduct(String code) throws SQLException {
		try(
				Connection con = db.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select code, model, price from product where code=?");
				){
			pstmt.setString(1, code);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				Product p = new Product();
				p.setCode(rs.getString("code"));
				p.setModel(rs.getString("model"));
				p.setPrice(rs.getInt("price"));
				return p;
			}
			return null;
		}
	}

	@Override
	public void deleteProduct(String parameter) throws SQLException {
		try(
				Connection con = db.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"delete from product where code=?"
						);
				){
			pstmt.setString(1, parameter);
			pstmt.executeUpdate();
		}
	}

}

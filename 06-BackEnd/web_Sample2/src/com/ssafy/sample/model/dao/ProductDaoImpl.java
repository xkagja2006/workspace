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
	public List<Product> selectProducts() throws SQLException {
		try (Connection con = db.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select code, model, price from product");) {
			List<Product> list = new ArrayList<>();
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setCode(rs.getString("code"));
				p.setModel(rs.getString("model"));
				p.setPrice(Integer.parseInt(rs.getString("price")));
				list.add(p);
			}
			return list;
		}
	}

	@Override
	public void insertProducts(Product p) throws SQLException {
		try (Connection con = db.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("insert into product (code, model, price) value (?,?,?)");) {
			pstmt.setString(1, p.getCode());
			pstmt.setString(2, p.getModel());
			pstmt.setInt(3, p.getPrice());
			pstmt.executeUpdate();
		}
	}

}

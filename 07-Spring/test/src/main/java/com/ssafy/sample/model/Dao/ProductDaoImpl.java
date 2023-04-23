package com.ssafy.sample.model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.ssafy.sample.model.Product;
import com.ssafy.sample.model.User;

@Repository
public class ProductDaoImpl implements ProductDao {

	private DataSource dataSource;

	public ProductDaoImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public List<Product> select() throws SQLException {
		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from product");) {
			ResultSet rs = pstmt.executeQuery();
			ArrayList<Product> list = new ArrayList<Product>();
			while (rs.next()) {
				Product info = new Product();
				info.setCode(rs.getString("code"));
				info.setModel(rs.getString("model"));
				info.setPrice(rs.getInt("price"));
				list.add(info);
			}

			return list;
		}
	}

	@Override
	public void write(Product product) throws SQLException {
		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("insert into product (code, model, price) value (?,?,?)")) {
			pstmt.setString(1, product.getCode());
			pstmt.setString(2, product.getModel());
			pstmt.setInt(3, product.getPrice());
			pstmt.executeUpdate();
		}

	}

	@Override
	public Product get(Product product) throws SQLException {
		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from product where code = ?");) {
			pstmt.setString(1, product.getCode());
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				Product info = new Product();
				info.setCode(rs.getString("code"));
				info.setModel(rs.getString("model"));
				info.setPrice(rs.getInt("price"));
				return info;
			}

			return null;
		}
	}

}

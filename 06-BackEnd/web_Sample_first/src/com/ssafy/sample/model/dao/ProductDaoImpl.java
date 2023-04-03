package com.ssafy.sample.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.sample.dto.MemberDto;
import com.ssafy.sample.dto.ProductDto;
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
	public List<ProductDto> getList() throws SQLException {
		try (Connection con = db.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("select code, model, price from product order by code");) {
			List<ProductDto> list = new ArrayList<>();
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductDto p = new ProductDto();
				p.setCode(rs.getString("code"));
				p.setModel(rs.getString("model"));
				p.setPrice(rs.getInt("price"));
				list.add(p);
			}
			return list;

		}
	}

	@Override
	public ProductDto getDetail(String code) throws SQLException {
		try (Connection con = db.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("select code, model, price from product where code=?");) {
			pstmt.setString(1, code);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				ProductDto p = new ProductDto();
				p.setCode(code);
				p.setModel(rs.getString("model"));
				p.setPrice(rs.getInt("price"));
				return p;
			}
			return null;
		}
	}

	@Override
	public void insertProduct(ProductDto p) throws SQLException {
		try (Connection con = db.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("insert into product(code, model, price) value(?,?,?)");) {
			int index = 0;
			pstmt.setString(++index, p.getCode());
			pstmt.setString(++index, p.getModel());
			pstmt.setInt(++index, p.getPrice());
			pstmt.executeUpdate();
		}
	}

	@Override
	public void deleteProduct(String code) throws SQLException {
		try (Connection con = db.getConnection();
				PreparedStatement pstmt = con.prepareStatement("delete from product where code=?");) {
			pstmt.setString(1, code);
			pstmt.executeUpdate();
		}
	}

	@Override
	public MemberDto selectMember(MemberDto member) throws SQLException {
		try (Connection con = db.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("select name, id, password from member where id=? and password=?");

		) {
			MemberDto m = new MemberDto();
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				m.setId(member.getId());
				m.setPassword(member.getPassword());
				m.setName(rs.getString("name"));
				return m;
			}
			return null;
		}
	}

}

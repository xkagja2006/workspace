package com.ssafy.board.model.dao;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

@Repository
public class BoadDaoImpl implements BoardDao{
	private DataSource dataSource;

	public BoadDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
}

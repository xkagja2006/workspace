package com.ssafy.self.food.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.self.food.model.Food;

public class FoodDaoImpl implements FoodDao {
	private static FoodDao instance = new FoodDaoImpl();

	private FoodDaoImpl() {
	}

	public static FoodDao getInstance() {
		return instance;
	}

	@Override
	public List<Food> list() throws SQLException {
		return null;
	}

}

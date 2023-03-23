package com.ssafy.self.food.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.self.food.model.Food;

public interface FoodDao {
	List<Food> list() throws SQLException;
}

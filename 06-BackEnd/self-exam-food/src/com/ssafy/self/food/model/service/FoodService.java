package com.ssafy.self.food.model.service;

import java.util.List;

import com.ssafy.self.food.model.Food;

public interface FoodService {
	List<Food> list() throws Exception;
}

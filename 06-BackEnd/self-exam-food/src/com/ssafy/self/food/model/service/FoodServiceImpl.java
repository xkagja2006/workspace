package com.ssafy.self.food.model.service;

import java.util.List;

import com.ssafy.self.food.model.Food;
import com.ssafy.self.food.model.dao.FoodDao;
import com.ssafy.self.food.model.dao.FoodDaoImpl;

public class FoodServiceImpl implements FoodService {

	private static FoodService instance = new FoodServiceImpl();

	private FoodServiceImpl() {
		FoodDao foodDao = FoodDaoImpl.getInstance();
	}

	public static FoodService getInstance() {
		return instance;
	}

	@Override
	public List<Food> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

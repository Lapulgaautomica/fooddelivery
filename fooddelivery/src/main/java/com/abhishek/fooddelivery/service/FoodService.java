package com.abhishek.fooddelivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhishek.fooddelivery.beans.Food;
import com.abhishek.fooddelivery.repository.FoodDAO;

@Service
public class FoodService {
	@Autowired
	private FoodDAO dao;

	public void saveFood(Food dto) {
		dao.save(dto);
		System.out.println("saved");
	}

	public List<Food> getFood(int id) {
		List<Food> food=dao.findAllByFood(id);
		food.forEach(f->{
			System.out.println(f);
		});
	
		return food;
	}

	public Food getProductById(int foodId) {
		Food foodFromDb=dao.findById(foodId).get();
		return foodFromDb;
	}




}

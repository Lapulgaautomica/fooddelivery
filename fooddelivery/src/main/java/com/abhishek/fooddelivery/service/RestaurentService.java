package com.abhishek.fooddelivery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhishek.fooddelivery.beans.Restaurent;
import com.abhishek.fooddelivery.repository.RestaurentDAO;

@Service
public class RestaurentService {
	
	@Autowired
	private RestaurentDAO dao;
	public void saveRestaurent(Restaurent restaurent) {
		
		dao.save(restaurent);
		System.out.println("saved success fully");
	}
	
	public List<Restaurent> showrestaurents() {
		List<Restaurent> list=dao.findAll();
		return  list;
	}

	public Optional<Restaurent> getRestById(int id) {
		Optional<Restaurent> rest=dao.findById(id);
		return rest;
	}

}

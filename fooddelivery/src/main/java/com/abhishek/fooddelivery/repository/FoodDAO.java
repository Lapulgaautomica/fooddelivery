package com.abhishek.fooddelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.abhishek.fooddelivery.beans.Food;

@Repository
public interface FoodDAO  extends JpaRepository<Food, Integer>{

	@Query(
			  value = "SELECT *  FROM Food u WHERE u.restaurent_id =?1", 
			  nativeQuery = true)
	List<Food> findAllByFood( int id);

}

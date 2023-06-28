package com.abhishek.fooddelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhishek.fooddelivery.beans.Restaurent;

@Repository
public interface RestaurentDAO  extends JpaRepository<Restaurent, Integer>{

	
}

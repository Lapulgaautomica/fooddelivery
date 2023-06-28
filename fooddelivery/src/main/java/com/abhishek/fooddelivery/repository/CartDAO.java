package com.abhishek.fooddelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.abhishek.fooddelivery.beans.Cart;

@Repository
public interface CartDAO  extends JpaRepository<Cart, Integer>{



	@Query(
			  value = "SELECT   *  FROM Cart u WHERE u.product_name=?1 and  u.user_email=?2", 
			  nativeQuery = true)
	Cart findByFoodNameAndUserEmail(String foodName, String email);

	List<Cart> findByUserEmail(String email);
}

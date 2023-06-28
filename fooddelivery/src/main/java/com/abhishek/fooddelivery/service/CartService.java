package com.abhishek.fooddelivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhishek.fooddelivery.beans.Cart;
import com.abhishek.fooddelivery.repository.CartDAO;

@Service
public class CartService {

	@Autowired
	private CartDAO dao;
	
	public void saveCart(Cart c1) {
		dao.save(c1);
		System.out.println("cart saved!");
	}

		
	public Cart getByfoodNameAndUserEmail(String foodName, String email) {
		System.out.println(foodName+email);
		Cart cart=dao.findByFoodNameAndUserEmail(foodName, email);
		System.out.println(cart);
		return cart;
	}


	public List<Cart> getCartByEmail(String email) {
		List<Cart> list=dao.findByUserEmail(email);
	
		System.out.println(list);
		return list;
	}


	public Cart getCartByIdl(int id) {
		Cart cart=dao.findById(id).get();
		return cart;
	}


	public void deleteById(int cartId) {
	dao.deleteById(cartId);
	 System.out.println(   "deleted");
	 
		
	}

	
}

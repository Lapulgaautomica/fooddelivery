package com.abhishek.fooddelivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abhishek.fooddelivery.beans.Cart;
import com.abhishek.fooddelivery.beans.Food;
import com.abhishek.fooddelivery.beans.Restaurent;
import com.abhishek.fooddelivery.service.CartService;
import com.abhishek.fooddelivery.service.FoodService;
import com.abhishek.fooddelivery.service.RestaurentService;


@Controller
public class CartController {

	@Autowired
	private CartService cartService;
	@Autowired
	private FoodService foodService;
	@Autowired
	private RestaurentService restuarentService;
	
	@RequestMapping("addtocart")
	public String addtoCart(int foodId,String foodName,String email,int restId,Model m ) {
		
		
		List<Food> list=foodService.getFood(restId);
		Restaurent rest=restuarentService.getRestById(restId).get();
		Cart cartFromDb=cartService.getByfoodNameAndUserEmail(foodName,email);
		Food foodFromdb=foodService.getProductById(foodId);
	
		if(cartFromDb==null)
		{
		Cart c1=new Cart();
		c1.setProductName(foodName);
		c1.setRestaurentName(rest.getRestaurantName());
		c1.setUserEmail(email);
		c1.setQty(1);
		c1.setFoodPrice(foodFromdb.getFoodPrice());
		cartService.saveCart(c1);
		m.addAttribute("AddCart", "Added to Cart");
		m.addAttribute("list",list);
		m.addAttribute("log", "");
		m.addAttribute("signup", "");			
		m.addAttribute("logout", "logout");	
		m.addAttribute("restId",  rest.getRestaurantId());
		m.addAttribute("email",  email);
		m.addAttribute("orders", "orders");	
		m.addAttribute("cart", "cart");	
		return "userest";
		}
		else
		{
			
			int i =cartFromDb.getQty()+1;
			int k=foodFromdb.getFoodPrice()+cartFromDb.getFoodPrice();
			cartFromDb.setQty(i);
			cartFromDb.setFoodPrice(k );
			System.out.println(		cartFromDb.getQty());
			cartService.saveCart(cartFromDb);
			m.addAttribute("list",list);
			m.addAttribute("add", "Item already In cart quantity Increased");
			m.addAttribute("AddCart", "Added to Cart");
			m.addAttribute("log", "");
			m.addAttribute("signup", "");			
			m.addAttribute("logout", "logout");	
			m.addAttribute("restId",  rest.getRestaurantId());
			m.addAttribute("email",  email);
			m.addAttribute("cart", "cart");	
			m.addAttribute("orders", "orders");	
			return "userest";
		}
		
		
	}
	
	@RequestMapping("showcart")
	public String showcart(String email,Model m) {
		List<Cart>list=cartService.getCartByEmail(email);
		
		  if(list.isEmpty())
		    {
		    	m.addAttribute("empty", "you dont have any item in cart");
		     	m.addAttribute("cart", "cart");	
				m.addAttribute("orders", "orders");	
				m.addAttribute("logout", "logout");	
		    	
		    	return "cart";
		    }
		    else {
		      	m.addAttribute("cartlist", list);
		    	m.addAttribute("empty", "");
		    	m.addAttribute("cart", "cart");	
				m.addAttribute("orders", "orders");	
				m.addAttribute("logout", "logout");	
		    	return "cart";
			}
	}
	
	
	@RequestMapping("checkout")
	 public String checkout(int id,Model m)
	 {
		Cart cart=cartService.getCartByIdl(id);
		m.addAttribute("cartlist", cart);
    	m.addAttribute("cart", "cart");	
				m.addAttribute("orders", "orders");	
				m.addAttribute("logout", "logout");	
		    	
		
		return "checkout";
		 
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

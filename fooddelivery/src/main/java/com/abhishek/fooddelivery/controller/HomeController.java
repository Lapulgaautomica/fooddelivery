package com.abhishek.fooddelivery.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abhishek.fooddelivery.beans.Food;
import com.abhishek.fooddelivery.beans.Restaurent;
import com.abhishek.fooddelivery.service.FoodService;
import com.abhishek.fooddelivery.service.RestaurentService;

@Controller
public class HomeController {
	@Autowired
	private RestaurentService service;
	
	@Autowired
	private FoodService fservice;
	
	@GetMapping("/")
	public String home(Model m,HttpSession session) {
		
		if( session.getAttribute("email")==null) {
		m.addAttribute("log", "Login");
		m.addAttribute("signup", "Signup");

		return "home";
		}
		else 
		{
			m.addAttribute("log", "");
			m.addAttribute("signup", "");			
			m.addAttribute("logout", "logout");		
			m.addAttribute("cart", "cart");	
			m.addAttribute("orders", "orders");	
			
			return "home";
		}
	}
	
	
	@GetMapping("/login")
	public  String login() {
		
		return "login";
		
	}
	
	
	@GetMapping("/signup")
	public String signup()  {
		
		return "signup";
	
	}
	
	@RequestMapping("restaurent")
	public String restaurent(int id, String email,Model m,HttpSession session)
	{
		Restaurent rest=service.getRestById(id).get();
		if("admin123@gmail.com".equals(email))
		{
			

			m.addAttribute("log", "");
			m.addAttribute("signup", "");			
			m.addAttribute("logout", "logout");	
			m.addAttribute("restaurentlist",rest);
			m.addAttribute("saved","");
			m.addAttribute("email",email);
			
			System.out.println("its working");
			return"rest";
		}
		else
		{

			if( "".equals(email)) 
			{
				m.addAttribute("log", "login");
				m.addAttribute("signup", "signup");
				List<Food> list=fservice.getFood(id);
				Food foodFromDb=fservice.getProductById(id);
				//Restaurent rest=service.getRestById(id).get();	
				m.addAttribute("list",list);
		
				return"userest";
			}
			else 
			{
					m.addAttribute("log", "");
					m.addAttribute("signup", "");			
					m.addAttribute("logout", "logout");	
					List<Food> list=fservice.getFood(id);
					Food foodFromDb=fservice.getProductById(id);
					//Restaurent rest=service.getRestById(id).get();	
					m.addAttribute("list",list);
					m.addAttribute("email",  session.getAttribute("email"));
					m.addAttribute("AddCart",  "Add To Cart");
					m.addAttribute("restId",  rest.getRestaurantId());
					m.addAttribute("cart", "cart");	
					m.addAttribute("orders", "orders");	
					System.out.println("its workingn on else");
	
					//m.addAttribute("restlist",rest);
					
							return"userest";
			}
		
			
		}
		
			
	}
	
	


}

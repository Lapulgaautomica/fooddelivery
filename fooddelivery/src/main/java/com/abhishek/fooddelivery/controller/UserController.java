package com.abhishek.fooddelivery.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.abhishek.fooddelivery.beans.Cart;
import com.abhishek.fooddelivery.beans.Food;
import com.abhishek.fooddelivery.beans.Restaurent;
import com.abhishek.fooddelivery.beans.User;
import com.abhishek.fooddelivery.service.CartService;
import com.abhishek.fooddelivery.service.FoodService;
import com.abhishek.fooddelivery.service.RestaurentService;
import com.abhishek.fooddelivery.service.UserService;
@Controller
public class UserController {

	
	@Autowired
	private UserService userService;

	@PostMapping("/saveuser")
	public String saveUser(User dto,Model m) 
	{
		userService.saveUser(dto);
		System.out.println("user saved");
		m.addAttribute("m", "User Created");
		return "login";
		
	}
	
	
	@GetMapping("checkuser")
	public String checkUser(String userEmail,String userPassWord,Model m,HttpSession session) {
		if("admin123@gmail.com".equals(userEmail)&&"admin".equals(userPassWord))
		{
			
			session.setAttribute("email",userEmail);
			m.addAttribute("login","" );
			m.addAttribute("logout","logout" );
			m.addAttribute("signup", "");
			m.addAttribute("addres", "Add Restaurents");
			return "adminhome";
		}
		
		User user=userService.checkUser(userEmail, userPassWord);
		
		
		if(user!=null)
		{
			session.setAttribute("email",userEmail);
			m.addAttribute("login","" );
			m.addAttribute("logout","logout" );
			m.addAttribute("signup", "");
			m.addAttribute("cart", "cart");	
			m.addAttribute("orders", "orders");	
			return "home";
		}
		else {
			m.addAttribute("m", "wrong email and Password  ");
			return "login";
		}
	
		
	}
	
	@GetMapping("logout")
	public String sessionInvalidate(HttpSession session,Model m)
	{
		session.invalidate();
		m.addAttribute("log", "login");
		m.addAttribute("signup", "signup");
		return"home";
	}
	
	
}
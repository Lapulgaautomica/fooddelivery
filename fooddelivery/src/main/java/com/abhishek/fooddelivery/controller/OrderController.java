package com.abhishek.fooddelivery.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abhishek.fooddelivery.beans.Cart;
import com.abhishek.fooddelivery.beans.OrderDTO;
import com.abhishek.fooddelivery.service.CartService;
import com.abhishek.fooddelivery.service.OrderService;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
public class OrderController {
	@Autowired
	private CartService service;
	@Autowired
	private OrderService orderService;
	
	@PostMapping("checkoutorder")
	public String checkoutorder(OrderDTO dto, int cartId,Model m)
	{
		System.out.println(dto);
		
		orderService.saveOrder(dto);
		Cart cart=service.getCartByIdl(cartId);
		service.deleteById(cartId);
		
	    List<Cart> list=service.getCartByEmail(dto.getUserEmail()); 

		  if(list.isEmpty())
		    {
		    	m.addAttribute("empty", "you dont have any item in cart");
		    	
		    	return "cart";
		    }
		    else {
		      	m.addAttribute("cartlist", list);
		      	m.addAttribute("orderlist", list);
		    	m.addAttribute("empty", "");
				m.addAttribute("cart", "cart");	
				m.addAttribute("orders", "orders");	
			
				m.addAttribute("logout", "logout");	
		    	m.addAttribute("empty", "");
		    	return "cart";
			}
	
		
		
	}
	
	@RequestMapping("showorder")
	public String showorder( String email,Model m) {
		List< OrderDTO> list=orderService.getOrderByEmail(email);
		System.out.println(list);
		
		  if(list.isEmpty())
		    {
		    	m.addAttribute("empty", "you dont have any Orders");
				m.addAttribute("cart", "cart");	
				m.addAttribute("orders", "orders");	
	
				m.addAttribute("logout", "logout");	
		    	return "orders";
		    }
		    else {
		      	m.addAttribute("orderlist", list);
		    	m.addAttribute("empty", "");
				m.addAttribute("cart", "cart");	
				m.addAttribute("orders", "orders");	
			
				m.addAttribute("logout", "logout");	
		    	return "orders";
			}

	}
	
	@RequestMapping("delete")
	public String cancelOrde(int id,String email,Model m)
	{
		orderService.deleteOrderById(id);
		
	  return"redirect:/showorder?email="+email+"";
	 
	}
	
	
	
	
	
	
	
	
	/*   	  */
	
	

}

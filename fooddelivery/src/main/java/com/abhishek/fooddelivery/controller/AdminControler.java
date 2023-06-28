package com.abhishek.fooddelivery.controller;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.abhishek.fooddelivery.beans.Food;
import com.abhishek.fooddelivery.beans.Restaurent;
import com.abhishek.fooddelivery.service.FoodService;
import com.abhishek.fooddelivery.service.RestaurentService;
@Controller
public class AdminControler {
	@Autowired
	private RestaurentService service;
	@RequestMapping("adminhome")
	public String adminhome( Model m)
	{
		m.addAttribute("log", "");
		m.addAttribute("signup", "");			
		m.addAttribute("logout", "logout");	
		m.addAttribute("addres", "Add Restaurents");
		return"adminhome";
	}
	
	@RequestMapping("addrestaurents")
	public String addRestaurant(HttpSession session,Model m)
	{
		if( session.getAttribute("email")==null) {
			m.addAttribute("log", "login");
			m.addAttribute("signup", "signup");
			return "login";
			}
			else 
			{
				m.addAttribute("log", "");
				m.addAttribute("signup", "");			
				m.addAttribute("logout", "logout");	
				m.addAttribute("cart", "cart");	
				return "addrestaurents";
			}
	}
	@PostMapping("saverestaurent")
	public String saveRestaurent(Restaurent restaurent) {	
		service.saveRestaurent(restaurent);
		return "addrestaurents";
	}
	
	@GetMapping("showrestaurents")
	public String showrestaurents(Model m,HttpSession session,String msg,String email){
		List<Restaurent> list=service.showrestaurents();
		System.out.println(list);
		m.addAttribute("list", list);
		
		if("admin123@gmail.com".equals(email))
				{
					m.addAttribute("saved", msg);	
					m.addAttribute("showrestuarents","add restuarents" );
					return "restaurents";
				}
	
		if( session.getAttribute("email")==null) 
		{
			m.addAttribute("log", "login");
			m.addAttribute("signup", "signup");
			return "restaurents";
		}
		else 
		{
				m.addAttribute("log", "");
				m.addAttribute("signup", "");			
				m.addAttribute("logout", "logout");	
				m.addAttribute("cart", "cart");	
				m.addAttribute("orders", "orders");	
			
				return "restaurents";
				
		}
		
		
	
	}
	
	
	@Autowired
	private FoodService foodService;
	@PostMapping("savefood")
	public String savefood(Food dto,int restaurentId,String adminemail ,Model m ,HttpSession session) {
		List<Food> food=new ArrayList<Food>();
		Restaurent rest=service.getRestById(restaurentId).get();
		
		if(rest.getFood()!=null)
		{
			List<Food>preFood=rest.getFood();
			food.addAll(preFood);
			food.add(dto);
			rest.setFood(food);
			service.saveRestaurent(rest);
			
			
		}
		else
		{
			
		food.add(dto);
		rest.setFood(food);
		service.saveRestaurent(rest);
		//foodService.saveFood(dto);
		m.addAttribute("saved","Item Saved Successfully");
	
	

		}		
	
		
		return"redirect:showrestaurents?msg=Item Saved Successfully'";
	}
	

}

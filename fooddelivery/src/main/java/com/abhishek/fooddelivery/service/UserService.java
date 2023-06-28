package com.abhishek.fooddelivery.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.abhishek.fooddelivery.beans.User;
import com.abhishek.fooddelivery.repository.UserDAO;
@Service

public class UserService {

	@Autowired
	private UserDAO userdao;
	
	public void saveUser(User userDto) {
		userdao.save(userDto);
		
	}
	
	
	public User checkUser(String userEmail,String userPassWord) {
		User user=userdao.findByUserEmailAndUserPassWord(userEmail,userPassWord);

		
		return user;	
		}
	

}

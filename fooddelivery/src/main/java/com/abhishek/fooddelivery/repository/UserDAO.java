package com.abhishek.fooddelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhishek.fooddelivery.beans.User;

@Repository
public interface UserDAO  extends JpaRepository<User, Integer>
{

	public User findByUserEmailAndUserPassWord(String userEmail, String userPassWord);
	
}

package com.abhishek.fooddelivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.abhishek.fooddelivery.beans.OrderDTO;
import com.abhishek.fooddelivery.repository.OrderDAO;

@Service
public class OrderService {
	@Autowired
	private OrderDAO dao;
	
	public void saveOrder(OrderDTO dto) {
		
		dao.save(dto);
		System.out.println("saved susccesed");
		
	}

	public List<OrderDTO> getOrderByEmail(String email) {
		List<OrderDTO> list=dao.findByUserEmail(email);
		return list;
	}

	public void deleteOrderById(int id) {
		dao.deleteById(id);

	}

}

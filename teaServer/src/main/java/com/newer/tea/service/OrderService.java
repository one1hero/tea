package com.newer.tea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newer.tea.Order;
import com.newer.tea.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository mongo;
	
	public void subOrder(Order order) {
		mongo.insert(order);
	}
	
	

}

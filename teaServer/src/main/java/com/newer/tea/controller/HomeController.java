package com.newer.tea.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newer.tea.From;
import com.newer.tea.Order;
import com.newer.tea.service.FromService;
import com.newer.tea.service.OrderService;

@RestController
@RequestMapping("/tea/v1")
@CrossOrigin
public class HomeController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	FromService fromService;
	
	@GetMapping("/")
	public From home(){
		return fromService.orderFrom();
	}
	
	@PostMapping("/add")
	public HashMap<String, String> addOrder(@RequestBody Order order){
		HashMap<String, String> map = new HashMap<>();
		orderService.subOrder(order);
		
		return null;
	}

}

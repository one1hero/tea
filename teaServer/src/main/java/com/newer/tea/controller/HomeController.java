package com.newer.tea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newer.tea.From;
import com.newer.tea.service.FromService;
import com.newer.tea.service.OrderService;

@RestController
public class HomeController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	FromService fromService;
	
	@GetMapping("/")
	public From home(){
		return fromService.orderFrom();
	}

}

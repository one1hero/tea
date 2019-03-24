package com.newer.tea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newer.tea.From;
import com.newer.tea.Order;
import com.newer.tea.OutOrder;
import com.newer.tea.SalesVolume;
import com.newer.tea.service.FromService;
import com.newer.tea.service.OrderService;
import com.newer.tea.service.ViewService;

@RestController
@RequestMapping("/tea/v1")
@CrossOrigin
public class HomeController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	FromService fromService;
	
	@Autowired
	ViewService viewService;
	
	@GetMapping("/from")
	public From home(){
		return fromService.orderFrom();
	}
	
	@PostMapping("/add")
	public void addOrder(@RequestBody Order order){
		System.out.println(order);
		orderService.subOrder(order);
	}
	
	@GetMapping("/orderlist/{page}")
	public List<Object> orderList(@PathVariable("page") int page){
		return orderService.loadOrderPage(page);
	}
	
	@PostMapping("/out")
	public void updateOrder(@RequestBody OutOrder order) {
		orderService.outOrder(order);
	}
	
	@GetMapping("/outOrderlist/{page}")
	public List<Object> loadOutOrder(@PathVariable("page") int page){
		return orderService.loadOutOrderPage(page);
	}
	
	@GetMapping("/viewdata")
	public List<SalesVolume> loadData(){
		return viewService.getData();
	}

}

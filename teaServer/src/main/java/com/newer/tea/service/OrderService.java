package com.newer.tea.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.newer.tea.Order;
import com.newer.tea.PageableModel;
import com.newer.tea.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository mongo;

	/**
	 * 下单
	 * 
	 * @param order
	 */
	public void subOrder(Order order) {
		mongo.insert(order);
	}

	/**
	 * 查询
	 * 
	 * @return
	 */
	public List<Object> loadOrderPage(Integer currentPage) {
		Page<Order> page = mongo.findAll(new PageableModel(currentPage, 5));
		List<Object> list = new ArrayList<>();
		list.add(page.getTotalPages());
		list.add(page.getContent());
		return list;
	}

}

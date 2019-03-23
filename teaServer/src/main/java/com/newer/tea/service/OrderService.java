package com.newer.tea.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.newer.tea.Order;
import com.newer.tea.OutOrder;
import com.newer.tea.PageableModel;
import com.newer.tea.repository.MongoAutoidUtil;
import com.newer.tea.repository.OrderRepository;
import com.newer.tea.repository.OutOrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository mongo;
	
	@Autowired
	MongoAutoidUtil mongoAutoidUtil;
	
	@Autowired
	OutOrderRepository outOrderRep;

	/**
	 * 下单
	 * 
	 * @param order
	 */
	public void subOrder(Order order) {
		order.setId(mongoAutoidUtil.getNextSequence("seq_article"));
		mongo.insert(order);
	}

	/**
	 * 查询订单表
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
	
	
	/**
	 * 出货
	 * @param order
	 */
	public void outOrder(OutOrder order) {
		mongo.deleteById(order.getId());
		outOrderRep.insert(order);
	}
	
	/**
	 * 出货表分页查询
	 * @param currentPage
	 * @return
	 */
	public List<Object> loadOutOrderPage(Integer currentPage){
		Page<OutOrder> page = outOrderRep.findAll(new PageableModel(currentPage, 5));
		List<Object> list = new ArrayList<>();
		list.add(page.getTotalPages());
		list.add(page.getContent());
		return list;
	}

}

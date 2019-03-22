package com.newer.tea.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.newer.tea.OutOrder;

public interface OutOrderRepository extends MongoRepository<OutOrder, Integer>{
	

}

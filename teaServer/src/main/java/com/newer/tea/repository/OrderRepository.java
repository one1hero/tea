package com.newer.tea.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.newer.tea.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, Integer>{

}

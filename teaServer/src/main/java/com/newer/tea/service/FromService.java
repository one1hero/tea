package com.newer.tea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newer.tea.From;
import com.newer.tea.repository.FromRepository;

@Service
public class FromService {
	
	@Autowired
	FromRepository mongo;
	
	public From orderFrom(){
		return mongo.findAll().get(0);
	}

}

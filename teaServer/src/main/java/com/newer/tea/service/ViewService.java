package com.newer.tea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newer.tea.SalesVolume;
import com.newer.tea.mapper.SvMapper;

@Service
public class ViewService {
	
	@Autowired
	SvMapper mapper;

	public List<SalesVolume> getData(){
		return mapper.loadAll();
	}
}

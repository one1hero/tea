package com.newer.tea;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

public class PageableModel implements Pageable {

	// 当前页
	private Integer pagenumber;
	// 当前页面条数
	private Integer pagesize;
	// 排序条件
	private Sort sort;
	
	@SuppressWarnings("deprecation")
	public PageableModel(Integer pagenumber,Integer pagesize) {
		this.pagenumber = pagenumber;
		this.pagesize = pagesize;
		List<Order> orders = new ArrayList<Order>();  //排序
	    orders.add(new Order(Direction.DESC, "id"));
	    sort = new Sort(orders);
	}
	
	

	public Integer getPagenumber() {
		return pagenumber;
	}

	public void setPagenumber(Integer pagenumber) {
		this.pagenumber = pagenumber;
	}

	public Integer getPagesize() {
		return pagesize;
	}

	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}

	@Override
	public int getPageNumber() {
		return getPagenumber();
	}

	@Override
	public int getPageSize() {
		return getPagesize();
	}

	@Override
	public long getOffset() {
		return (getPagenumber() - 1) * getPagesize();
	}

	@Override
	public Sort getSort() {
		return sort;
	}

	@Override
	public Pageable next() {
		return null;
	}

	@Override
	public Pageable previousOrFirst() {
		return null;
	}

	@Override
	public Pageable first() {
		return null;
	}

	@Override
	public boolean hasPrevious() {
		return false;
	}

}

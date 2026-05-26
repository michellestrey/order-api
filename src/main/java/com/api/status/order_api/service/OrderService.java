package com.api.status.order_api.service;

import org.springframework.stereotype.Service;

import com.api.status.order_api.repository.OrderRepository;

@Service
public class OrderService {
	
	private final OrderRepository repository;
	
	public OrderService(OrderRepository repository) {
		this.repository = repository;
	}

}

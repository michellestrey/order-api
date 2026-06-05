package com.api.status.order_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.status.order_api.dto.CreateOrderDTO;
import com.api.status.order_api.dto.ResponseOrderDTO;
import com.api.status.order_api.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	
	private final OrderService orderService;
	
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@PostMapping
	public ResponseEntity<ResponseOrderDTO> create(@RequestBody CreateOrderDTO dto){
				ResponseOrderDTO response = orderService.cadastrar(dto);
				return ResponseEntity
						.status(HttpStatus.CREATED)
						.body(response);
	}

	

}

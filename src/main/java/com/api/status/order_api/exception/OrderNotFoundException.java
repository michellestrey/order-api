package com.api.status.order_api.exception;

public class OrderNotFoundException extends RuntimeException{

	public OrderNotFoundException(Long id) {
		super("Pedido não encontrado. ID: " + id);
	}
}

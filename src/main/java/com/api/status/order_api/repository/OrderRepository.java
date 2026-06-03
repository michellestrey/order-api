package com.api.status.order_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.status.order_api.dto.CreateOrderDTO;
import com.api.status.order_api.dto.ResponseOrderDTO;
import com.api.status.order_api.model.entity.Order;
import com.api.status.order_api.model.enums.OrderStatus;

public interface OrderRepository  extends JpaRepository<Order, Long>{
	
	List<Order> findByStatus(OrderStatus status);
	
	List<Order> findByStatusAndCustomerName(
			OrderStatus status,
			String customerName);

	


}

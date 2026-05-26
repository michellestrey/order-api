package com.api.status.order_api.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.api.status.order_api.model.enums.OrderStatus;

public record ResponseOrderDTO(
		
		Long id,
		String CustomerName,
		LocalDateTime createdAt,
	    BigDecimal TotalAmount,
	    OrderStatus status
		
		
		) {

}

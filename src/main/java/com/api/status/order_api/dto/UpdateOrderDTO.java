package com.api.status.order_api.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.api.status.order_api.model.enums.OrderStatus;

public record UpdateOrderDTO(
		
		String CustomerName,
	    BigDecimal TotalAmount,
	    LocalDateTime updatedAt,
		OrderStatus status
		
		) {
	
	

}

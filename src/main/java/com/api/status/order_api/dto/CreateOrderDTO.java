package com.api.status.order_api.dto;

import java.math.BigDecimal;

public record CreateOrderDTO(
		
		 String CustomerName,
		 BigDecimal totalAmount
		) {
	
	

}

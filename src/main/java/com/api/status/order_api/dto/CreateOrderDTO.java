package com.api.status.order_api.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateOrderDTO(
		 @NotNull
		 String customerName,
		 @Positive
		 BigDecimal totalAmount
		) {
	
	

}

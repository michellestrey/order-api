package com.api.status.order_api.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.api.status.order_api.model.enums.OrderStatus;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ResponseOrderDTO(
		
		Long id,
		@NotNull
		String customerName,
		LocalDateTime createdAt,
		@Positive
		@NotNull
	    BigDecimal TotalAmount,
	    @NotNull
	    OrderStatus status,
	    @NotNull
	    String description
		
		
		) {



}

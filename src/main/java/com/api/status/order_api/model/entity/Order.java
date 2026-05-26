package com.api.status.order_api.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.api.status.order_api.model.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table(name = "orders")
public class Order {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, length= 50)
	private String CustomerName;
	
    @Column(name = "criada_em", nullable =false, updatable = false) 
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime createdAt;
	@Column(nullable = false)
    private BigDecimal totalAmount;
	
	private LocalDateTime updatedAt;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private OrderStatus status = OrderStatus.CREATED;
	
	@PreUpdate
	public void preUpdate() {
	    this.updatedAt = LocalDateTime.now();
	}
	

}

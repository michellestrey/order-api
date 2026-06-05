package com.api.status.order_api.service;

import org.springframework.stereotype.Service;

import com.api.status.order_api.dto.CreateOrderDTO;
import com.api.status.order_api.dto.ResponseOrderDTO;
import com.api.status.order_api.dto.UpdateOrderDTO;
import com.api.status.order_api.exception.BusinessException;
import com.api.status.order_api.exception.OrderNotFoundException;
import com.api.status.order_api.model.entity.Order;
import com.api.status.order_api.model.enums.OrderStatus;
import com.api.status.order_api.repository.OrderRepository;

@Service
public class OrderService {
	
	private final OrderRepository orderRepository;
	
	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	public ResponseOrderDTO cadastrar(CreateOrderDTO dto) {
	    Order order = new Order();
	    order.setCustomerName(dto.customerName());
	    order.setTotalAmount(dto.totalAmount());
	    order.setStatus(OrderStatus.CREATED);
		Order savedOrder = orderRepository.save(order);
		return new ResponseOrderDTO(
				savedOrder.getId(),
				savedOrder.getCustomerName(),
				savedOrder.getCreatedAt(),
				savedOrder.getTotalAmount(),
			    savedOrder.getStatus(),
			    savedOrder.getStatus().getDescription()		
			    );		
	}
	
	public ResponseOrderDTO buscarPorId(Long id) {
		Order order = orderRepository.findById(id)
				.orElseThrow( ()-> new OrderNotFoundException(id));
		
		 return new ResponseOrderDTO(
				order.getId(),
				order.getCustomerName(),
				order.getCreatedAt(),
				order.getTotalAmount(),
				order.getStatus(),
				order.getStatus().getDescription()
				 );
		}
	
	  public ResponseOrderDTO atualizar(Long id, UpdateOrderDTO dto) {
		  Order order = orderRepository.findById(id)
				  .orElseThrow(()-> new OrderNotFoundException(id));
		  
		  if(!order.getStatus().canTransitionTo(dto.status())) {
			  throw new BusinessException("Transição inválida");
		  }
		  
		  order.setStatus(dto.status());
		  Order updateOrder = orderRepository.save(order);
		  return new ResponseOrderDTO(
					updateOrder.getId(),
					updateOrder.getCustomerName(),
					updateOrder.getCreatedAt(),
					updateOrder.getTotalAmount(),
					updateOrder.getStatus(),
					updateOrder.getStatus().getDescription()			
					);
	    }
	   
	  public void deletar(Long id) {
		  Order order = orderRepository.findById(id)
				  .orElseThrow(()-> new OrderNotFoundException(id));
		  orderRepository.delete(order);
		  
		  
	  }
	 
	
	
}

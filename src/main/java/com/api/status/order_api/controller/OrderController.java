package com.api.status.order_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.status.order_api.dto.CreateOrderDTO;
import com.api.status.order_api.dto.ResponseOrderDTO;
import com.api.status.order_api.dto.UpdateOrderDTO;
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
    @GetMapping("/{id}")
	public ResponseEntity<ResponseOrderDTO> getById(@PathVariable Long id){
    	return ResponseEntity.ok(orderService.buscarPorId(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ResponseOrderDTO> update(@PathVariable Long id, 
    		                                      @RequestBody UpdateOrderDTO dto){
    	return ResponseEntity.ok(orderService.atualizar(id, dto));
    	
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
    	orderService.deletar(id);
    	return ResponseEntity.noContent().build();
    	}
    
    // IMPLEMENTAR PATCH NO FUTURO
}

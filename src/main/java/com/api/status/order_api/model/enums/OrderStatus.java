package com.api.status.order_api.model.enums;

public enum OrderStatus {
   
	CREATED("Pedido criado"),
	CONFIRMED("Pedido confirmado"),
    SHIPPED("Pedido enviado"), 
    DELIVERED("Pedido entregue"), 
    CANCELED("Pedido cancelado");
    
	private final String description;
	
	OrderStatus(String description){
		this.description = description;
	}
 
    public String getDescription() {
       return description;
       }
    
    public boolean canTransitionTo(OrderStatus newStatus) {

        return switch (this) {

            case CREATED ->
                    newStatus == CONFIRMED ||
                    newStatus == CANCELED;

            case CONFIRMED ->
                    newStatus == SHIPPED ||
                    newStatus == CANCELED;

            case SHIPPED ->
                    newStatus == DELIVERED;

            case DELIVERED, CANCELED ->
                    false;
        };
    }
    
    
    
}
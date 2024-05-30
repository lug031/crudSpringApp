package com.example.client_service.mapper;

import com.example.client_service.controller.dto.OrderDto;
import com.example.client_service.repository.entity.OrderEntity;

public class OrderMapper {

	public static OrderDto mapToOrderDto(OrderEntity orderEntity) {
		return new OrderDto(
				orderEntity.getId(),
				orderEntity.getClientId(),
				orderEntity.getProductId(),
				orderEntity.getQuantity(),
				orderEntity.getPrice(),
				orderEntity.getOrderDate()
				);
	}
	
	public static OrderEntity mapToOrderEntity(OrderDto orderDto) {
		return new OrderEntity(
				orderDto.id(),
				orderDto.clientId(),
				orderDto.productId(),
				orderDto.quantity(),
				orderDto.price(),
				orderDto.orderDate()
				);
	}
}

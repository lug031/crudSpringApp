package com.example.client_service.service;

import com.example.client_service.controller.dto.OrderDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderService {
	Mono<OrderDto> createOrder(OrderDto orderDto);
    Mono<OrderDto> getOrderById(String id);
    Flux<OrderDto> getAllOrders();
    Mono<OrderDto> updateOrder(String id, OrderDto orderDto);
    Mono<Void> deleteOrderById(String id);
}

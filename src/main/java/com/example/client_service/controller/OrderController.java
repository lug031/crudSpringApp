package com.example.client_service.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.client_service.controller.dto.OrderDto;
import com.example.client_service.service.OrderService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {

	private final OrderService orderService;

    @PostMapping
    public Mono<OrderDto> createOrder(@Valid @RequestBody OrderDto orderDto) {
        return orderService.createOrder(orderDto);
    }

    @GetMapping("/{id}")
    public Mono<OrderDto> getOrderById(@PathVariable String id) {
        return orderService.getOrderById(id);
    }

    @GetMapping
    public Flux<OrderDto> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PutMapping("/{id}")
    public Mono<OrderDto> updateOrder(@PathVariable String id, @Valid @RequestBody OrderDto orderDto) {
        return orderService.updateOrder(id, orderDto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteOrderById(@PathVariable String id) {
        return orderService.deleteOrderById(id);
    }
}

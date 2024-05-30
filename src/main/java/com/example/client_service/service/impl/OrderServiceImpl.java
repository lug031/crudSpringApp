package com.example.client_service.service.impl;

import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.client_service.controller.dto.OrderDto;
import com.example.client_service.error.LocalNotFoundException;
import com.example.client_service.mapper.OrderMapper;
import com.example.client_service.repository.OrderRepository;
import com.example.client_service.repository.entity.OrderEntity;
import com.example.client_service.service.ClientService;
import com.example.client_service.service.OrderService;
import com.example.client_service.service.ProductService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService{
	
	private final OrderRepository orderRepository;
    private final ClientService clientService;
    private final ProductService productService;
    
    @Override
    @Transactional
    public Mono<OrderDto> createOrder(OrderDto orderDto) {
        return Mono.zip(
                clientService.clientExists(orderDto.clientId()),
                productService.productExists(orderDto.productId())
        ).flatMap(existsTuple -> {
            boolean clientExists = existsTuple.getT1();
            boolean productExists = existsTuple.getT2();

            if (!clientExists) {
                return Mono.error(new LocalNotFoundException("Client not found with id " + orderDto.clientId()));
            }

            if (!productExists) {
                return Mono.error(new LocalNotFoundException("Product not found with id " + orderDto.productId()));
            }

            OrderEntity orderEntity = OrderMapper.mapToOrderEntity(orderDto);

            return orderRepository.save(orderEntity)
                    .map(OrderMapper::mapToOrderDto);
        });
    }

    @Override
    public Mono<OrderDto> getOrderById(String id) {
        return orderRepository.findById(id)
        		.switchIfEmpty(Mono.error(new LocalNotFoundException("Order not found with id " + id)))
                .map(OrderMapper::mapToOrderDto);
    }

    @Override
    public Flux<OrderDto> getAllOrders() {
        return orderRepository.findAll()
                .map(OrderMapper::mapToOrderDto);
    }

    @Override
    @Transactional
    public Mono<OrderDto> updateOrder(String id, OrderDto orderDto) {
        return orderRepository.findById(id)
                .flatMap(existingOrder -> {
                    return clientService.clientExists(orderDto.clientId())
                            .flatMap(clientExists -> {
                                if (!clientExists) {
                                    return Mono.error(new LocalNotFoundException("Client with ID " + orderDto.clientId() + " not found"));
                                }
                                return productService.productExists(orderDto.productId())
                                        .flatMap(productExists -> {
                                            if (!productExists) {
                                                return Mono.error(new LocalNotFoundException("Product with ID " + orderDto.productId() + " not found"));
                                            }
                                            OrderEntity updatedOrderEntity = OrderMapper.mapToOrderEntity(orderDto);
                                            updatedOrderEntity.setId(existingOrder.getId());
                                            return orderRepository.save(updatedOrderEntity)
                                                    .map(OrderMapper::mapToOrderDto);
                                        });
                            });
                });
    }

    @Override
    public Mono<Void> deleteOrderById(String id) {
        return orderRepository.findById(id)
                .switchIfEmpty(Mono.error(new InvalidDataAccessApiUsageException("Order not found with id " + id)))
                .flatMap(orderRepository::delete);
    }
}

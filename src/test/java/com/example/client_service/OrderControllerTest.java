package com.example.client_service;

import com.example.client_service.controller.OrderController;
import com.example.client_service.controller.dto.OrderDto;
import com.example.client_service.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

class OrderControllerTest {

    private OrderService orderServiceMock;
    private OrderController orderController;

    @BeforeEach
    void setUp() {
        orderServiceMock = Mockito.mock(OrderService.class);
        orderController = new OrderController(orderServiceMock);

        OrderDto mockOrder = new OrderDto("order1", 1, 1, 20, 2.3, "2024-06-01T08:00:00");

        Mockito.when(orderServiceMock.createOrder(Mockito.any(OrderDto.class))).thenReturn(Mono.just(mockOrder));
        Mockito.when(orderServiceMock.getOrderById("order1")).thenReturn(Mono.just(mockOrder));
        Mockito.when(orderServiceMock.getAllOrders()).thenReturn(Flux.just(mockOrder));
        Mockito.when(orderServiceMock.updateOrder(Mockito.eq("order1"), Mockito.any(OrderDto.class))).thenReturn(Mono.just(mockOrder));
        Mockito.when(orderServiceMock.deleteOrderById("order1")).thenReturn(Mono.empty());
    }

    @Test
    void createOrder() {
        OrderDto newOrder = new OrderDto("order1", 1, 1, 20, 2.3, "2024-06-01T08:00:00");

        Mono<OrderDto> response = orderController.createOrder(newOrder);

        StepVerifier.create(response)
                .expectNextMatches(order -> order.id().equals("order1"))
                .verifyComplete();
    }

    @Test
    void getOrderById() {
        Mono<OrderDto> response = orderController.getOrderById("order1");

        StepVerifier.create(response)
                .expectNextMatches(order -> order.id().equals("order1"))
                .verifyComplete();
    }

    @Test
    void getAllOrders() {
        Flux<OrderDto> response = orderController.getAllOrders();

        StepVerifier.create(response)
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    void updateOrder() {
        OrderDto updatedOrder = new OrderDto("order1", 1, 1, 49, 2.3, "2024-06-01T08:00:00");

        Mono<OrderDto> response = orderController.updateOrder("order1", updatedOrder);

        StepVerifier.create(response)
                .expectNextMatches(order -> order.id().equals("order1") && order.productId().equals(1))
                .verifyComplete();
    }

    @Test
    void deleteOrderById() {
        Mono<Void> response = orderController.deleteOrderById("order1");

        StepVerifier.create(response)
                .verifyComplete();
    }
}

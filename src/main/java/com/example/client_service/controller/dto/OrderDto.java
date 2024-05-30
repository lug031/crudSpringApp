package com.example.client_service.controller.dto;

public record OrderDto(String id, Integer clientId, Integer productId, Integer quantity, Double price, String orderDate)  {

}

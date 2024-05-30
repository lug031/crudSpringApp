package com.example.client_service.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.client_service.repository.entity.OrderEntity;


public interface OrderRepository extends ReactiveMongoRepository<OrderEntity, String>{

}

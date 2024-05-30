package com.example.client_service.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import com.example.client_service.repository.entity.ProductEntity;

public interface ProductRepository extends R2dbcRepository<ProductEntity, Integer>{

}

package com.example.client_service.service;

import com.example.client_service.controller.dto.ProductDto;
import com.example.client_service.error.LocalNotFoundException;

import reactor.core.publisher.Mono;

public interface ProductService {
	
	Mono<ProductDto> getProduct(Integer productId) throws LocalNotFoundException;
	
	Mono<ProductDto> createProduct(ProductDto productDto);
	
	Mono<ProductDto> updateProduct(Integer productId, ProductDto productDto);
	
	Mono<Void> deleteProduct(Integer productId);
	
	Mono<Boolean> productExists(Integer productId);
}

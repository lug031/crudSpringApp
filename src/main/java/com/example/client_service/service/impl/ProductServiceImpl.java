package com.example.client_service.service.impl;

import org.springframework.stereotype.Service;

import com.example.client_service.controller.dto.ProductDto;
import com.example.client_service.error.LocalNotFoundException;
import com.example.client_service.mapper.ProductMapper;
import com.example.client_service.repository.ProductRepository;
import com.example.client_service.repository.entity.ProductEntity;
import com.example.client_service.service.ProductService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{

	private final ProductRepository productRepository;
	
	@Override
    public Mono<ProductDto> getProduct(Integer productId) throws LocalNotFoundException {
        return productRepository.findById(productId)
                .switchIfEmpty(Mono.error(new LocalNotFoundException("Product not found with id " + productId)))
                .map(ProductMapper::mapToProductDto);
    }

    @Override
    public Mono<ProductDto> createProduct(ProductDto productDto) {
        ProductEntity productEntity = ProductMapper.mapToProductEntity(productDto);
        return productRepository.save(productEntity)
                .map(ProductMapper::mapToProductDto);
    }

    @Override
    public Mono<ProductDto> updateProduct(Integer productId, ProductDto productDto) {
        ProductEntity productEntity = ProductMapper.mapToProductEntity(productDto);
        productEntity.setId(productId);
        return productRepository.save(productEntity)
                .map(ProductMapper::mapToProductDto);
    }

    @Override
    public Mono<Void> deleteProduct(Integer productId) {
        return productRepository.findById(productId)
                .switchIfEmpty(Mono.error(new LocalNotFoundException("Product not found with id " + productId)))
                .flatMap(productRepository::delete);
    }

    @Override
    public Mono<Boolean> productExists(Integer productId) {
        return productRepository.existsById(productId);
    }

}

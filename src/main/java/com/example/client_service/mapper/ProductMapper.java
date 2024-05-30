package com.example.client_service.mapper;

import com.example.client_service.controller.dto.ProductDto;
import com.example.client_service.repository.entity.ProductEntity;

public class ProductMapper {
	public static ProductDto mapToProductDto(ProductEntity productEntity) {
		return new ProductDto(
				productEntity.getId(),
				productEntity.getName(),
				productEntity.getPrice(),
				productEntity.getBrand()
				);
	}
	
	public static ProductEntity mapToProductEntity(ProductDto productDto) {
		return new ProductEntity(
				productDto.id(),
				productDto.name(),
				productDto.price(),
				productDto.brand()
				);
	}
}
